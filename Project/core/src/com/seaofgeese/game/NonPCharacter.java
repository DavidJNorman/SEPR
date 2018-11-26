package com.seaofgeese.game;

public class NonPCharacter extends Character {
    protected NonPCharacter(IDs id, int gold, int xPos, int yPos, int movePoints) {
        super();
        this.id = id;
        this.gold = gold;
        this.xPos = xPos;
        this.yPos = yPos;
        this.movePoints = movePoints;
    }

    public boolean encounteredPlayer(Player player) { // DIFFERENT from A1
        return (this.xPos == player.getxPos() && this.yPos == player.getyPos());
    }
}
