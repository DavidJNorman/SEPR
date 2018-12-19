package com.seaofgeese.game;

import java.util.HashMap;
import java.util.Set;

public class QueststateController {


    private HashMap<Integer, Quest> completedQuests;         //There should only be one instance for each ID
    private HashMap<Integer, Quest> activeQuests;
    private HashMap<Integer, Quest> unbegunQuests;


    public QueststateController() {

    }




    //TODO load active quests into HUD function
    //TODO link system into battle function - (1). Find out what function GETS target's ID (2). If active quest becomes completed, set Complete and move to completedQuests

    //TODO INIT function to set up quest instances
    //TODO code to load quests into unbegun quests with the starter quest loaded into activeQuests
    //TODO code gameplay features, like how it functions, calling from ID and setting it up.
    //TODO code dependencies - Make the HashSet? or some other hash thing


    //TODO set up isComplete to change if CurrentAmount hits target amount and once it's complete we don't need to increment it any more

}
