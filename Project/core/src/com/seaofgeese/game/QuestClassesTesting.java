package com.seaofgeese.game;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestClassesTesting {

    @Test
    void testQuestStringsType() {

        QueststateController newInst = new QueststateController();
        newInst.fileReader();
        //System.out.println(newInst.getActiveQuests().get(1).getQuestTitle());

        assertEquals(String.class.getName(), newInst.getActiveQuests().get(1).getQuestTitle().getClass().getName(), "Check Title unaltered is a string"); //Tests Title is a string
        assertEquals(String.class.getName(), newInst.getActiveQuests().get(1).getQuestDesc().getClass().getName(),"Check Description unaltered is a string"); //Tests Title is a string




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
    }
}
