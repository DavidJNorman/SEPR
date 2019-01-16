package com.seaofgeese.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public class Ship extends Character {
    protected World world;

    public Body b2body;

    public void startBattle(MainGame mainGame) {
        Gdx.app.log("Enemy","StartBattle");
    }

    protected void defineEnemy() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(getX(),getY());
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bodyDef);

        FixtureDef fixtureDef = new FixtureDef();
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(6);
        fixtureDef.shape =circleShape;
        fixtureDef.filter.categoryBits = MainGame.ENEMY_BIT;
        fixtureDef.filter.maskBits = MainGame.DEFAULT_BIT | MainGame.ENEMY_BIT | MainGame.PLAYER_BIT;

        b2body.createFixture(fixtureDef).setUserData(this);
    }

    public Ship(MainGame game, float x, float y) {
        super(game);
        this.gold = 100;
        this.id = IDs.ENEMY;
        this.points = 100;
        this.idCode = 7;
        this.noOfCannons = 1;
        this.world = game.getWorld();
        setPosition(x, y);
        defineEnemy();
    }
}
