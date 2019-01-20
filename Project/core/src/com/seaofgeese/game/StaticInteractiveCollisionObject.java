package com.seaofgeese.game;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.math.Rectangle;



public abstract class StaticInteractiveCollisionObject {

    protected World world;
    protected TiledMap map;
    protected TiledMapTile tile;
    protected Body body;
    protected Rectangle rect;
    protected Fixture fixture;

    StaticInteractiveCollisionObject(MainScreen screen, Rectangle rect){
        this.world = screen.getWorld();
        this.map = screen.getMap();
        this.rect = rect;

        BodyDef bDef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fDef = new FixtureDef();

        bDef.type = BodyDef.BodyType.StaticBody;
        bDef.position.set(rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2);
        body = world.createBody(bDef);

        shape.setAsBox(rect.getWidth() / 2, rect.getHeight() / 2);
        fDef.shape = shape;
        fixture = body.createFixture(fDef);
    }

    public abstract void collided();

    public void setCategoryFilter(short filterBit){
        Filter filter = new Filter();
        filter.categoryBits = filterBit;
        fixture.setFilterData(filter);
    }
}
