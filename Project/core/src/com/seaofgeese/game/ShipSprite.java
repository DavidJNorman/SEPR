/*
package com.seaofgeese.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class ShipSprite extends ApplicationAdapter {
    SpriteBatch batch;
    Sprite sprite;
    Texture img;
    World world;
    Body body;
    Ship ship;


    public void ShipSprite(World world, Ship ship){
        this.world = world;
        this.ship = ship;
    }

    @Override
    public void create() {
    batch = new SpriteBatch();
    img = new Texture("Boat.png");
    sprite = new Sprite(img);

        @Override
        public void create() {

            batch = new SpriteBatch();
            img = new Texture("badlogic.jpg");
            sprite = new Sprite(img);

            sprite.setPosition(Gdx.graphics.getWidth() / 2 - sprite.getWidth() / 2, Gdx.graphics.getHeight() / 2);

            BodyDef bodyDef = new BodyDef();
            bodyDef.type = BodyDef.BodyType.DynamicBody;
            bodyDef.position.set(sprite.getX(), sprite.getY());
            body = world.createBody(bodyDef);

            PolygonShape shape = new PolygonShape();
            shape.setAsBox(sprite.getWidth()/2, sprite.getHeight()/2);
            FixtureDef fixtureDef = new FixtureDef();
            fixtureDef.shape = shape;

            fixtureDef.density = 1f;
            Fixture fixture = body.createFixture(fixtureDef);
            shape.dispose();
        }

        @Override
        public void render() {

            world.step(Gdx.graphics.getDeltaTime(), 6, 2);
            sprite.setPosition(genCoordinate(lowerx,upperx), genCoordinate(lowery,uppery));
            sprite.setPosition(body.getPosition().x, body.getPosition().y);

            Gdx.gl.glClearColor(1, 1, 1, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.begin();
            batch.draw(sprite, sprite.getX(), sprite.getY());
            batch.end();
        }

        @Override
        public void dispose() {
            img.dispose();
            world.dispose();
        }
    }

}
*/
