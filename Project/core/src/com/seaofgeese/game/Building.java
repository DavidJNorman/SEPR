package com.seaofgeese.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

//Building
public class Building extends Character {
    public IDs id;
    protected World world;
    protected TiledMap map;
    private Body body;
    private Fixture fixture;
    Texture texture;

    public Building(MainGame mainGame, int layerIndex) {
        super(mainGame);
        this.world = mainGame.getWorld();
        this.map = mainGame.getMap();
        defineBuilding(layerIndex);


    }


    public void setVanbrughBoss() {
        this.id = IDs.NEUTRAL;
        this.texture = new Texture(Gdx.files.internal("Vanbrugh.png"));
        this.idCode = 2;
        this.gold = 60;
        this.points = 300;
        this.noOfCannons = 3;
        this.maxStructureHealth = 200;
        this.structureHealth = this.maxStructureHealth;
    }


    public void setJamesBoss() {
        this.id = IDs.NEUTRAL;
        this.texture = new Texture(Gdx.files.internal("James.png"));
        this.idCode = 4;
        this.gold = 90;
        this.points = 1700;
        this.noOfCannons = 4;
        this.maxStructureHealth = 250;
        this.structureHealth = this.maxStructureHealth;
    }


    public void setHalifaxBoss() {
        this.id = IDs.NEUTRAL;
        this.texture = new Texture(Gdx.files.internal("Halifax.png"));
        this.idCode = 6;
        this.gold = 250;
        this.points = 5000;
        this.noOfCannons = 5;
        this.maxStructureHealth = 350;
        this.structureHealth = this.maxStructureHealth;
    }

    public void setPhysicsDepartment() {
        this.id = IDs.ENEMY;
        this.texture = new Texture(Gdx.files.internal("Physics.png"));
        this.idCode = 9;
        this.gold = 250;
        this.points = 4000;
        this.noOfCannons = 4;
        this.maxStructureHealth = 300;
        this.structureHealth = this.maxStructureHealth;
    }

    public void setBiologyDepartment() {
        this.id = IDs.ENEMY;
        this.texture = new Texture(Gdx.files.internal("Biology.png"));
        this.idCode = 10;
        this.gold = 300;
        this.points = 4500;
        this.noOfCannons = 4;
        this.maxStructureHealth = 350;
        this.structureHealth = this.maxStructureHealth;
    }

    public void defineBuilding(int layerIndex) {
        for (MapObject object : map.getLayers().get(layerIndex).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            BodyDef bDef = new BodyDef();
            PolygonShape shape = new PolygonShape();
            FixtureDef fDef = new FixtureDef();

            bDef.type = BodyDef.BodyType.StaticBody;
            bDef.position.set(rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2);
            body = world.createBody(bDef);

            shape.setAsBox(rect.getWidth() / 2, rect.getHeight() / 2);
            fDef.shape = shape;
            fixture = body.createFixture(fDef);
            fixture.setUserData(this);
        }
    }
    public void startBattle(MainGame mainGame) {
        Gdx.app.log("Enemy","StartBattle");
        mainGame.changeScreen(MainGame.COMBAT, this);
    }
}