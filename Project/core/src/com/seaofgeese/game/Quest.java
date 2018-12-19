package com.seaofgeese.game;

class Quest {						//TODO you made this class package private, learn what that will mean for this

	private String questTitle;		//e.g. Take the Sails
	private String questDesc;		//Sink 5 pirate ships
	private int questID;				//Simple number system,
	private int goldReward;			//e.g. 600 gold
	private int pointsReward;		//e.g. 300 points
	private int targetAmount;		//8       -Ships destroyed
	private int currentAmount;		//5       -Ships destroyed
	private boolean isComplete;		//Is the Quest completed? (for active quests only)
	private boolean isRepeatable;	//Can the Quest be redone? (So you can take it even after completion)

	private float returnLocation;
	private float targetLocation;

	public Quest(String questTitle, String questDesc, int questID, int goldReward, int pointsReward, int targetAmount, int currentAmount, boolean isComplete, boolean isRepeatable, float returnLocation, float targetLocation) {
		this.questTitle = questTitle;
		this.questDesc = questDesc;
		this.questID = questID;
		this.goldReward = goldReward;
		this.pointsReward = pointsReward;
		this.targetAmount = targetAmount;
		this.currentAmount = currentAmount;
		this.isComplete = isComplete;
		this.isRepeatable = isRepeatable;
		this.returnLocation = returnLocation;
		this.targetLocation = targetLocation;
	}

	//TODO Do we even need half of the setters? we need the getters sure, but most just have initially set values, no?

	public String getQuestTitle() { return this.questTitle; }

	public void setQuestTitle(String questTitle) {
		this.questTitle = questTitle;
	}

	public String getQuestDesc() {
		return this.questDesc;
	}

	public void setQuestDesc(String questDesc) {
		this.questDesc = questDesc;
	}

	public int getQuestID() {
		return this.questID;
	}

	public void setQuestID(int questID) {
		this.questID = questID;
	}

	public int getGoldReward() {
		return this.goldReward;
	}

	public void setGoldReward(int goldReward) {
		this.goldReward = goldReward;
	}

	public int getPointsReward() {
		return this.pointsReward;
	}

	public void setPointsReward(int pointsReward) {
		this.pointsReward = pointsReward;
	}

	public int getTargetAmount() {
		return this.targetAmount;
	}

	public void setTargetAmount(int targetAmount) {
		this.targetAmount = targetAmount;
	}

	public int getCurrentAmount(){return this.currentAmount;}

	public void setCurrentAmount(int currentAmount) {  //TODO we set it initially sure, but technically we only need to increment it after a battle for this current system
		this.currentAmount = currentAmount;
	}

	public boolean getIsComplete() {
		return this.isComplete;
	}

	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}

	public boolean getIsRepeatable() {
		return this.isRepeatable;
	}

	public void setIsRepeatable(Boolean isRepeatable) {
		this.isRepeatable = isRepeatable;
	}

	public float getReturnLocation() {
		return this.returnLocation;
	}

	public void setReturnLocation(float returnLocation) {
		this.returnLocation = returnLocation;
	}

	public float getTargetLocation() {
		return this.targetLocation;
	}

	public void setTargetLocation(float targetLocation) {
		this.targetLocation = targetLocation;
	}
}
