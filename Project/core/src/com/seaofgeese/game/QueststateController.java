package com.seaofgeese.game;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class QueststateController {

    private static Map<Integer, Quest> completedQuests = new HashMap<Integer, Quest>();
    private static Map<Integer, Quest> activeQuests = new HashMap<Integer, Quest>();
    private static Map<Integer, Quest> unbegunQuests = new HashMap<Integer, Quest>();


    public static void fileReader() { //TODO When game starts run this
        BufferedReader reader;
        final String dir = System.getProperty("user.dir");
        try {
            reader = new BufferedReader(new FileReader(dir + "\\core\\src\\com\\seaofgeese\\game\\questBootFile.csv"));
            String line = reader.readLine();
            while (line != null) {
                //System.out.println(line);
                varAssignment(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void varAssignment(String line) {
        String[] lineBuffer = line.split(",");
        if(lineBuffer[0].equals("#")) {						//If the ID token is a '#' ignore it
            return;
        }

        System.out.println(Arrays.toString(lineBuffer)); 	//[1] - I noticed if there was a leading whitespace it wouldn't read in type properly for int types only, I made some code to test values of each type but as it was unnecessary work I simply removed them manually

        activeQuests.put(Integer.parseInt(lineBuffer[0]), new Quest(lineBuffer[1], lineBuffer[2], Integer.parseInt(lineBuffer[3]), Integer.parseInt(lineBuffer[4]), Integer.parseInt(lineBuffer[5]), Integer.parseInt(lineBuffer[6]), Integer.parseInt(lineBuffer[7]), Boolean.parseBoolean(lineBuffer[8]), Boolean.parseBoolean(lineBuffer[9]), Double.parseDouble(lineBuffer[10]), Double.parseDouble(lineBuffer[11]), Double.parseDouble(lineBuffer[12]), Double.parseDouble(lineBuffer[13]), Integer.parseInt(lineBuffer[14])));
        System.out.println(activeQuests.get(1).getQuestTitle().getClass().getName());
        System.out.println(String.class.getName());
        //System.out.println(activeQuests.get(1).toString());
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


    public Map<Integer, Quest> getActiveQuests() {return activeQuests;}

    public Map<Integer, Quest> getUnbegunQuests() {return unbegunQuests;}






    public static void main(String[] args) {
        //QueststateController newInst = new QueststateController();
        //Quest Q001 = new Quest("Take the sails!", "Battle Vanbrugh college 3 times.", 0, 300, 300, 0, 3, false, false, 0.00, 0.00, 0);
        //unbegunQuests.put(1, new Quest("Take the sails!", "Battle Vanbrugh college 3 times.", 0, 300, 300, 0, 3, false, false, 0.00, 0.00, 0));
        //activeQuests.put(1, Q001);
        //System.out.println(unbegunQuests.get(1).getQuestDesc());


        //if(QuestCompletionChecker()) {
        //activeQuests.get(1).setIsComplete();  //TODO If quest is complete then get the object, do isComplete
        //}

        fileReader();
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


