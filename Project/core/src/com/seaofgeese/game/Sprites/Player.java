package com.mygdx.game.Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class Player {
    public World world;
    public Body b2body;

    public Player(World world){
        this.world = world;
        definePlayer();
    }

    public void definePlayer(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(50,50);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bodyDef);

        FixtureDef fixtureDef = new FixtureDef();
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(6);
        fixtureDef.shape =circleShape;
        b2body.createFixture(fixtureDef);
    }

}
