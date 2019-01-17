package com.seaofgeese.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;


public class MainGame extends Game {

	private LoadingScreen loadingScreen;
	private MenuScreen menuScreen;
	private MainScreen mainScreen;
	private EndScreen endScreen;
	private LeaderboardScreen leaderboardScreen;
	private PreferencesScreen preferencesScreen;
	private AppPreferences preferences;
	private CombatScreen combatScreen;



	public SpriteBatch batch;

	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;



	public final static int MENU = 0;
	public final static int LEADERBOARD = 1;
	public final static int APPLICATION = 2;
	public final static int ENDGAME = 3;
	public final static int PREFERENCES = 4;
	public final static int COMBAT = 5;


	public static final short DEFAULT_BIT = 1;
	public static final short PLAYER_BIT = 2;
	public static final short DESTROY_BIT = 4;
	public static final short ENEMY_BIT = 8;



	private World world;

	private Player player;
	private Ship ship;
	private Building VanbrughCollege,JamesCollege, HalifaxCollege, PhysicsDepartment, BiologyDepartment;
	protected Building[] BuildingArray;

	@Override
	public void create() {
		loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
		preferences = new AppPreferences();
		batch = new SpriteBatch();

		world = new World(new Vector2(0, 0), true);

		player = new Player(this);
		ship = new Ship(this,50,100, 50, 100);
		VanbrughCollege = new Building(this);
		JamesCollege = new Building(this);
		HalifaxCollege = new Building(this);
		PhysicsDepartment = new Building(this);
		BiologyDepartment = new Building(this);

		VanbrughCollege.setVanbrughBoss();
		JamesCollege.setJamesBoss();
		HalifaxCollege.setHalifaxBoss();
		PhysicsDepartment.setPhysicsDepartment();
		BiologyDepartment.setBiologyDepartment();
		BuildingArray = new Building[]{VanbrughCollege, JamesCollege, HalifaxCollege, PhysicsDepartment, BiologyDepartment};
	}


	public void changeScreen(int screen){
		switch(screen){
			case MENU:
				if(menuScreen == null) menuScreen = new MenuScreen(this);
				this.setScreen(menuScreen);
				break;
			case LEADERBOARD:
				if(leaderboardScreen == null) leaderboardScreen = new LeaderboardScreen(this);
				this.setScreen(leaderboardScreen);
				break;
			case APPLICATION:
				if(mainScreen == null) mainScreen = new MainScreen(this);
				this.setScreen(mainScreen);
				break;
			case ENDGAME:
				if(endScreen == null) endScreen = new EndScreen(this);
				this.setScreen(endScreen);
				break;
			case PREFERENCES:
				if(preferencesScreen == null) preferencesScreen = new PreferencesScreen(this);
				this.setScreen(preferencesScreen);
				break;

		}
	}
	public void changeScreen(int screen, Character character) {
		switch (screen) {
			case COMBAT:
				if (combatScreen == null) combatScreen = new CombatScreen(this, character);    //TODO Pass enemy into this
				this.setScreen(combatScreen);
				break;
		}
	}
	public World getWorld(){
		return world;
	}

	public Player getPlayer(){
		return player;
	}

	public Ship getShip(){
		return ship;
	}

	public Building[] getBuildingArray(){
		return BuildingArray;
	}

	public Building getBuilding(int i){
		return BuildingArray[i];
	}

	public AppPreferences getPreferences(){
		return this.preferences;
	}
	@Override
	public void dispose(){
		batch.dispose();
	}
}


