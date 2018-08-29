package com.mygdx.game.Scene;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.build.Room;
import com.mygdx.game.interfaces.Armor;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Item;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.tools.Printer;




public class HUD {
    public Stage stage;
    private Viewport viewPort;
    public TextButton endTurnButton;
    private OrthographicCamera camera;
   private TextArea printer;

    Label health;
    Label movementPoints;
    Label initiative;
    Label armorclass;
    Table table;
    Label name, turn;

    public HUD(SpriteBatch batch, final GameScreen gameScreen, Skin skin, int width, int height, int worldWidth, int worldHeight){

        camera = new OrthographicCamera(width, height*(Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth()));

        viewPort = new ScreenViewport(camera);
        stage = new Stage(viewPort, batch);


        table = new Table();
        table.top();
        table.setFillParent(true);

        printer = new TextArea("",skin);
        printer.setDisabled(true);
        printer.setHeight(50);
        final ScrollPane scrollPane = new ScrollPane(null, skin);
       // scrollPane.setForceScroll(false, true);
        scrollPane.setScrollingDisabled(true, false);
       // scrollPane.setFlickScroll(false);
        scrollPane.setOverscroll(false, true);
        //scrollPane.setFadeScrollBars(false);
        scrollPane.setWidget(printer);
        scrollPane.getColor().a = 70;
        scrollPane.setHeight(50);


        final TextButton endTurnButton = new TextButton("End turn",skin, "default" );
        endTurnButton.bottom();
        endTurnButton.right();
        endTurnButton.setFillParent(false);
        endTurnButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){


                gameScreen.keyUp(Input.Keys.ENTER);

            }
        });

        health = new Label("Health", new Label.LabelStyle(new BitmapFont(), Color.RED));
        movementPoints = new Label("Movement Points", new Label.LabelStyle(new BitmapFont(), Color.BLUE));
        initiative = new Label("Initiative", new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        armorclass = new Label("Armor class", new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
        name = new Label("Name", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        turn = new Label("turn", new Label.LabelStyle(new BitmapFont(), Color.TAN));

        table.add(health).expandX().padTop(10);
        table.add(armorclass).expandX().padTop(10);
        table.row();
        table.add(movementPoints).expandX();
        table.add(initiative).expandX();
        table.row();
        table.add(name).expandX();
        table.add(turn).expandX();
        table.row().fillX().expandY().fillY();
        table.add(endTurnButton).expand(true,true).bottom().left().fill(false,false);
        table.add(scrollPane).expandX().bottom().right().size(250,125);
        stage.addActor(table);

    }

    public void show(GameObject gameObject){

        health.setText("" + gameObject.getHP());
        armorclass.setText("" + gameObject.getArmorClass());
        movementPoints.setText("" + gameObject.getMP());
        initiative.setText("" + gameObject.getInitiative());
        name.setText(gameObject.getName());
    }



    public void showTurn(int t){

        this.turn.setText("" + t);

    }

    public void resize(int width, int height){

        viewPort.update(width, height);


    }


    public void print(String message){

        printer.appendText(message+"\n");

    }


}
