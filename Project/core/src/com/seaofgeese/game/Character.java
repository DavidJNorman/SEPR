package com.seaofgeese.game;

//import com.sun.javaws.exceptions.InvalidArgumentException;


import com.badlogic.gdx.graphics.g2d.Sprite;


import java.util.HashMap;
import java.util.Map;

public abstract class Character extends Sprite {

    public enum IDs {
        PLAYER, FRIENDLY, ENEMY, NEUTRAL
    } // NOTE THIS DOWN - CHANGED FROM A1

    protected IDs id;

    protected int idCode;

    protected int gold;
    protected int points;
    protected int xPos;
    protected int yPos;
    protected int sailHealth;
    protected int cannonHealth;
    protected int structureHealth;
    protected int maxSailHealth;
    protected int maxCannonHealth;
    protected int maxStructureHealth;
    protected int movePoints;

    protected Map<String, Integer> ammunition;

    protected Character() {
        this.idCode = idCode;
        this.points = 0;
        this.maxSailHealth = 100;
        this.maxCannonHealth = 100;
        this.maxStructureHealth = 100;
        this.sailHealth = maxSailHealth;
        this.cannonHealth = maxCannonHealth;
        this.structureHealth = maxStructureHealth;
        //this.ammunition = new HashMap<>();
    }

    public int getId() {
        return this.idCode;
    }

    public void setId(int idToSet) { this.idCode = idToSet; }

    public int getGold() {
        return this.gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int pointsToSet) {
        this.points = pointsToSet;
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

    public int getMaxSailHealth() {
        return maxSailHealth;
    }

    public void setMaxSailHealth(int maxSailHealth) {
        this.maxSailHealth = maxSailHealth;
    }

    public int getMaxCannonHealth() {
        return maxCannonHealth;
    }

    public void setMaxCannonHealth(int maxCannonHealth) {
        this.maxCannonHealth = maxCannonHealth;
    }

    public int getMaxStructureHealth() {
        return maxStructureHealth;
    }

    public void setMaxStructureHealth(int maxStructureHealth) {
        this.maxStructureHealth = maxStructureHealth;
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
