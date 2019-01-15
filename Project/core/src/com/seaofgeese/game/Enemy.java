package com.seaofgeese.game;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.seaofgeese.game.MainScreen;
import com.seaofgeese.game.MainScreen;

public abstract class Enemy extends Character {
    protected World world;

    public Body b2body;

    public Enemy(MainGame mainGame, float x, float y){
        super();
        this.gold = 100;
        this.id = IDs.ENEMY;

        this.world = mainGame.getWorld();
        setPosition(x, y);
    }
    protected abstract void defineEnemy();
    public abstract void startBattle();

}
