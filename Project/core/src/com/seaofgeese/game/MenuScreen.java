package com.seaofgeese.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;



public class MenuScreen implements Screen {
    private Stage stage;
    private MainGame parent;


    public MenuScreen(MainGame mainGame){
        parent = mainGame;

        /// Create stage and set it as input processor
        stage = new Stage(new ScreenViewport());


    }
    @java.lang.Override
    public void show() {

        Gdx.input.setInputProcessor(stage);

        //Create a table that fills the screen. Everything will go inside this
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);

        Skin skin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));

        //create buttons
        TextButton newGame = new TextButton("New Game", skin);
        TextButton leaderboard = new TextButton("Leaderboard", skin);
        TextButton preferences = new TextButton("Preferences", skin);
        TextButton exit = new TextButton("Exit", skin);


        table.add(newGame).fillX().uniformX();
        table.row().pad(10,0,10,0);
        table.add(leaderboard).fillX().uniformX();
        table.row();
        table.add(preferences).fill().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(exit).fillX().uniformX();

        //Create button listeners
        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(MainGame.APPLICATION);
                stage.clear();
            }
        });

        leaderboard.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(MainGame.LEADERBOARD);
            }
        });

        preferences.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(MainGame.PREFERENCES);
            }
        });
    }

    @java.lang.Override
    public void render(float delta) {
        //Clears the screen
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Draws
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
        stage.draw();
    }

    @java.lang.Override
    public void resize(int width, int height) {

        stage.getViewport().update(width, height, true);
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
        stage.dispose();
    }
}
