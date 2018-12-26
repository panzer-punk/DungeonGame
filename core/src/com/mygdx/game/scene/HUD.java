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
import com.mygdx.game.systems.DialogManager;


public class HUD {
    public Stage stage;
    private Viewport viewPort;
    private GameObject player;
    private final SpriteBatch batch = new SpriteBatch();
    private CharacterInfoDialog characterInfoDialog;
    private Image currentSprite;
    public TextButton endTurnButton;
    private OrthographicCamera camera;
    private  ScrollPane scrollPane;
    private Dialog turnDialog, infoDialog;
    private TextArea printer;
    private volatile GameScreen gameScreen;
    private Label.LabelStyle playerParams,
                             paramsStyle,
                             mpStyle,
                             hpStyle;
    public Skin skin;

    Label labelHealth,
            labelMovementPoints,
            labelStr,
            labelDex,
            labelCon,
            labelWeapon,
            labelTurn,
            labelPlayer;
    Label str,
            dex,
            con,
            weapon,
            playerName,
            hp,
            mp;
    /* Label initiative;
     Label armorclass;
     Label name, turn;*/
    Table tableInterface, tablePlayerStats;

    /**
     * Необходимо пересмотреть дизайн HUD
     */
    public HUD( final GameScreen gameScreen, Skin skin, int width, int height,GameObject player){

        camera = new OrthographicCamera(width, height);

        this.gameScreen = gameScreen;

        viewPort = new ScreenViewport();
        viewPort.apply(true);
        stage = new Stage(viewPort, batch);

        this.player = player;


        characterInfoDialog = new CharacterInfoDialog(skin, stage);

        tableInterface = new Table();
        tableInterface.top();
        tableInterface.setFillParent(true);
       // tableInterface.setDebug(true);
        tablePlayerStats = new Table();
        tablePlayerStats.right();
       // tablePlayerStats.setDebug(true);

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

        playerParams = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
        paramsStyle =  new Label.LabelStyle(new BitmapFont(), Color.SALMON);
        mpStyle = new Label.LabelStyle(new BitmapFont(), Color.BLUE);
        hpStyle = new Label.LabelStyle(new BitmapFont(), Color.RED);


        final TextButton statusButton = new TextButton("Info", skin, "default");
        statusButton.right();
        statusButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){

                gameScreen.blockInput();
                characterInfoDialog.show(gameScreen.getCurrent());
                gameScreen.unblockInput();
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

                gameScreen.blockInput();
                gameScreen.keyUp(Input.Keys.ENTER);
                gameScreen.unblockInput();

            }
        });


        labelHealth = new Label("HP:", hpStyle);
        labelMovementPoints = new Label("MP:",mpStyle );
        labelCon = new Label("CON:", paramsStyle);
        labelDex = new Label("DEX:", paramsStyle);
        labelStr = new Label("STR:", paramsStyle);
        labelWeapon = new Label("Weapon",paramsStyle);
        labelTurn = new Label("TURN", new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
        labelPlayer = new Label(player.getName(), playerParams);
        dex = new Label(""  + player.getDEX(), playerParams);
        con = new Label(""  + player.getCON(), playerParams);
        str = new Label(""  +player.getSTR(), playerParams);
        weapon = new Label(player.getWeapon().getLabel(), playerParams);
        mp = new Label( "" + player.getMP(), mpStyle);
        hp = new Label("" + player.getHP(),hpStyle);
         /*initiative = new Label("Initiative", new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        armorclass = new Label("Armor class", new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
        name = new Label("Name", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        turn = new Label("turn", new Label.LabelStyle(new BitmapFont(), Color.TAN));*/

         tablePlayerStats.add(labelPlayer).colspan(4).center();
         tablePlayerStats.row();
         tablePlayerStats.add(labelStr).expandX().padLeft(7);
         tablePlayerStats.add(str).padLeft(7);
         tablePlayerStats.add(labelMovementPoints).expandX().padLeft(7);
        tablePlayerStats.add(mp).padLeft(7);
         tablePlayerStats.row();
         tablePlayerStats.add(labelDex).expandX().padLeft(7);
         tablePlayerStats.add(dex).padLeft(7);
         tablePlayerStats.add(labelHealth).expandX().padLeft(7);
        tablePlayerStats.add(hp).padLeft(7);
        tablePlayerStats.row();
        tablePlayerStats.add(labelCon).expandX().padLeft(7);
        tablePlayerStats.add(con).padLeft(7);
        tablePlayerStats.add(labelWeapon).expandX().padLeft(7);
        tablePlayerStats.add(weapon).padLeft(7);


        tableInterface.add(labelTurn).center().expandX().colspan(3);
        tableInterface.row();
        tableInterface.add().expandX();
        tableInterface.add().expandX();
        tableInterface.add(tablePlayerStats).expandX().right();
        tableInterface.row();
        tableInterface.add().colspan(2).bottom().left().expandY();
        tableInterface.row();
        tableInterface.add(endTurnButton).bottom().left().fill(false,false);
        tableInterface.add(statusButton).bottom().left().expandX();
        tableInterface.add(scrollPane).expandX().bottom().right().size(viewPort.getScreenWidth() * 0.375f,viewPort.getScreenHeight() * 0.25f).colspan(2);
        stage.addActor(tableInterface);
       /* tableInterface.add(currentSprite).padTop(3).padRight(2);
        tableInterface.add(labelHealth).padTop(3).left().bottom();
        tableInterface.add(statusButton).expandX().right();
        tableInterface.row();
        tableInterface.add(labelMovementPoints).expandX();
        tableInterface.add().expandX();
        tableInterface.row();
        tableInterface.add().expandX();
        tableInterface.add().expandX();
        tableInterface.row().fillX().expandY().fillY();
        tableInterface.add(endTurnButton).expand(true,true).bottom().left().fill(false,false);
        tableInterface.add().expandX();
        tableInterface.add(scrollPane).expandX().bottom().right().size(viewPort.getScreenWidth() * 0.375f,viewPort.getScreenHeight() * 0.25f);
        stage.addActor(tableInterface);*/




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


    public synchronized void blockGameScreen(){gameScreen.blockInput();}

    public synchronized  void unblockGameScreen(){gameScreen.unblockInput();}

    public void show(){

        hp.setText("" + player.getHP());
        // armorclass.setText("" + gameObject.getArmorClass());
        mp.setText("" + player.getMP());
       /* initiative.setText("" + gameObject.getInitiative());
        name.setText(gameObject.getName());*/

    }

    public void showCurrent(GameObject gameObject){

       // SpriteDrawable spriteDrawable = new SpriteDrawable(gameObject.getSprite());
     //   currentSprite.setDrawable(spriteDrawable);

    }



    public void showTurn(final int t){

      labelTurn.setText("TURN: "  + t);

    }

    public void resize(int width, int height){

        viewPort.update(width, height);
        viewPort.apply(true);


    }


    public void print(String message){

        printer.appendText(message+"\n");

    }



}