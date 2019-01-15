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
    private Ship ship;

    public MainScreen(MainGame mainGame) {

        parent = mainGame;
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(MainGame.V_WIDTH, MainGame.V_HEIGHT, gamecam);

        hud = new Hud(parent.batch);
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("map1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);

        world = new World(new Vector2(0, 0), true);
        debugRenderer = new Box2DDebugRenderer();

        world.setContactListener(new GameContactListener());

        player = new Player(this);
        ship = new Ship(this, 60, 60);

        new WorldCollisionCreator(this);

    }
        public void update(float delta){
            world.step(Gdx.graphics.getDeltaTime(), 6,2);

            handleInput(delta);

            gamecam.position.x = player.b2body.getPosition().x;
            gamecam.position.y = player.b2body.getPosition().y;

            gamecam.update();

            renderer.setView(gamecam);

        }
        public void handleInput(float delta){
            if(Gdx.input.isKeyJustPressed(Input.Keys.UP) && player.b2body.getLinearVelocity().y <= 20){
                player.b2body.applyLinearImpulse(new Vector2(0, 10), player.b2body.getWorldCenter(), true);
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN) && player.b2body.getLinearVelocity().y >= -20){
                player.b2body.applyLinearImpulse(new Vector2(0, -10), player.b2body.getWorldCenter(), true);
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT) && player.b2body.getLinearVelocity().x >= -20){
                player.b2body.applyLinearImpulse(new Vector2(-10, 0), player.b2body.getWorldCenter(), true);
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) && player.b2body.getLinearVelocity().x <= 20){
                player.b2body.applyLinearImpulse(new Vector2(10, 0), player.b2body.getWorldCenter(), true);
            }
    }
    @Override
    public void show() {


    }

    public World getWrold(){
        return world;
    }

    public TiledMap getMap(){
        return map;
    }



    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        debugRenderer.render(world, gamecam.combined);
        parent.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
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
