package com.seaofgeese.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class EndScreen implements Screen {
    private MainGame parent;
    private Stage stage;
    Texture end;
    SpriteBatch batch;
    public EndScreen(MainGame mainGame){

        parent = mainGame;
        stage = new Stage(new ScreenViewport());
    }
    @Override
    public void show() {
        stage.clear();
        Gdx.input.setInputProcessor(stage);
        end = new Texture(Gdx.files.internal("gameover.png"));
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Draws
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
        batch.begin();
        batch.draw(end,0,0);
        batch.end();
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
        }
        stage.draw();
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

    }
}
