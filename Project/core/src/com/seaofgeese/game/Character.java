package com.seaofgeese.game;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.HashMap;
import java.util.Map;

public abstract class Character {

    public enum IDs {
        PLAYER, FRIENDLY, ENEMY, NEUTRAL;
    } // NOTE THIS DOWN - CHANGED FROM A1

    private IDs id;

    private int gold,
            xPos,
            yPos,
            sailHealth,
            cannonHealth,
            structureHealth,
            maxSailHealth,
            maxCannonHealth,
            maxStructureHealth,
            movePoints;

    private Map<String, Integer> ammunition;

    protected Character() {
        this.maxSailHealth = 100;
        this.maxCannonHealth = 100;
        this.maxStructureHealth = 100;
        this.sailHealth = maxSailHealth;
        this.cannonHealth = maxCannonHealth;
        this.structureHealth = maxStructureHealth;
        this.ammunition = new HashMap<>();
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getSailHealth() {
        return sailHealth;
    }

    public void setSailHealth(int sailHealth) {
        this.sailHealth = sailHealth;
    }

    public int getCannonHealth() {
        return cannonHealth;
    }

    public void setCannonHealth(int cannonHealth) {
        this.cannonHealth = cannonHealth;
    }

    public int getStructureHealth() {
        return structureHealth;
    }

    public void setStructureHealth(int structureHealth) {
        this.structureHealth = structureHealth;
    }

    public int getMovePoints() {
        return movePoints;
    }

    public void setMovePoints(int movePoints) {
        this.movePoints = movePoints;
    }

    public void addAmmunition(String ammoType, Integer ammoNum) {
        if (this.ammunition.containsKey(ammoType)) {
            this.ammunition.put(ammoType, this.ammunition.get(ammoType) + ammoNum);
        } else {
            this.ammunition.put(ammoType, ammoNum);
        }
    }

    public int getAmmunition(String ammoType) {
        if (this.ammunition.containsKey(ammoType)) {
            return this.ammunition.get(ammoType);
        } else throw new IllegalArgumentException("Not a valid type of ammunition!");
    }

}
