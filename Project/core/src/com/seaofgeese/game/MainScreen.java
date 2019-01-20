package com.seaofgeese.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.seaofgeese.game.MenuScreen;



public class MainScreen implements Screen {

    private Constant constant = new Constant();

    private MainGame parent;
    private Hud hud;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private World world;
    private Box2DDebugRenderer debugRenderer;
    private Player player;

    public MainScreen(MainGame mainGame) {
        parent = mainGame;
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(MainGame.V_WIDTH, MainGame.V_HEIGHT, gamecam);

        hud = new Hud(parent.batch, parent);
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("map1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);

        world = parent.getWorld();
        debugRenderer = new Box2DDebugRenderer();

        world.setContactListener(new GameContactListener(parent));

        player = parent.getPlayer();

        new WorldCollisionCreator(this);
    }

    public void update(float delta){
        world.step(Gdx.graphics.getDeltaTime(), 6,2);

        handleInput(delta);

        gamecam.position.x = player.b2body.getPosition().x;
        gamecam.position.y = player.b2body.getPosition().y;

        gamecam.update();

        renderer.setView(gamecam);
        hud.update(delta);
        for(int i = 0; i < parent.getShipArrayLength(); i++){
            parent.getShip(i).update(delta);
        }


    }

    //Method that handles user input
    public void handleInput(float delta){
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP) && player.b2body.getLinearVelocity().y < constant.maxSpeed){
            player.b2body.applyLinearImpulse(new Vector2(0, constant.speedIncrement), player.b2body.getWorldCenter(), true);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN) && player.b2body.getLinearVelocity().y > -constant.maxSpeed){
            player.b2body.applyLinearImpulse(new Vector2(0, -constant.speedIncrement), player.b2body.getWorldCenter(), true);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT) && player.b2body.getLinearVelocity().x > -constant.maxSpeed){
            player.b2body.applyLinearImpulse(new Vector2(-constant.speedIncrement, 0), player.b2body.getWorldCenter(), true);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) && player.b2body.getLinearVelocity().x < constant.maxSpeed) {
            player.b2body.applyLinearImpulse(new Vector2(constant.speedIncrement, 0), player.b2body.getWorldCenter(), true);
        }
    }

    @Override
    public void show() {

    }

    public World getWorld(){
        return world;
    }

    public TiledMap getMap(){
        return map;
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(54/255f, 99/255f, 101/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();
        debugRenderer.render(world, gamecam.combined);

        parent.batch.setProjectionMatrix(gamecam.combined);
        parent.batch.begin();

        //Calculate and set the players rotation before draw
        float x = player.b2body.getLinearVelocity().x;
        float y = player.b2body.getLinearVelocity().y;
        if((x != 0) || (y != 0)) {
            player.setPlayerRotation(player.calculateRotation(x, y));
        }

        //Draw players texture
        parent.batch.draw(player.textureRegion,player.b2body.getPosition().x - constant.characterCollisionRadius
                ,player.b2body.getPosition().y - constant.characterCollisionRadius
                ,constant.characterCollisionRadius,constant.characterCollisionRadius, constant.characterTextureSize
                ,constant.characterTextureSize,1,1, -(player.getPlayerRotation()));

        //Draw enemy ships textures
        for(int i = 0; i < parent.getShipArrayLength(); i++){
            parent.batch.draw(parent.getShip(i).textureRegion
                    , parent.getShip(i).b2body.getPosition().x - constant.characterCollisionRadius
                    , parent.getShip(i).b2body.getPosition().y - constant.characterCollisionRadius
                    , constant.characterCollisionRadius, constant.characterCollisionRadius
                    , constant.characterTextureSize, constant.characterTextureSize, 1, 1
                    , parent.getShip(i).getShipRotation());
        }

        parent.batch.end();

        parent.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
        }
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        world.dispose();
        debugRenderer.dispose();
        map.dispose();
        renderer.dispose();
        hud.dispose();
    }

}
