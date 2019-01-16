package com.seaofgeese.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.seaofgeese.game.Player;

public class CombatScreen implements Screen {
    private MainGame parent;
    private Stage stage;
    private Label title;
    private Label phlabel;
    private Label ehlabel;
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
        background = new Texture(Gdx.files.internal("Background.png"));
        playerimg = new Texture(Gdx.files.internal("Player.png"));
        enemy = new Texture(Gdx.files.internal("Enemy.png"));

        batch = new SpriteBatch();
        ehlabel = new Label(String.valueOf(ehealth),skin);
        phlabel = new Label(String.valueOf(phealth), skin);
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);
        table.add(phlabel);
        table.add().width(800);
       // sound.play();


        title = new Label("Combat",skin);

        table.pad(0, 100, 0, 0);
        //table.add(title);

        table.add(ehlabel);

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

    public void enemyAttack(){
        int EnemyCannons = parent.getShip().getNoOfCannons();
        parent.getPlayer().healthUpdate(EnemyCannons);
        if(parent.getPlayer().getStructureHealth() == 0){
            parent.changeScreen(parent.ENDGAME);
        }
    }

    public void playerAttack(){
        int PlayerCannons = parent.getPlayer().getNoOfCannons();
        parent.getPlayer().healthUpdate(PlayerCannons);
        if(parent.getShip().getStructureHealth() == 0){
            parent.getPlayer().UpdatePoints(parent.getShip().getPoints());
            parent.getPlayer().UpdateGold(parent.getShip().getGold());

            parent.changeScreen(parent.APPLICATION);
        }
    }
}
