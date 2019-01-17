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
    private Label phlabel;
    private Label ehlabel;
    private Label ehtitle;
    private Label ptitle;

    Texture playerimg;
    Texture enemy;
    Texture background;
    SpriteBatch batch;
    //Sound sound;
    int phealth;
    int ehealth;
    int dmgmult = 1;
    Character MyNewEnemy;

    public CombatScreen(MainGame mainGame, Character MyNewEnemy){
        this.MyNewEnemy = MyNewEnemy;
        parent = mainGame;
        stage = new Stage(new ScreenViewport());
        //sound = Gdx.audio.newSound(Gdx.files.internal("music.mp3"));
        phealth = parent.getPlayer().getStructureHealth();
        instanceTyping();
        if(MyNewEnemy.getIdType() == Character.IDs.FRIENDLY){
            parent.changeScreen(parent.APPLICATION);
        }

    }
    @Override
    public void show() {
        stage.clear();
        Skin skin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));
        Gdx.input.setInputProcessor(stage);

        TextButton pAttack = new TextButton("Attack", skin);
        TextButton spAttack = new TextButton("Special Attack", skin);
        TextButton flee = new TextButton("Flee, ya coward", skin);

        background = new Texture(Gdx.files.internal("Background.png"));
        playerimg = new Texture(Gdx.files.internal("Player.png"));
        enemy = new Texture(Gdx.files.internal("Enemy.png"));


        batch = new SpriteBatch();
        ehlabel = new Label(String.valueOf(ehealth),skin);
        phlabel = new Label(String.valueOf(phealth),skin);
        ehtitle = new Label("Enemy Health:", skin);
        ptitle = new Label("Player Health:", skin);

        ptitle.setFontScale(2);
        ehtitle.setFontScale(2);
        phlabel.setFontScale(2);
        ehlabel.setFontScale(2);

        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(false);

        Table tHealth = new Table();
        tHealth.setDebug(false);
        tHealth.add(ptitle);
        tHealth.add(ehtitle);
        tHealth.row();
        tHealth.add(phlabel);
        tHealth.add(ehlabel);
        tHealth.row();
        tHealth.add().width(500);
        tHealth.add().width(500);
        tHealth.setPosition(960, 1000);

        table.add(pAttack).size(200);
        table.add(spAttack).size(200);
        table.add(flee).size(200);

        table.setPosition(-250,-250);
        stage.addActor(tHealth);
        stage.addActor(table);


        //table.add().width(800);
       // sound.play();
        //title = new Label("Combat",skin);
        //table.add(title);


        pAttack.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                ehealth = p_attack(ehealth, dmgmult);
                dmgmult = 1;



            }
        });
        spAttack.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                dmgmult = p_sAttack(dmgmult);
            }
        });
        flee.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.getPlayer().structureHealth = parent.getPlayer().getStructureHealth()-10;
                stage.clear();
                parent.changeScreen(MainGame.APPLICATION);
                healthcheck();

            }
        });
    }
    //public int e_attack(int phealth){

    //}

    public void instanceTyping(){
        if(this.MyNewEnemy instanceof Building){
            this.MyNewEnemy = parent.getBuildingArray()[4];                     //TODO: Find out how to find the index
            ehealth = this.MyNewEnemy.getStructureHealth();
        }
        else if(this.MyNewEnemy instanceof Ship){
            this.MyNewEnemy = parent.getShip();                                  //TODO: Jordan: Will also be in an array
            ehealth = this.MyNewEnemy.getStructureHealth();
        }
    }

    public void healthcheck(){
        if (parent.getPlayer().getStructureHealth()<=0){
            parent.getPlayer().setStructureHealth(0);
            parent.changeScreen(MainGame.ENDGAME);
        }
    }
    public int p_attack(int enemyHealth, int dmgmult){
        enemyHealth = enemyHealth-(20*dmgmult);
        if (enemyHealth<=0){
            enemyHealth = 0;
            parent.getPlayer().UpdatePoints(this.MyNewEnemy.getPoints());
            parent.getPlayer().UpdateGold(this.MyNewEnemy.getGold());
            if((this.MyNewEnemy instanceof Building) && (this.MyNewEnemy.getIdType() == Character.IDs.NEUTRAL)){
                this.MyNewEnemy.setIdType(Character.IDs.FRIENDLY);
            }
            parent.changeScreen(parent.APPLICATION);

        }
        return enemyHealth;
    }
    public int p_sAttack(int dmgmult){
        dmgmult = dmgmult +1;
        return dmgmult;
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
            ehlabel.setText(String.valueOf(ehealth));
            phlabel.setText(String.valueOf(phealth));

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
        stage.dispose();
    }

//    public void enemyAttack(){
//        int EnemyCannons = this.MyNewEnemy.getNoOfCannons();
//        parent.getPlayer().healthUpdate(EnemyCannons);
//        if(parent.getPlayer().getStructureHealth() == 0){
//            parent.changeScreen(parent.ENDGAME);
//        }
//    }

//    public void playerAttack(){
//        int PlayerCannons = parent.getPlayer().getNoOfCannons();
//        this.MyNewEnemy.healthUpdate(PlayerCannons);
//        if(this.MyNewEnemy.getStructureHealth() == 0){
//            parent.getPlayer().UpdatePoints(this.MyNewEnemy.getPoints());
//            parent.getPlayer().UpdateGold(this.MyNewEnemy.getGold());
//
//            parent.changeScreen(parent.APPLICATION);
//        }
//    }
}
