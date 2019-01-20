package com.seaofgeese.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
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
        table.setDebug(false);
        stage.addActor(table);

        Skin skin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));

        //create buttons
        TextButton newGame = new TextButton("New Game", skin);
        //TextButton leaderboard = new TextButton("Leaderboard", skin);
        //TextButton preferences = new TextButton("Preferences", skin);
        TextButton exit = new TextButton("Exit", skin);



        table.add(newGame).fillX().uniformX().width(Value.percentWidth(.50F, table)).height(Value.percentHeight(.15F, table));
        table.row().pad(20,0,20,0);
        //Currently Unused
        //table.add(leaderboard).fillX().uniformX().width(Value.percentWidth(.50F, table)).height(Value.percentHeight(.15F, table));
        table.row();
        //Currently Unused
        //table.add(preferences).fill().uniformX().width(Value.percentWidth(.50F, table)).height(Value.percentHeight(.15F, table));
        table.row().pad(20, 0, 20, 0);
        table.add(exit).fillX().uniformX().width(Value.percentWidth(.50F, table)).height(Value.percentHeight(.15F, table));

        //Create button listeners
        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(MainGame.GAME);
                stage.clear();
            }
        });

        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        //Unused Listeners
/*        leaderboard.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(MainGame.LEADERBOARD);
            }
        });

        preferences.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(MainGame.ENDGAME);
            }
        });*/
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
