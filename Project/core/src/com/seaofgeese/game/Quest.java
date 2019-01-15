package com.seaofgeese.game;

//Author: Benjamin Hassell

import java.util.Arrays;

class Quest {

	private final String questTitle;			//e.g. Take the Sails
	private final String questDesc;				//Sink 5 pirate ships
	private final int targetID;
	private final int goldReward;				//e.g. 600 gold
	private final int pointsReward;				//e.g. 300 points
	private final int targetAmount;				//8       -Ships destroyed
	private int currentAmount;					//5       -Ships destroyed

	private boolean isComplete;					//Is the Quest completed? (for active quests only)
	private final boolean isRepeatable;			//Can the Quest be redone? (So you can take it even after completion)

	private final double returnX;
	private final double returnY;
	private final double targetX;
	private final double targetY;

	private final int mainDependency;	//The set of dependencies No Duplication, order unnecessary, only check will be if all are complete



	Quest(String questTitle, String questDesc, int targetID, int goldReward, int pointsReward, int currentAmount, int targetAmount, boolean isComplete, boolean isRepeatable, double returnX, double returnY, double targetX, double targetY, int mainDependency) {
		this.questTitle = questTitle;
		this.questDesc = questDesc;
		this.targetID = targetID;
		this.goldReward = goldReward;
		this.pointsReward = pointsReward;
		this.currentAmount = currentAmount;
		this.targetAmount = targetAmount;
		this.isComplete = isComplete;
		this.isRepeatable = isRepeatable;
		this.returnX = returnX;
		this.returnY = returnY;
		this.targetX = targetX;
		this.targetY = targetY;
		this.mainDependency = mainDependency;
	}

	@Override
	public String toString() {	//So it can be displayed from HUD
		return "Title:" + this.questTitle + "\n" + "Description:" + this.questDesc + "\n" + "Gold Reward: $" + this.goldReward + "\n" +
				"Progress: " + this.currentAmount + "/" + this.targetAmount + "\n" + "target Location: " + Arrays.toString(getTargetLocation()) + "\n";
	}

	public String getQuestTitle() {return this.questTitle;}

	public String getQuestDesc() {return this.questDesc;}

	public int getTargetID() {return this.targetID;}

	public int getGoldReward() {return this.goldReward;}

	public int getPointsReward() {return this.pointsReward;}

	public int getTargetAmount() {return this.targetAmount;}

	public int getCurrentAmount(){return this.currentAmount;}

	public void IncCurrentAmount() {this.currentAmount = this.currentAmount + 1;} //We set it initially, but technically we only need to increment it after a battle for this current quest ID

	public void SetCurrentAmount(int newAmount) {this.currentAmount = newAmount;} //We set it initially, but technically we only need to increment it after a battle for this current quest ID

	public boolean getIsComplete() {return this.isComplete;}

	public void setIsComplete(Boolean isComplete) {this.isComplete = isComplete;} //The Quests controller will do the comparisons and then set this to true when currentAmount == targetAmount

	public boolean getIsRepeatable() {return this.isRepeatable;}

	private double getReturnX()
	{return this.returnX;}

	private double getReturnY()
	{return this.returnY;}

	public double[] getReturnLocation() {
		return new double[]{getReturnX(), getReturnY()};}

	public double[] getTargetLocation() {
		return new double[]{getTargetX(), getTargetY()};}

	private double getTargetX()
	{return this.targetX;}

	private double getTargetY()
	{return this.targetY;}

	public int getMainDependency() {return this.mainDependency;}
}
