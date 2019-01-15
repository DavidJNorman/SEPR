package com.seaofgeese.game;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestClassesTesting {

    @Test
    void testLoadedQuestStringType() {

        QueststateController newInst = new QueststateController();
        newInst.fileReader();
        for(int keyA : newInst.getActiveQuests().keySet()) {
            Quest QuestObject = newInst.getActiveQuests().get(keyA);
            assertEquals(String.class.getName(), QuestObject.getQuestTitle().getClass().getName(), "Check beginner quest Title string");
            assertEquals(String.class.getName(), QuestObject.getQuestDesc().getClass().getName(), "Check beginner quest Description string");
        }
        for(int keyB : newInst.getUnbegunQuests().keySet()){
            Quest QuestObject = newInst.getUnbegunQuests().get(keyB);
            assertEquals(String.class.getName(), QuestObject.getQuestTitle().getClass().getName(), "Check quests Title is a string");
            assertEquals(String.class.getName(), QuestObject.getQuestDesc().getClass().getName(),"Check quests Description is a string");
        }
    }

    @Test
    void testLoadedQuestIntType() {
        QueststateController newInst = new QueststateController();
        newInst.fileReader();
        for(int keyA : newInst.getActiveQuests().keySet()) {
            Quest QuestObject = newInst.getActiveQuests().get(keyA);
            assertEquals(Integer.class.getName(), ((Object) QuestObject.getTargetID()).getClass().getName(), "Check beginner quest Enemy ID is an int");
            assertEquals(Integer.class.getName(), ((Object) QuestObject.getGoldReward()).getClass().getName(), "Check beginner quest gold reward is an int");
            assertEquals(Integer.class.getName(), ((Object) QuestObject.getPointsReward()).getClass().getName(), "Check beginner quest point reward is an int");
            assertEquals(Integer.class.getName(), ((Object) QuestObject.getTargetAmount()).getClass().getName(), "Check beginner quest Target total is an int");
            assertEquals(Integer.class.getName(), ((Object) QuestObject.getCurrentAmount()).getClass().getName(), "Check beginner quest Current total is an int");
            assertEquals(Integer.class.getName(), ((Object) QuestObject.getMainDependency()).getClass().getName(), "Check beginner quest Main Dependency is an int");
        }
        for(int keyB : newInst.getUnbegunQuests().keySet()){
            Quest QuestObject = newInst.getUnbegunQuests().get(keyB);
            assertEquals(Integer.class.getName(), ((Object) QuestObject.getTargetID()).getClass().getName(), "Check quests Enemy ID is an int");
            assertEquals(Integer.class.getName(), ((Object) QuestObject.getGoldReward()).getClass().getName(),"Check quests gold reward is an int");
            assertEquals(Integer.class.getName(), ((Object) QuestObject.getPointsReward()).getClass().getName(),"Check quests point reward is an int");
            assertEquals(Integer.class.getName(), ((Object) QuestObject.getTargetAmount()).getClass().getName(),"Check quests Target total is an int");
            assertEquals(Integer.class.getName(), ((Object) QuestObject.getCurrentAmount()).getClass().getName(),"Check quests Current total is an int");
            assertEquals(Integer.class.getName(), ((Object) QuestObject.getMainDependency()).getClass().getName(),"Check quests Main Dependency is an int");
        }
    }

    @Test
    void testLoadedQuestBoolType() {
        QueststateController newInst = new QueststateController();
        newInst.fileReader();
        for(int keyA : newInst.getActiveQuests().keySet()) {
            Quest QuestObject = newInst.getActiveQuests().get(keyA);
            assertEquals(Boolean.class.getName(), ((Object) QuestObject.getIsComplete()).getClass().getName(), "Check beginner quest Completion attribute is an bool");
            assertEquals(Boolean.class.getName(), ((Object) QuestObject.getIsRepeatable()).getClass().getName(), "Check beginner quest Repeatability attribute is an bool");
        }
        for(int keyB : newInst.getUnbegunQuests().keySet()){
            Quest QuestObject = newInst.getUnbegunQuests().get(keyB);
            assertEquals(Boolean.class.getName(), ((Object) QuestObject.getIsComplete()).getClass().getName(), "Check quests Completion attribute is an bool");
            assertEquals(Boolean.class.getName(), ((Object) QuestObject.getIsRepeatable()).getClass().getName(), "Check quests Repeatability attribute is an bool");
        }
    }

    @Test
    void testLoadedQuestDoubleType() {
        QueststateController newInst = new QueststateController();
        newInst.fileReader();
        for(int keyA : newInst.getActiveQuests().keySet()) {
            Quest QuestObject = newInst.getActiveQuests().get(keyA);
            //System.out.println(Double[]);
            assertEquals("[D", QuestObject.getReturnLocation().getClass().getName(), "Check beginner quest Completion attribute is an bool");
            assertEquals("[D", QuestObject.getTargetLocation().getClass().getName(), "Check beginner quest Repeatability attribute is an bool");
        }
        for(int keyB : newInst.getUnbegunQuests().keySet()){
            Quest QuestObject = newInst.getUnbegunQuests().get(keyB);
            assertEquals("[D", QuestObject.getReturnLocation().getClass().getName(), "Check quests Completion attribute is an bool");
            assertEquals("[D", QuestObject.getTargetLocation().getClass().getName(), "Check quests Repeatability attribute is an bool");
        }
    }

}






//, "java.lang.String"
//I need an output of whatever line it is so I can do the thing

		/*
		System.out.println(Arrays.toString(lineBuffer));
		int parseInt = Integer.parseInt(lineBuffer[12]);
		assertThat(lineBuffer[0], instanceOf(Integer.class));

		System.out.println("Item Type: " + ((Object)parseInt).getClass().getName());

		String parseString = lineBuffer[2];
		System.out.println("Item 0:" + parseString);
		System.out.println("Item Type: " + ((Object)parseString).getClass().getName());

		boolean parseBoolean = Boolean.parseBoolean(lineBuffer[9]);
		System.out.println("Item 0:" + parseBoolean);
		System.out.println("Item Type: " + ((Object)parseBoolean).getClass().getName());

		double parseDouble = Double.parseDouble(lineBuffer[11]);
		System.out.println("Item 0:" + parseDouble);
		System.out.println("Item Type: " + ((Object)parseDouble).getClass().getName());
		*/
