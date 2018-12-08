package com.seaofgeese.game;

public class Player extends Character {
    protected Player() {
        super();
        this.id = IDs.PLAYER;
        this.gold = 50; // can be changed once we know what we're doing
        this.xPos = 1; // ditto
        this.yPos = 1; // ditto
        this.movePoints = 3;
    }

    public boolean encountered(NonPCharacter npc) {
        return (this.xPos == npc.getxPos() && this.yPos == npc.getyPos());
    }

}
