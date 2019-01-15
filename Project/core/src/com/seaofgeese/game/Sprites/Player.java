package com.mygdx.game.Sprites;


import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Screen.PlayScreen;
import com.mygdx.game.SeaOfGeese;

public class Player {
    public World world;
    public Body b2body;

    public Player(PlayScreen screen){
        this.world = screen.getWorld();
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
        fixtureDef.filter.categoryBits = SeaOfGeese.PLAYER_BIT;
        fixtureDef.filter.maskBits = SeaOfGeese.DEFAULT_BIT | SeaOfGeese.ENEMY_BIT;

        b2body.createFixture(fixtureDef).setUserData("Player");



    }

}
