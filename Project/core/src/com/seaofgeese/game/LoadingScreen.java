package com.seaofgeese.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class LoadingScreen implements Screen {

    private Constant constant = new Constant();

    //Class Attributes
    private MainGame parent;
    private Stage stage;
    private Texture logo;
    SpriteBatch batch;
    long startTime;

    //Class constructor
    //Params: Takes MainGame to use as an out operator
    public LoadingScreen(MainGame mainGame){
        parent = mainGame;
        stage = new Stage(new ScreenViewport());
    }

    @Override
    public void show() {
        stage.clear();
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
        logo = new Texture(Gdx.files.internal("Logo.png"));
        startTime = TimeUtils.millis();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));

        batch.begin();
        batch.draw(logo, Gdx.graphics.getWidth()/2 - logo.getWidth()/2, Gdx.graphics.getHeight()/2 - logo.getHeight()/2);
        batch.end();
        stage.draw();

        if(TimeUtils.timeSinceMillis(startTime) > constant.loadingScreenActiveTime){
            parent.changeScreen(MainGame.MENU);
        }
    }

    @Override
    public void resize(int width, int height) {

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
        stage.dispose();
    }
}
