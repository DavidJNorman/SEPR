package com.seaofgeese.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.seaofgeese.game.Player;

import javax.xml.soap.Text;

public class CombatScreen implements Screen {
    private MainGame parent;
    private Stage stage;

    //private Label title;
    //private Label phlabel;
    //private Label ehlabel;

    Texture playerimg;
    Texture enemy;
    Texture background;
    SpriteBatch batch;
    //Sound sound;
    int phealth;
    int ehealth;

    public CombatScreen(MainGame mainGame){
        parent = mainGame;
        stage = new Stage(new ScreenViewport());
        //sound = Gdx.audio.newSound(Gdx.files.internal("music.mp3"));
        phealth = mainGame.getPlayer().getStructureHealth();
        ehealth = mainGame.getShip().getStructureHealth();

    }
    @Override
    public void show() {
        Skin skin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));
        Gdx.input.setInputProcessor(stage);

        TextButton pAttack = new TextButton("Attack", skin);
        TextButton spAttack = new TextButton("Special Attack", skin);
        TextButton flee = new TextButton("Flee, ya coward", skin);

        background = new Texture(Gdx.files.internal("Background.png"));
        playerimg = new Texture(Gdx.files.internal("Player.png"));
        enemy = new Texture(Gdx.files.internal("Enemy.png"));

        batch = new SpriteBatch();
        //ehlabel = new Label(String.valueOf(ehealth),skin);
        //phlabel = new Label(String.valueOf(phealth), skin);

        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);

        table.add(pAttack);
        table.add(spAttack);
        table.add(flee);

        table.setPosition(-250,-250);
        stage.addActor(table);

       //table.add(phlabel);
        //table.add().width(800);
       // sound.play();
        //title = new Label("Combat",skin);
        //table.add(title);
        //table.add(ehlabel);

        pAttack.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

            }
        });
        spAttack.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

            }
        });
        flee.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

            }
        });
    }

    @Override
    public void render(float delta) {
    //Clears the screen
            Gdx.gl.glClearColor(0f, 0f, 0f, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            //Draws
            stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
            batch.begin();
            batch.draw(background,0,0);
            batch.draw(playerimg, 0, 0);
            batch.draw(enemy, 500, 300);
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
