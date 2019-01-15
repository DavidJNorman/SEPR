package com.seaofgeese.game;


import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.seaofgeese.game.MainScreen;
import com.seaofgeese.game.MainGame;

public class Player {
    public World world;
    public Body b2body;

    public Player(MainScreen screen){
        this.world = screen.getWrold();
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
        fixtureDef.filter.categoryBits = MainGame.PLAYER_BIT;
        fixtureDef.filter.maskBits = MainGame.DEFAULT_BIT | MainGame.ENEMY_BIT;

        b2body.createFixture(fixtureDef).setUserData("Player");



    }

}
