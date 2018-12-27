package com.seaofgeese.game;

import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QueststateController {

    private static Map<Integer, Quest> completedQuests = new HashMap<>();
    private static Map<Integer, Quest> activeQuests = new HashMap<>();
    private static Map<Integer, Quest> unbegunQuests = new HashMap<>();


    public void fileReader() {
        final String dir = System.getProperty("user.dir");
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(dir + "\\src\\questBootFile.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+"|");
        }
        scanner.close();
    }

    public static boolean QuestCompletionChecker() {
        boolean anyCompletions = false;
        for(int key: activeQuests.keySet()) {
            if(activeQuests.get(key).getIsComplete()) {
                completedQuests.put(key, activeQuests.get(key));			//TODO look at the bottom of planning document
                anyCompletions = true;
            }
        }
        return anyCompletions;
    }

    public static void QuestListTransitioner(){

    }

    public static void main(String[] args) {
        //QueststateController newInst = new QueststateController();
        //Quest Q001 = new Quest("Take the sails!", "Battle Vanbrugh college 3 times.", 0, 300, 300, 0, 3, false, false, 0.00, 0.00, 0);
        unbegunQuests.put(1, new Quest("Take the sails!", "Battle Vanbrugh college 3 times.", 0, 300, 300, 0, 3, false, false, 0.00, 0.00, 0));
        //activeQuests.put(1, Q001);
        System.out.println(unbegunQuests.get(1).getQuestDesc());
        if(QuestCompletionChecker()) {
            //activeQuests.get(1).
        }
    }



    //Okay I can read in files, lets say I have a line and can let's say assign it
    //I need to:
    //TODO 1) Make a new object with all of it's information correctly
    //TODO 2) Map it using a key to an ID
    //TODO Load starter quest by new function


    //TODO load active quests into HUD function
    //TODO link system into battle function - (1). Find out what function GETS target's ID (2). If active quest becomes completed, set Complete and move to completedQuests

    //TODO INIT function to set up quest instances
    //TODO code to load quests into unbegun quests with the starter quest loaded into activeQuests
    //TODO code gameplay features, like how it functions, calling from ID and setting it up.
    //TODO code dependencies - Make the HashSet? or some other hash thing


    //TODO set up isComplete to change if CurrentAmount hits target amount and once it's complete we don't need to increment it any more

}
