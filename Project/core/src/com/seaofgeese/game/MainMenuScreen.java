package com.seaofgeese.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class MainMenuScreen implements Screen {
    MainGame game;
    Texture exitButton;
    Texture playButton;
    float x = 100;
    float y = 100;
    public MainMenuScreen(MainGame game){
        this.game = game;
        this.exitButton = new Texture("Exit.png");
        this.playButton = new Texture("Play.png");

    }









    @java.lang.Override
    public void show() {

    }

    @java.lang.Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(playButton, 50,50, 200, 150 );
        game.batch.draw(exitButton, 350, 50, 200, 150);
        game.batch.end();
    }

    @java.lang.Override
    public void resize(int width, int height) {

    }

    @java.lang.Override
    public void pause() {

    }

    @java.lang.Override
    public void resume() {

    }

    @java.lang.Override
    public void hide() {

    }

    @java.lang.Override
    public void dispose() {

    }
}
