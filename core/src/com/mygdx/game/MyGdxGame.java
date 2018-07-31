package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;
import com.mygdx.game.armor.LeatherArmor;
import com.mygdx.game.build.Map;
import com.mygdx.game.build.Room;
import com.mygdx.game.build.Terrain;
import com.mygdx.game.build.TexturePack;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.generators.ArmorGenerator;
import com.mygdx.game.generators.EnemyGenerator;
import com.mygdx.game.generators.RoomGenerator;
import com.mygdx.game.generators.WeaponGenerator;
import com.mygdx.game.interfaces.Armor;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.objects.Door;
import com.mygdx.game.objects.Entity;
import com.mygdx.game.playable.Hero;
import com.mygdx.game.playable.Orc;
import com.mygdx.game.tools.*;
import com.mygdx.game.weaponry.IronSword;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch, Obatch;
	OrthographicCamera cam;
	TexturePack texturePack;
	RoomGenerator roomGenerator;
	EnemyGenerator enemyGenerator;
	Door door;
	int turn;
	final Matrix4 matrix = new Matrix4();
	final Matrix4 Omatrix = new Matrix4();
	Texture texture;
	PriorityQueue queque;//sorted by initiative
	InitiativeSorter sorter;
	Room room, genRoom;
	GameObject enemy, enemy1, enemy2;
	GameObject current;
	GameObject player, wall;
	Map map;
	final Plane xzPlane = new Plane(new Vector3(0,1,0), 0);
    final Vector3 intersection = new Vector3();
    final Vector3 curr = new Vector3();
    final Vector3 last = new Vector3(-1,-1,-1);
    final Vector3 delta = new Vector3();
    Sprite lastSelectedTile = null;
    GameObject lastSelectedObject = null;
    Terrain lastSelectedTerrain = null;
	@Override
	public void create () {
        WeaponGenerator weaponGenerator = new WeaponGenerator();
        ArmorGenerator armorGenerator = new ArmorGenerator();

        texturePack = new TexturePack();
        roomGenerator = new RoomGenerator(texturePack);

        genRoom = roomGenerator.generateRoom(10, 10);
		room = genRoom;
        enemyGenerator = new EnemyGenerator(texturePack);
        door = new Door(texturePack.getDoor(), room, roomGenerator.generateRoom(10,10));

		cam = new OrthographicCamera(10 * 1.3f, 10 *(Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth()));
		cam.position.set(5,5,10);
		cam.direction.set(-1,-1,-1);
		cam.near = 1;
		cam.far = 500;
		matrix.setToRotation(new Vector3(1,0,0), 90);

        Sprite sprite = new Sprite(texturePack.getFloor_min());
        sprite.setSize(1,1 * (Gdx.graphics.getWidth()/Gdx.graphics.getHeight()));
		Terrain terrain = new Terrain(2,"test", texturePack.getHole(), true);
		sprite = terrain.getSprite();
		sprite.setSize(1,1);
		sprite.flip(false, true);


		enemy = enemyGenerator.createEemy(armorGenerator.createArmor(), weaponGenerator.createWeapon());
		enemy1 = enemyGenerator.createEemy(armorGenerator.createArmor(), weaponGenerator.createWeapon());
		enemy2 = enemyGenerator.createEemy(armorGenerator.createArmor(), weaponGenerator.createWeapon());

        sprite = new Sprite(texturePack.getPlayer());
		player = new Hero("Donny", 10, 10,sprite,5, 1,
				0, 10, 16, 14,
				0, Classification.Playable);
		player.equipWeapon(weaponGenerator.createWeapon());
		player.equipArmor(armorGenerator.createArmor());

		sprite = new Sprite(texturePack.getWall_1());
		wall = new Entity("Wall", sprite);


		room.setObject(wall);
		room.setObject(enemy);
		room.setObject(enemy1);
		room.setObject(enemy2);
		room.setObject(player);
		room.setObject(door);
		queque = room.getInitiativeQueue();
		queque.display();
		Printer.show(room);
		//room.move(0,0, 2, 2);

		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(this);
	}



    @Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		batch.setTransformMatrix(matrix);

		batch.begin();
		room.drawMap(batch);
        room.drawObjects(batch);
		batch.end();

		checkTileTouched();
		checkTurnEnded();

	}

    private void checkTurnEnded() {
	    if(!queque.isEmpty() && (current == null || current.getMP() <= 0 || current.getHP() <= 0)) {
                current = queque.remove();
        }else if (queque.isEmpty()){
	    	room.resetMp();
            queque.insert(room.getPlayableObjects());
            turn++;
        }
    }

    private void checkTileTouched() {

	    if(Gdx.input.justTouched()) {

            Ray pickRay = cam.getPickRay(Gdx.input.getX(), Gdx.input.getY());
            Intersector.intersectRayPlane(pickRay, xzPlane, intersection);
            int x = (int) intersection.x ;
            int z = (int) intersection.z;
            Sprite sprite;

            if (x >= 0 && x < 10 && z >= 0 && z < 10) {
               if (lastSelectedTile != null)
                    lastSelectedTile.setColor(1, 1, 1, 1);

                if (x >= 0 && z >= 0 && x < room.getC()&& z < room.getL()) {
                    if (room.getObject(x, z) != null && room.getObject(x, z).getClass() != Entity.class) {
                        sprite = room.getObject(x, z).getSprite();
                        Printer.show(room.getObject(x,z));

                        if(lastSelectedObject != null && lastSelectedObject != room.getObject(x,z) && lastSelectedObject.getMP() > 0 && lastSelectedObject == current){
							lastSelectedObject.getWeapon().makeDamage(lastSelectedObject, room.getObject(x,z));
                            lastSelectedObject.makeStep(1000);//1000 чтобы закончить ход
                            unselect();

                        }else {
                        	if(room.getObject(x, z) == current) {
								lastSelectedObject = room.getObject(x, z);
								PathFinder.drawWays(batch, room, x, z);
							}
                        }
                    } else {
                        Map map = room.getTileMap();
                        sprite = map.getTiles()[x][z].getSprite();
                        if(lastSelectedObject != null && lastSelectedObject.getMP() > 0 && lastSelectedObject == current){
                           if(room.getTileMap().getTiles()[x][z].flag == true && room.move(lastSelectedObject.getX(), lastSelectedObject.getY(), x, z)) {
							   lastSelectedObject.makeStep(room.getTileMap().getTiles()[x][z].getMovementCost());
							   unselect();
						   }
                        }

                       Printer.print("" + map.getTiles()[x][z].getMovementCost()+"\n");
                    }if(sprite != null) {
                        sprite.setColor(1,1,5,25);
                        lastSelectedTile = sprite;
                    }
                }else{
                    unselect();
                }

            }

            update();

        }
	}

	public void update(){

		if(lastSelectedObject == null)
			room.clearTiles();


	}

	public void unselect(){

		lastSelectedObject = null;
		lastSelectedTerrain = null;
		lastSelectedTile = null;

	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode){

			case Input.Keys.ENTER:
				current.makeStep(1000);
				unselect();
				update();
				break;

			case Input.Keys.I:
				room.delete(current.getX(), current.getY());
				current = null;
				lastSelectedObject = null;
				update();
				break;

				case Input.Keys.A:
					room = door.getNextRoom(room);
					door.changeRoom();
					checkTurnEnded();
					current = null;
					lastSelectedObject = null;
					queque = room.getInitiativeQueue();
					break;
					case Input.Keys.K:
						queque.display();
						break;
						case Input.Keys.C:
							Printer.show(current);
							break;

			case Input.Keys.R:
				Printer.show(room);
				break;


		}

		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
	    last.set(-1,-1,-1);
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
	    Ray pickRay = cam.getPickRay(screenX, screenY);
	    Intersector.intersectRayPlane(pickRay, xzPlane, curr);

	    if(!(last.x == -1 && last.y == -1 && last.z == -1)) {
	        pickRay = cam.getPickRay(last.x, last.y);
            Intersector.intersectRayPlane(pickRay, xzPlane, delta);
            delta.sub(curr);
            cam.position.add(delta.x, delta.y, delta.z);
        }
        last.set(screenX, screenY, 0);
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {

	    return false;
	}
}
