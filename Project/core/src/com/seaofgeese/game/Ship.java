package com.seaofgeese.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.seaofgeese.game.MainScreen;
import com.seaofgeese.game.MainGame;
import com.seaofgeese.game.Enemy;

public class Ship extends Enemy {
    @Override
    public void startBattle() {
        Gdx.app.log("Enemy","StartBattle");

    }

    @Override
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

    public Ship(MainScreen screen, float x, float y) {
        super(screen, x, y);
        defineEnemy();
    }
}
