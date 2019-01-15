package com.seaofgeese.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.seaofgeese.game.MainGame;

public class GameContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();



        if(fixA.getUserData() == "Player" || fixB.getUserData() == "Player"){
            Fixture player = fixA.getUserData() == "Player" ? fixA : fixB;
            Fixture collidedObj = fixA == player ? fixB : fixA;

            if(collidedObj.getUserData() instanceof StaticInteractiveCollisionObject){
                ((StaticInteractiveCollisionObject) collidedObj.getUserData()).collided();
            }

            if(collidedObj.getUserData() instanceof Enemy){
                ((Enemy)collidedObj.getUserData()).startBattle();
                player.getBody().setLinearVelocity(0,0);
                collidedObj.getBody().setLinearVelocity(0,0);
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
