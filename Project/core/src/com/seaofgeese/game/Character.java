package com.seaofgeese.game;

//import com.sun.javaws.exceptions.InvalidArgumentException;


import com.badlogic.gdx.graphics.g2d.Sprite;


import java.util.HashMap;
import java.util.Map;

public abstract class Character extends Sprite {

    public enum IDs {
        PLAYER, FRIENDLY, ENEMY, NEUTRAL
    }

    protected IDs id;

    protected int idCode;
    protected int gold;
    protected int points;
    protected int xPos;
    protected int yPos;
    protected int noOfCannons;
    protected int structureHealth;
    protected int maxStructureHealth;
    protected MainGame mainGame;

    protected Character(MainGame mainGame) {
        this.mainGame = mainGame;
        this.gold = 50;
        this.points = 0;
        this.noOfCannons = 3;
        this.maxStructureHealth = 100;
        this.structureHealth = maxStructureHealth;
    }

    public IDs getIdType() {
        return this.id;
    }

    public void setIdType(IDs id) { this.id = id; }

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

    public int getNoOfCannons() {
        return noOfCannons;
    }

    public int getStructureHealth() {
        return structureHealth;
    }

    public void setStructureHealth(int structureHealth) {
        this.structureHealth = structureHealth;
    }

    public int getMaxStructureHealth() {
        return maxStructureHealth;
    }

    public void setMaxStructureHealth(int maxStructureHealth) {
        this.maxStructureHealth = maxStructureHealth;
    }

}
