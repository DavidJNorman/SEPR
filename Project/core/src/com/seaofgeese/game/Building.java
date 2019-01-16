package com.seaofgeese.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.seaofgeese.game.MainScreen;
import com.seaofgeese.game.MainScreen;


//Building
public abstract class Building extends Character {
    public IDs id;

    public Building(MainGame mainGame){
        super(mainGame);
        this.id = IDs.ENEMY;
    }

    public void setVanbrughMinion(){
        this.idCode = 1;
        this.gold = 30;
        this.points = 100;
        this.noOfCannons = 2;
        this.maxStructureHealth = 100;
        this.structureHealth = this.maxStructureHealth;
    }

    public void setVanbrughBoss(){
        this.idCode = 2;
        this.gold = 60;
        this.points = 300;
        this.noOfCannons = 3;
        this.maxStructureHealth = 200;
        this.structureHealth = this.maxStructureHealth;
    }

    public void setJamesMinion(){
        this.idCode = 3;
        this.gold = 60;
        this.points = 900;
        this.noOfCannons = 3;
        this.maxStructureHealth = 150;
        this.structureHealth = this.maxStructureHealth;
    }

    public void setJamesBoss(){
        this.idCode = 4;
        this.gold = 90;
        this.points = 1700;
        this.noOfCannons = 4;
        this.maxStructureHealth = 250;
        this.structureHealth = this.maxStructureHealth;
    }

    public void setHalifaxMinion(){
        this.idCode = 5;
        this.gold = 175;
        this.points = 3500;
        this.noOfCannons = 4;
        this.maxStructureHealth = 150;
        this.structureHealth = this.maxStructureHealth;
    }

    public void setHalifaxBoss(){
        this.idCode = 6;
        this.gold = 250;
        this.points = 5000;
        this.noOfCannons = 5;
        this.maxStructureHealth = 350;
        this.structureHealth = this.maxStructureHealth;
    }

    protected abstract void defineEnemy();
    public abstract void startBattle();
}