package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.build.TexturePack;

public class MainMenuScreen implements Screen, InputProcessor {

    private Skin skin;
    private GameScreen gameScreen;
    private EditorScreen editorScreen;
    private Stage stage;
    private MyGdxGame myGdxGame;
    private Table table;
    private Viewport viewport;

    public MainMenuScreen(final MyGdxGame myGdxGame, TexturePack texturePack) {
        this.myGdxGame = myGdxGame;
        skin = texturePack.getSkin();
        viewport = new FillViewport(Gdx.graphics.getWidth() * 1.5f, Gdx.graphics.getHeight(), new OrthographicCamera());
        stage = new Stage(viewport);
        table = new Table();
        table.top();
        table.setFillParent(true);
        gameScreen = new GameScreen(myGdxGame, texturePack, viewport.getScreenWidth(), viewport.getScreenHeight());
        editorScreen = new EditorScreen(myGdxGame, texturePack);
        final TextButton playButton = new TextButton("Play", skin, "default");
        final TextButton editorButton = new TextButton("Editor", skin, "default");
        final TextButton exitButton = new TextButton("Exit", skin, "default");
        playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){

                myGdxGame.setScreen(gameScreen);
                InputMultiplexer inputMultiplexer = new InputMultiplexer();
                inputMultiplexer.addProcessor(gameScreen);
                inputMultiplexer.addProcessor(gameScreen.hud.stage);
                Gdx.input.setInputProcessor(inputMultiplexer);


            }
        });
        editorButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){

                myGdxGame.setScreen(editorScreen);
                Gdx.input.setInputProcessor(editorScreen);

            }
        });
        exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){

                Gdx.app.exit();

            }
        });
        table.add(playButton).expandY();
        table.row().fillX();
        table.add(editorButton).expandY();
        table.row().fillX();
        table.add(exitButton).expandY();
        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
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
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
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

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {

        viewport.update(width, height);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        gameScreen.dispose();
        editorScreen.dispose();
        stage.dispose();

    }
}
