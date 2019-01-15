package com.seaofgeese.game.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.mygdx.game.Screen.PlayScreen;
import com.mygdx.game.SeaOfGeese;

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
        fixtureDef.filter.categoryBits = SeaOfGeese.ENEMY_BIT;
        fixtureDef.filter.maskBits = SeaOfGeese.DEFAULT_BIT | SeaOfGeese.ENEMY_BIT | SeaOfGeese.PLAYER_BIT;

        b2body.createFixture(fixtureDef).setUserData(this);

    }

    public Ship(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        defineEnemy();
    }
}
