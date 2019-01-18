package com.seaofgeese.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;


public class MainGame extends Game {

	//Object for each screen within the application
	private LoadingScreen loadingScreen;
	private MenuScreen menuScreen;
	private MainScreen gameScreen;
	private EndScreen endScreen;
	private LeaderboardScreen leaderboardScreen;
	private PreferencesScreen preferencesScreen;
	private CombatScreen combatScreen;

	//Constants
	public final static int MENU = 0;
	public final static int LEADERBOARD = 1;
	public final static int GAME = 2;
	public final static int ENDGAME = 3;
	public final static int PREFERENCES = 4;
	public final static int COMBAT = 5;
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;
	public static final short DEFAULT_BIT = 1;
	public static final short PLAYER_BIT = 2;
	public static final short DESTROY_BIT = 4;
	public static final short ENEMY_BIT = 8;

	//Main game class attributes
	private AppPreferences preferences;
	public SpriteBatch batch;
	private World world;
	private Player player;
	private Ship[] shipArray;
	private int totalShips = 10;
	private Building vanbrughCollege, jamesCollege, halifaxCollege, physicsDepartment, biologyDepartment;
	protected Building[] buildingArray;

	private TiledMap map;
	private TmxMapLoader mapLoader;

	@Override
	//Method run first that initialises the application and needed variables/objects
	public void create() {
		loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);

		preferences = new AppPreferences();
		batch = new SpriteBatch();
		world = new World(new Vector2(0, 0), true);

		mapLoader = new TmxMapLoader();
		map = mapLoader.load("map1.tmx");

		player = new Player(this);

		shipArray = new Ship[4];
		fillShipArray();

		vanbrughCollege = new Building(this,3);
		jamesCollege = new Building(this,4);
		halifaxCollege = new Building(this,7);
		physicsDepartment = new Building(this,5);
		biologyDepartment = new Building(this,6);
		vanbrughCollege.setVanbrughBoss();
		jamesCollege.setJamesBoss();
		halifaxCollege.setHalifaxBoss();
		physicsDepartment.setPhysicsDepartment();
		biologyDepartment.setBiologyDepartment();
		buildingArray = new Building[]{vanbrughCollege, jamesCollege, halifaxCollege, physicsDepartment, biologyDepartment};
	}

	//Method that manages the changing of the current application screen
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
			case GAME:
				if(gameScreen == null) gameScreen = new MainScreen(this);
				this.setScreen(gameScreen);
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

	//A variation on the method changeScreen(int), that also passes a character for combat management
	public void changeScreen(int screen, Character character) {
		switch (screen) {
			case COMBAT:
				combatScreen = new CombatScreen(this, character);    //TODO Pass enemy into this
				this.setScreen(combatScreen);
				break;
		}
	}

	public CombatScreen getCombatScreen(){
		return combatScreen;
	}

	public World getWorld(){
		return world;
	}

	public Player getPlayer(){
		return player;
	}

	private boolean checkTotalShips()
	{
		boolean b;
		if(totalShips > 0)
		{
			b = true;
		}
		else
		{
			b = false;
		}
		return b;
	}

	private void fillShipArray() {
		for(int i = 0; i < 4; i++)
		{
			if(checkTotalShips())
			{
				if(shipArray[i] == null)
				{
					shipArray[i] = new Ship(this, i,50,100,50,100);
					totalShips = totalShips - 1;
				}
			}
			else
			{
				break;
			}
		}
	}

	public int getIndexOfShip(Character character) {
		int index = -1;
		for(int i = 0; i < 4; i++)
		{
			if(shipArray[i].equals(character))
			{
				index = i;
			}
		}
		return index;
	}

	public Ship[] getShipArray()
	{
		return shipArray;
	}

	public Ship getShip(int i)
	{
		return shipArray[i];
	}


	public Building[] getBuildingArray(){
		return buildingArray;
	}

	public Building getBuilding(int i){
		return buildingArray[i];
	}

	public AppPreferences getPreferences(){
		return this.preferences;
	}

	public TiledMap getMap(){
		return map;
	}

	@Override
	public void dispose(){
		batch.dispose();
	}
}


