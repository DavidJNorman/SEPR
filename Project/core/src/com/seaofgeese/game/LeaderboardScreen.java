package com.seaofgeese.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class LeaderboardScreen implements Screen {
    private Stage stage;
    private MainGame parent;
    private Label posOne;
    private String strOne;
    private Label title;


    FileHandle handle = Gdx.files.internal("leaderboardfile.txt");

    public LeaderboardScreen(MainGame mainGame){

        parent = mainGame;

        /// Create stage and set it as input processor
        stage = new Stage(new ScreenViewport());
    }
    @Override
    public void show() {
        strOne = this.handle.readString();

        stage.clear();
        Gdx.input.setInputProcessor(stage);
        //Create a table that fills the screen. Everything will go inside this
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);

        Skin skin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));
        title = new Label("Leaderboard",skin);
        posOne = new Label(strOne,skin);

        //return to main menu
        final TextButton backButton = new TextButton("Back", skin);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(MainGame.MENU);
            }
        });

        table.add(title);
        table.row();
        table.add(posOne);
        table.row();
        table.add(backButton);
    }

    @Override
    public void render(float delta) {
        //Clears the screen
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Draws
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
