package com.seaofgeese.game;



import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class Player extends Character {
    public World world;
    public Body b2body;
    private float degree;



    protected TextureRegion textureregion;

    protected Texture texture;

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
        this.texture = new Texture("boat.png");

        this.textureregion = new TextureRegion(texture);
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

        b2body.createFixture(fixtureDef).setUserData(this);



    }

    public void update(float delta){
//        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
        System.out.print(this.b2body.getLinearVelocity()+" ");









    }

    public double getDirection() {

        float xVelocity = b2body.getLinearVelocity().x;
        float yVelocity = b2body.getLinearVelocity().y;
        float relativedifference = Math.abs(Math.abs(xVelocity) - Math.abs(yVelocity));
        float condition = 20;


        if (xVelocity == 0 && yVelocity == 0 ||yVelocity > 0 && relativedifference >= condition) {
            degree = 0;
        } else if (xVelocity > 0 && yVelocity > 0 && relativedifference < condition) {
            degree = -45;
        } else if (xVelocity < 0 && yVelocity > 0 && relativedifference < condition) {
            degree = 45;
        } else if(xVelocity < 0 && yVelocity < 0 && relativedifference < condition){
            degree = 135;
        }else if(xVelocity > 0 && yVelocity < 0 && relativedifference < condition){
            degree = -135;
        }else if(xVelocity > 0 && relativedifference >= condition){
            degree = -90;
        }else if(xVelocity < 0 && relativedifference >= condition){
            degree = 90;
        }else if(yVelocity < 0 && relativedifference >= condition){
            degree = 180;
        }
        return degree;

    }



    }




