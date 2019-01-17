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

    public Player(MainGame game){
        //player attribute
        super(game);
        this.id = IDs.PLAYER;
        this.gold = 50;
        this.xPos = 50;
        this.yPos = 50;
        this.structureHealth = 100;
//        this.movePoints = 10;
        this.idCode = 0;


        this.world = game.getWorld();
        //define player box2d
        definePlayer();
    }

    public void UpdatePoints(int PointReward){  //Updates the player points by the value passed in TODO Check if this should be in the combat system instead of here
        int CurrentPoints = this.getPoints();
        int UpdatedPoints = CurrentPoints + PointReward;

        if(UpdatedPoints > 999999){
            this.setPoints(999999);
        }
        else {this.setPoints(UpdatedPoints);}
    }

    public void UpdateGold(int GoldReward){                    //Increase Gold by value added
        int CurrentGold = this.getGold();
        int UpdatedGold = CurrentGold + GoldReward;

        if(UpdatedGold > 999){
            this.setGold(999);
        }
        else {this.setGold(UpdatedGold);}
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
