package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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
import com.mygdx.game.generators.RoomGenerator;
import com.mygdx.game.generators.WeaponGenerator;
import com.mygdx.game.interfaces.Armor;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.objects.Entity;
import com.mygdx.game.playable.Hero;
import com.mygdx.game.playable.Orc;
import com.mygdx.game.tools.InitiativeSorter;
import com.mygdx.game.tools.PathFinder;
import com.mygdx.game.tools.Printer;
import com.mygdx.game.weaponry.IronSword;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch, Obatch;
	OrthographicCamera cam;
	TexturePack texturePack;
	RoomGenerator roomGenerator;
	final Matrix4 matrix = new Matrix4();
	final Matrix4 Omatrix = new Matrix4();
	Texture texture;
	GameObject[] queque;//sorted by initiative
	InitiativeSorter sorter;
	Room room, genRoom;
	Orc orc;
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

        texturePack = new TexturePack(null);
        roomGenerator = new RoomGenerator();

        genRoom = roomGenerator.generateRoom(10, 10);

        Weapon weapon = new IronSword();

        Armor armor = new LeatherArmor();

		cam = new OrthographicCamera(10 * 1.3f, 10 *(Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth()));
		cam.position.set(5,5,10);
		cam.direction.set(-1,-1,-1);
		cam.near = 1;
		cam.far = 500;
		matrix.setToRotation(new Vector3(1,0,0), 90);

        Sprite sprite = new Sprite(texturePack.getFloor_min());
        sprite.setSize(1,1 * (Gdx.graphics.getWidth()/Gdx.graphics.getHeight()));
		//map = new Map(10, 10, new Terrain(1, "test", sprite));
		Terrain terrain = new Terrain(2,"test", texturePack.getHole(), true);
		sprite = terrain.getSprite();
		sprite.setSize(1,1);
		sprite.flip(false, true);
       // map.addTile(terrain, 1, 3);
		//room = new Room(10,10, map);
		room = genRoom;

		orc = new Orc();
		orc.equipWeapon(weaponGenerator.createWeapon());
		orc.equipArmor(armor);
        sprite = new Sprite(texturePack.getOrc());
        sprite.setSize(1,1);
        sprite.flip(false,true);
        orc.setSprite(sprite);

        sprite = new Sprite(new Texture(Gdx.files.internal("player.png")));
        sprite.setSize(1,1 );
        sprite.flip(false,true);
		player = new Hero("Donny", 50, 10,sprite,5, 1,0);
		player.equipWeapon(weapon);
		player.equipArmor(armor);

		sprite = new Sprite(texturePack.getWall_1());
		sprite.setSize(1,1);
		wall = new Entity("Wall", sprite);


		room.setObject(wall);
		room.setObject(orc);
		room.setObject(player);
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
                    if (room.getObject(x, z) != null && room.getObject(x, z).getClassification() != Classification.OBJECT) {
                        sprite = room.getObject(x, z).getSprite();
                        Printer.show(room.getObject(x,z));

                        if(lastSelectedObject != null && lastSelectedObject != room.getObject(x,z) && lastSelectedObject.getMP() > 0){
                            room.getObject(x, z).takeDamage(lastSelectedObject);
                            lastSelectedObject.makeStep(1);
                            lastSelectedObject = null;

                        }else {
                            lastSelectedObject = room.getObject(x, z);
                            PathFinder.drawWays(batch, room, x, z);
                        }
                    } else {
                        Map map = room.getTileMap();
                        sprite = map.getTiles()[x][z].getSprite();
                        if(lastSelectedObject != null && lastSelectedObject.getMP() > 0){
                           if(room.getTileMap().getTiles()[x][z].flag == true && room.move(lastSelectedObject.getX(), lastSelectedObject.getY(), x, z)) {
							   lastSelectedObject.makeStep(room.getTileMap().getTiles()[x][z].getMovementCost());
							   lastSelectedObject = null;
							   sprite = null;
						   }
                        }

                       Printer.print("" + map.getTiles()[x][z].getMovementCost()+"\n");
                    }if(sprite != null) {
                        sprite.setColor(1,1,5,25);
                        lastSelectedTile = sprite;
                    }
                }else{
                    lastSelectedObject = null;
                    lastSelectedTile = null;
                }

            }

            update();

        }
	}

	public void update(){

		if(lastSelectedObject == null)
			room.clearTiles();


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
