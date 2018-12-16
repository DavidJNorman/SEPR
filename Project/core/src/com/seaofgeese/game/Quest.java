package com.seaofgeese.game;

import com.badlogic.gdx.Gdx;

public class Quest {

	private String questTitle;		//e.g. Take the Sails
	private String questDesc;		//Sink 5 pirate ships
	private int questID				//Simple number system, 
	private int goldReward;			//e.g. 600 gold
	private int pointsReward;		//e.g. 300 points
	private int targetAmount;		//8       -Ships destroyed
	private int currentAmount;		//5       -Ships destroyed
	private boolean isComplete;		//Is the Quest completed? (for active quests only)
	private boolean isRepeatable;	//Can the Quest be redone? (So you can take it even after completion)

	private float returnLocation;
	private float targetLocation;

	private ArrayList<int> completedQuests;
	private ArrayList<int> activeQuests;
	private ArrayList<int> unbegunQuests;

    public String getQuestTitle() {
		return QuestTitle;
	}

	public void setQuestTitle(String title) {
		this.questTitle = title;
	}

}