package com.mygdx.game.scene;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.screens.GameScreen;




public class HUD {
    public Stage stage;
    private Viewport viewPort;
    private CharacterInfoDialog characterInfoDialog;
    private Image currentSprite;
    public TextButton endTurnButton;
    private OrthographicCamera camera;
    private  ScrollPane scrollPane;
    private Dialog turnDialog, infoDialog;
   private TextArea printer;
   public Skin skin;

    Label health;
     Label movementPoints;
    /* Label initiative;
     Label armorclass;
     Label name, turn;*/
    Table table;

/**
* Необходимо пересмотреть дизайн HUD
*/
    public HUD(SpriteBatch batch, final GameScreen gameScreen, Skin skin, int width, int height, int worldWidth, int worldHeight){

        camera = new OrthographicCamera(width, height);

        viewPort = new ScreenViewport();
        viewPort.apply(true);
        stage = new Stage(viewPort, batch);


        characterInfoDialog = new CharacterInfoDialog(skin, stage);

        table = new Table();
        table.top();
        table.setFillParent(true);

        this.skin = skin;

        printer = new TextArea("",skin);
        printer.setDisabled(true);
        printer.setHeight(50);
       scrollPane  = new ScrollPane(null, skin);
       // scrollPane.setForceScroll(false, true);
        scrollPane.setScrollingDisabled(true, false);
       // scrollPane.setFlickScroll(false);
        scrollPane.setOverscroll(false, true);
        //scrollPane.setFadeScrollBars(false);
        scrollPane.setWidget(printer);
        scrollPane.getColor().a = 70;
        scrollPane.setHeight(50);

        currentSprite = new Image(new Texture(Gdx.files.internal("player.png")));
        currentSprite.setSize(10,10);



        final TextButton statusButton = new TextButton("Info", skin, "default");
        statusButton.right();
        statusButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){

                characterInfoDialog.show(gameScreen.getCurrent());

                //выводить окно диалога с инвентарём (как список) и статами персонажа, который под контролем игрока

            }
        });

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
         /*initiative = new Label("Initiative", new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        armorclass = new Label("Armor class", new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
        name = new Label("Name", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        turn = new Label("turn", new Label.LabelStyle(new BitmapFont(), Color.TAN));*/

        table.add(currentSprite).padTop(3).padRight(2);
        table.add(health).padTop(3).left().bottom();
        table.add(statusButton).expandX().right();
        table.row();
        table.add(movementPoints).expandX();
        table.add().expandX();
        table.row();
        table.add().expandX();
        table.add().expandX();
        table.row().fillX().expandY().fillY();
        table.add(endTurnButton).expand(true,true).bottom().left().fill(false,false);
        table.add().expandX();
        table.add(scrollPane).expandX().bottom().right().size(viewPort.getScreenWidth() * 0.375f,viewPort.getScreenHeight() * 0.25f);
        stage.addActor(table);

        turnDialog = new SimpleDialog(" ", skin);


      /* endTurnButton.setX(0);
       endTurnButton.setY(0);
       endTurnButton.setHeight(Gdx.graphics.getHeight() * 0.25f);
       endTurnButton.setWidth(Gdx.graphics.getWidth() * 0.17f);

       stage.addActor(endTurnButton);

       scrollPane.setX(Gdx.graphics.getWidth() - 0.375f * Gdx.graphics.getWidth());
       scrollPane.setY(0);
       scrollPane.setHeight(Gdx.graphics.getHeight() * 0.25f);
       scrollPane.setWidth(Gdx.graphics.getWidth() * 0.375f);

       stage.addActor(scrollPane);*/


    }

    public void show(GameObject gameObject){

        health.setText("" + gameObject.getHP());
       // armorclass.setText("" + gameObject.getArmorClass());
        movementPoints.setText("" + gameObject.getMP());
       /* initiative.setText("" + gameObject.getInitiative());
        name.setText(gameObject.getName());*/

    }

    public void showCurrent(GameObject gameObject){

        SpriteDrawable spriteDrawable = new SpriteDrawable(gameObject.getSprite());
        currentSprite.setDrawable(spriteDrawable);

    }



    public void showTurn(final int t){

       // this.turn.setText("" + t);
        turnDialog.getColor().a = 20;
        turnDialog.text("Round " + t);
        turnDialog.show(stage);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {

                turnDialog.remove();

            }
        },1);

    }

    public void resize(int width, int height){

        viewPort.update(width, height);


    }


    public void print(String message){

        printer.appendText(message+"\n");

    }



}
