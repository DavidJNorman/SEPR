package com.seaofgeese.game;

public class NonPCharacter extends Character {
    protected NonPCharacter(IDs NPCid, int gold, int xPos, int yPos, int movePoints) {
        super();
        id = NPCid;
        this.gold = gold;
        this.xPos = xPos;
        this.yPos = yPos;
        this.movePoints = movePoints;
    }
}
