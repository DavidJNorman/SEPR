package com.seaofgeese.game;

import com.badlogic.gdx.Screen;

public class LoadingScreen implements Screen {
    private MainGame parent; //a field to store out orchestrator
    public LoadingScreen(MainGame mainGame){

        parent = mainGame;
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        parent.changeScreen(MainGame.MENU);
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
