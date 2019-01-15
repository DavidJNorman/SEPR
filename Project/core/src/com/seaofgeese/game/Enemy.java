package com.seaofgeese.game;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.seaofgeese.game.MainScreen;
import com.seaofgeese.game.MainScreen;

public abstract class Enemy extends Character {
    protected World world;
    protected MainScreen screen;
    public Body b2body;

    public Enemy(MainScreen screen, float x, float y){
        super();
        this.gold = 100;
        this.id = IDs.ENEMY;
        this.screen = screen;
        this.world = screen.getWrold();
        setPosition(x, y);
    }
    protected abstract void defineEnemy();
    public abstract void startBattle();

}
