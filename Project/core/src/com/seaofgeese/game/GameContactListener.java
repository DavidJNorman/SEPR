package com.seaofgeese.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.seaofgeese.game.MainGame;

public class GameContactListener implements ContactListener {
    private MainGame mainGame;
    Fixture collidedObj;

    public GameContactListener(MainGame mainGame){
        this.mainGame = mainGame;
    }
    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        if(fixA.getUserData() instanceof Player || fixB.getUserData() instanceof Player){
            Fixture player = fixA.getUserData() instanceof Player ? fixA : fixB;
            collidedObj = fixA == player ? fixB : fixA;

            if(collidedObj.getUserData() instanceof StaticInteractiveCollisionObject){
                ((StaticInteractiveCollisionObject) collidedObj.getUserData()).collided();
            }

            if(collidedObj.getUserData() instanceof Ship){
                Gdx.app.log("Index", Integer.toString(((Ship)collidedObj.getUserData()).getIndex()));

                ((Ship)collidedObj.getUserData()).startBattle(mainGame);
                player.getBody().setLinearVelocity(0,0);
                collidedObj.getBody().setLinearVelocity(0,0);
            }

            if(collidedObj.getUserData() instanceof Building){
                if((((Building)collidedObj.getUserData()).id != Character.IDs.FRIENDLY)){
                    ((Building)collidedObj.getUserData()).startBattle(mainGame);
                }else{
                    ((Player)player.getUserData()).structureHealth = ((Player)player.getUserData()).maxStructureHealth;
                }
            }
        }
    }

    @Override
    public void endContact(Contact contact) {
        Gdx.app.log("End Contact", "");

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
