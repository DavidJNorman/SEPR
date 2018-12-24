package com.seaofgeese.game;

import java.util.HashMap;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;





public class QueststateController {


    private HashMap<Integer, Quest> completedQuests;         //There should only be one instance for each ID
    private HashMap<Integer, Quest> activeQuests;
    private HashMap<Integer, Quest> unbegunQuests;


    //public QueststateController() {

    //}


    public class ReadAFile() throws FileNotFoundException  {
        final String dir = System.getProperty("user.dir");
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(dir + "\\core\\src\\com\\seaofgeese\\game\\questBootFile.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+"|");
        }
        scanner.close();
    }



    //Okay I can read in files, lets say I have a line and can let's say assign it
    //I need to:
    //TODO 1) Make a new object with all of it's information correctly - [IN PROGRESS]
    //TODO 2) Map it using a key to an ID
    //TODO Load starter quest by new function




    //TODO load active quests into HUD function
    //TODO link system into battle function - (1). Find out what function GETS target's ID (2). If active quest becomes completed, set Complete and move to completedQuests

    //TODO INIT function to set up quest instances
    //TODO code to load quests into unbegun quests with the starter quest loaded into activeQuests
    //TODO code gameplay features, like how it functions, calling from ID and setting it up.


    //TODO set up isComplete to change if CurrentAmount hits target amount and once it's complete we don't need to increment it any more

}
