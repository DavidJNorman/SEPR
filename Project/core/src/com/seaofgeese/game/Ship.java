package com.seaofgeese.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import java.awt.TextArea;
import java.util.Random;

public class Ship extends Character {
    private Constant constant = new Constant();

    protected World world;
    public Body b2body;

    private int index;
    private float shipRotation;
    protected Texture texture;
    protected TextureRegion textureRegion;

    public Ship(MainGame game, int index, int lowerx, int upperx, int lowery, int uppery) {
        super(game);
        this.gold = 100;
        this.id = IDs.ENEMY;
        this.structureHealth = 100;
        this.points = 100;
        this.idCode = 7;
        this.noOfCannons = 1;
        this.world = game.getWorld();
        this.index = index;
        this.shipRotation = calculateShipRotation();
        setPosition(genCoordinate(lowerx,upperx), genCoordinate(lowery,uppery));

        this.texture = new Texture("EnemyShip.png");
        this.textureRegion = new TextureRegion(texture);

        defineEnemy();
    }

    //Method that handles the start of combat
    public void startBattle(MainGame mainGame) {
        Gdx.app.log("Enemy","StartBattle");
        mainGame.changeScreen(MainGame.COMBAT, this);
    }

    //Define Enemy box2d
    protected void defineEnemy() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(getX(),getY());
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bodyDef);

        FixtureDef fixtureDef = new FixtureDef();
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(constant.characterCollisionRadius);
        fixtureDef.shape = circleShape;
        fixtureDef.filter.categoryBits = MainGame.ENEMY_BIT;
        fixtureDef.filter.maskBits = MainGame.DEFAULT_BIT | MainGame.ENEMY_BIT | MainGame.PLAYER_BIT;

        b2body.createFixture(fixtureDef).setUserData(this);
    }

    //Randomly generate an x or y coordinate between upper and lower bounds
    public float genCoordinate(int lower, int upper)
    {
        int temp;
        float coordinate;
        Random r = new Random();
        temp = r.nextInt(upper-lower) + lower;
        coordinate = (float)temp;
        return coordinate;
    }

    public int getIndex()
    {
        return index;
    }

    public void update(float delta){
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
    }

    //Randomly generate the ships rotation
    public float calculateShipRotation(){
        Random r = new Random();
        float rotation = (float)(r.nextInt(360));
        return rotation;
    }

    public float getShipRotation()
    {
        return this.shipRotation;
    }

}
