package com.seaofgeese.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.badlogic.gdx.math.MathUtils.random;

public class CombatScreen implements Screen {
    private MainGame parent;
    private Stage stage;

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
    int dmgmult = 1;
    int edmgmult = 1;
    Character character;
    private int enemyChoice;
    Player player;
    FileHandle handle = Gdx.files.internal("leaderboardfile.txt");
    String ldrbrd;
    String[] test;

    public CombatScreen(MainGame mainGame, Character character){
        ldrbrd = handle.readString();
        test = ldrbrd.split(" - ");

        this.character = character;
        parent = mainGame;
        player = parent.getPlayer();
        stage = new Stage(new ScreenViewport());
        //sound = Gdx.audio.newSound(Gdx.files.internal("music.mp3"));
        phealth = player.structureHealth;
        if(character.getIdType() == Character.IDs.FRIENDLY){
            parent.changeScreen(parent.GAME);
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
        if (character instanceof Building){
            enemy = ((Building) character).texture;
        }else {
            enemy = new Texture(Gdx.files.internal("Enemy.png"));
        }
        batch = new SpriteBatch();
        ehlabel = new Label(String.valueOf(character.getStructureHealth()),skin);
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

        pAttack.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                p_attack();
                dmgmult = 1;
                e_attack();
            }
        });
        spAttack.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                dmgmult = p_sAttack(dmgmult);
                e_attack();
            }
        });
        flee.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                phealth = phealth-10;
                stage.clear();
                parent.changeScreen(MainGame.GAME);
                healthcheck();
            }
        });
    }

    public void healthcheck(){
        if (phealth<=0){
            parent.changeScreen(MainGame.ENDGAME);
        }
    }


    public void p_attack(){
        int enemyHealth = character.getStructureHealth();
        enemyHealth = enemyHealth-(parent.getPlayer().getNoOfCannons()*dmgmult);
        if (enemyHealth<=0){
            enemyHealth = 0;
            parent.getPlayer().UpdatePoints(this.character.getPoints());
            parent.getPlayer().UpdateGold(this.character.getGold());
            if((this.character instanceof Building) && (((Building) this.character).id == Character.IDs.NEUTRAL)){
                ((Building) this.character).id = Character.IDs.FRIENDLY;
            }
            if(this.character instanceof Ship){
                parent.getWorld().destroyBody(((Ship) this.character).b2body);
                parent.setShipToNull(((Ship) this.character).getIndex());
                parent.fillShipArray();
            }
            parent.changeScreen(parent.GAME);

        }
        character.setStructureHealth(enemyHealth);
    }

    public int p_sAttack(int dmgmult){
        dmgmult = dmgmult *2;
        return dmgmult;
    }

    public void e_attack() {
        if (enemyChoice == 0) {
            this.phealth = this.phealth - (character.getNoOfCannons() * edmgmult);
            healthcheck();
            this.edmgmult = 1;
        } else {
            this.edmgmult = this.edmgmult * 2;
        }
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
        batch.draw(playerimg, 400, 500);
        batch.draw(enemy, 1000, 500);
        batch.end();

        ehlabel.setText(String.valueOf(character.getStructureHealth()));
        phlabel.setText(String.valueOf(phealth));
        player.setStructureHealth(phealth);

        enemyChoice = random.nextInt(2);
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

    public Character getCharacter()
    {
        return character;
    }

}
