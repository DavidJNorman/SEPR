package com.seaofgeese.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.seaofgeese.game.MainScreen;
import com.seaofgeese.game.MainScreen;


//Building
public class Building extends Character {
    public IDs id;

    public Building(MainGame mainGame){
        super(mainGame);

    }


    public void setVanbrughBoss(){
        this.id = IDs.NEUTRAL;
        this.idCode = 2;
        this.gold = 60;
        this.points = 300;
        this.noOfCannons = 3;
        this.maxStructureHealth = 200;
        this.structureHealth = this.maxStructureHealth;
    }


    public void setJamesBoss(){
        this.id = IDs.NEUTRAL;
        this.idCode = 4;
        this.gold = 90;
        this.points = 1700;
        this.noOfCannons = 4;
        this.maxStructureHealth = 250;
        this.structureHealth = this.maxStructureHealth;
    }


    public void setHalifaxBoss(){
        this.id = IDs.NEUTRAL;
        this.idCode = 6;
        this.gold = 250;
        this.points = 5000;
        this.noOfCannons = 5;
        this.maxStructureHealth = 350;
        this.structureHealth = this.maxStructureHealth;
    }

    public void setPhysicsDepartment(){
        this.id = IDs.ENEMY;
        this.idCode = 9;
        this.gold = 250;
        this.points = 4000;
        this.noOfCannons = 4;
        this.maxStructureHealth = 300;
        this.structureHealth = this.maxStructureHealth;
    }

    public void setBiologyDepartment(){

        this.id = IDs.ENEMY;
        this.idCode = 10;
        this.gold = 300;
        this.points = 4500;
        this.noOfCannons = 4;
        this.maxStructureHealth = 350;
        this.structureHealth = this.maxStructureHealth;
    }
}