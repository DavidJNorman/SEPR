package com.seaofgeese.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MainGame extends Game {

	private LoadingScreen loadingScreen;
	private MenuScreen menuScreen;
	private MainScreen mainScreen;
	private EndScreen endScreen;
	private LeaderboardScreen leaderboardScreen;
	private PreferencesScreen preferencesScreen;
	private AppPreferences preferences;

	public SpriteBatch batch;

	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;



	public final static int MENU = 0;
	public final static int LEADERBOARD = 1;
	public final static int APPLICATION = 2;
	public final static int ENDGAME = 3;
	public final static int PREFERENCES = 4;


	@Override
	public void create() {
		loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
		preferences = new AppPreferences();
		batch = new SpriteBatch();

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

	public AppPreferences getPreferences(){
		return this.preferences;
	}
	@Override
	public void dispose(){
		batch.dispose();
	}
}


