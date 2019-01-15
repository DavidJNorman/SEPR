package com.seaofgeese.game;

//Author: Benjamin Hassell

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
TODO You should be able to:
    Read Quests into the Quest System                                                                                           [COMPLETE]
    Accept Quests when provided as long as they fit criteria                                                                    [COMPLETE]
    Complete Quests: Handing it in.                                                                                             [COMPLETE]
    Update Quests: Update the values within the quests AND accept new unbegun quests with that as the main dependency           [COMPLETE] *Does need Player and Enemy object callers.
    HUD Updater?                                                                                                                [UNBEGUN]


*/
public class QueststateController {

    private static Map<Integer, Quest> completedQuests = new HashMap<Integer, Quest>();
    private static Map<Integer, Quest> activeQuests = new HashMap<Integer, Quest>();
    private static Map<Integer, Quest> unbegunQuests = new HashMap<Integer, Quest>();


    //FILE HANDLING
    public void fileReader() {   //COMPLETE | TESTED
        BufferedReader reader;
        final String workingDir = System.getProperty("user.dir");
        final String dir = workingDir.replace("core\\assets", "");
        try {
            reader = new BufferedReader(new FileReader(dir + "\\core\\src\\com\\seaofgeese\\game\\questBootFile.csv"));
            String line = reader.readLine();
            while (line != null) {
                varAssignment(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void varAssignment(String line) {   //COMPLETE | TESTED
        String[] lineBuffer = line.split(",");
        if(lineBuffer[0].equals("#")) {						//If the ID token is a '#' ignore it
            return;
        }
        if(lineBuffer[14].equals("0")) {						//If the ID token is a '#' ignore it
            //noinspection Duplicates
            activeQuests.put(Integer.parseInt(lineBuffer[0]), new Quest(lineBuffer[1], lineBuffer[2], Integer.parseInt(lineBuffer[3]), Integer.parseInt(lineBuffer[4]), Integer.parseInt(lineBuffer[5]), Integer.parseInt(lineBuffer[6]), Integer.parseInt(lineBuffer[7]), Boolean.parseBoolean(lineBuffer[8]), Boolean.parseBoolean(lineBuffer[9]), Double.parseDouble(lineBuffer[10]), Double.parseDouble(lineBuffer[11]), Double.parseDouble(lineBuffer[12]), Double.parseDouble(lineBuffer[13]), Integer.parseInt(lineBuffer[14])));
            return;
        }
        //noinspection Duplicates
        unbegunQuests.put(Integer.parseInt(lineBuffer[0]), new Quest(lineBuffer[1], lineBuffer[2], Integer.parseInt(lineBuffer[3]), Integer.parseInt(lineBuffer[4]), Integer.parseInt(lineBuffer[5]), Integer.parseInt(lineBuffer[6]), Integer.parseInt(lineBuffer[7]), Boolean.parseBoolean(lineBuffer[8]), Boolean.parseBoolean(lineBuffer[9]), Double.parseDouble(lineBuffer[10]), Double.parseDouble(lineBuffer[11]), Double.parseDouble(lineBuffer[12]), Double.parseDouble(lineBuffer[13]), Integer.parseInt(lineBuffer[14])));
    }

    //ACCEPT QUESTS
    private void AcceptDependantQuests(int CompletedKey){    //Accepts the quests dependant on the one we just completed
        for(int newKey : unbegunQuests.keySet()){
            if(unbegunQuests.get(newKey).getMainDependency() == CompletedKey){
                activeQuests.put(newKey, unbegunQuests.get(newKey));
                unbegunQuests.remove(newKey);
            }
        }
    }

    //[ARCHIVED CODE:ACCEPT QUESTS] This code would be useful if you spoke to NPCs to accept quests, however for time management we use an auto accept system
    /*
    private void AcceptQuest(int QuestID) throws IndexOutOfBoundsException { //A general class that will accept quests                                               //TODO Link this to Sailing
        if(activeQuests.containsKey(QuestID)) { System.out.println("Quest already accepted!"); }
        else if(unbegunQuests.containsKey(QuestID)) {
            activeQuests.put(QuestID, unbegunQuests.get(QuestID));
            unbegunQuests.remove(QuestID);
            }
        else if(completedQuests.containsKey(QuestID)) { ReloadRepeatableQuest(QuestID); }
        else throw new IndexOutOfBoundsException("Key not found in Unbegun quests or in Completed Quests");
    }

    private void ReloadRepeatableQuest(int idToLoad){               //Called if you try to accept a repeatable Quest
        if(completedQuests.get(idToLoad).getIsRepeatable()){
            activeQuests.put(idToLoad, completedQuests.get(idToLoad));
            activeQuests.get(idToLoad).setIsComplete(false);
            activeQuests.get(idToLoad).SetCurrentAmount(0);
            completedQuests.remove(idToLoad);
        }
    }
    */



    /*
    //BATTLE
    public void EndOfBattleFunction(){ //Pass ID into parameters and run our updates after battle.
        final int targetID = Combat.getEnemyID;
        final int targetPointVal = Combat.getEnemyPointVal();
        final int targetGoldVal = Combat.getEnemyGoldVal();
        UpdateQuests(targetID);             //Runs the main quest updater
        UpdateGold(targetGoldVal);          //Updates Gold from this one battle
        UpdatePoints(targetPointVal);       //Updates Points from this one battle
    }

    private void IncrementCurrentAmount(int TargetID, int keyIndex){ //Changes
        Quest testedQuest = activeQuests.get(keyIndex);
        if((testedQuest.getTargetID() == TargetID) && !(testedQuest.getIsComplete())){
            testedQuest.IncCurrentAmount();
            if(testedQuest.getCurrentAmount() >= testedQuest.getTargetAmount()){
                testedQuest.setIsComplete(true);
            }
        }
    }

    private void HandInQuests(int Key){ //Removes Quest from active Quest
        Quest currentQuest = activeQuests.get(Key);
        if(currentQuest.getIsComplete()){
            UpdateGold(currentQuest.getGoldReward());          //Gives user Gold Reward
            UpdatePoints(currentQuest.getPointsReward());      //Gives user Point Reward
            completedQuests.put(Key, currentQuest);
            activeQuests.remove(Key);
        }
    }

    private void UpdateQuests(int CombatTargetID) {                        //Iterates through activeQuests at the end of a battle TODO after the battle quest updater (updates currentAmount)
        for(int key: activeQuests.keySet()) {
            IncrementCurrentAmount(CombatTargetID, key);
            if(activeQuests.get(key).getIsComplete()) {
                HandInQuests(key);
                AcceptDependantQuests(key);
            }
        }
    }

    private void UpdatePoints(int PointReward){                 //Updates the player points by the value passed in TODO Check if this should be in the combat system instead of here
        int CurrentPoints = ThePlayerInstance.getPoints();
        int UpdatedPoints = CurrentPoints + PointReward;

        if(UpdatedPoints < CurrentPoints){
            System.out.println("Overflow has occurred!");
            return;
        }
        else {ThePlayerInstance.setPoints(UpdatedPoints);}
    }

    private void UpdateGold(int GoldReward){                    //Updates the gold by the value passed in TODO Check if this should be in the combat system instead of here
        int CurrentGold = ThePlayerInstance.getGold();
        int UpdatedGold = CurrentGold + GoldReward;

        if(UpdatedGold < CurrentGold){
            System.out.println("Overflow has occurred!");
            return;
        }
        else {ThePlayerInstance.setGold(UpdatedGold);}
    }
    */



    //ACCESSORS
    public Map<Integer, Quest> getCompletedQuests() {return completedQuests;}

    public Map<Integer, Quest> getActiveQuests() {return activeQuests;}

    public Map<Integer, Quest> getUnbegunQuests() {return unbegunQuests;}





    public static void main(String[] args) {
        QueststateController testInst = new QueststateController();
        testInst.fileReader();

        System.out.println("Active Quests\n----------------------");
        for(int keyIndex : testInst.getActiveQuests().keySet())
        { System.out.println("Quest ID: " + keyIndex + "\n" + testInst.getActiveQuests().get(keyIndex).toString());}

        System.out.println("Unbegun Quests\n----------------------");
        for(int keyIndex : testInst.getUnbegunQuests().keySet())
        { System.out.println("Quest ID: " + keyIndex + "\n" + testInst.getUnbegunQuests().get(keyIndex).toString());}

    }



    /*
    I need to:
        1) Make a new object with all of it's information correctly.  [COMPLETE]
        2) Map it using a key to an ID.                               [COMPLETE]
        3) Load starter quest by new function                         [COMPLETE]
        TODO 4) load active quests into HUD function - Should be as simple as the HUD loading it in, no need for it to be in here  [INCOMPLETE]
        TODO 5) link system into battle function - Find out what function returns the enemy we're battling  [INCOMPLETE]
        6) If active quest becomes completed, set Complete and move to completedQuests                    [COMPLETE]
        7) INIT function to set up quest instances                                                        [COMPLETE]
        8) code to load quests into unbegun quests with the starter quest loaded into activeQuests        [COMPLETE]
        TODO 9) code gameplay features, like how it functions, calling from ID and setting it up.         [INCOMPLETE]
        10) code dependencies - Make the HashSet? or some other hash thing                                [COMPLETE]
        11) set up isComplete to change if CurrentAmount hits target amount and once it's complete we don't need to increment it any more   [COMPLETE]
    */


}


//Archived Code Appendix
//[1] - I noticed if there was a leading whitespace it wouldn't read in type properly for int types only, I made some code to test values of each type
//Testing Example - Testing the variables within the file to find an issue which turned out to be a leading whitespace causing it not to read each type in properly
//int parseInt = Integer.parseInt(lineBuffer[12]);
//System.out.println("Item focus '0':" + parseInt);
//System.out.println("Item Type: " + ((Object)parseInt).getClass().getName());

//String parseString = lineBuffer[2];
//System.out.println("Item 0:" + parseString);
//System.out.println("Item Type: " + ((Object)parseString).getClass().getName());

//boolean parseBoolean = Boolean.parseBoolean(lineBuffer[9]);
//System.out.println("Item 0:" + parseBoolean);
//System.out.println("Item Type: " + ((Object)parseBoolean).getClass().getName());

//double parseDouble = Double.parseDouble(lineBuffer[11]);
//System.out.println("Item 0:" + parseDouble);
//System.out.println("Item Type: " + ((Object)parseDouble).getClass().getName());


