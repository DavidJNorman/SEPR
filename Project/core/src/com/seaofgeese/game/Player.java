package com.seaofgeese.game;


import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.seaofgeese.game.MainScreen;
import com.seaofgeese.game.MainGame;

public class Player extends Character {
    public World world;
    public Body b2body;

    public Player(MainScreen screen){
        //player attribute
        super();
        this.id = IDs.PLAYER;
        this.gold = 50;
        this.xPos = 50;
        this.yPos = 50;
        this.movePoints = 10;



        this.world = screen.getWrold();
        //define player box2d
        definePlayer();
    }

    public void definePlayer(){
        //collision
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(xPos,yPos);
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
