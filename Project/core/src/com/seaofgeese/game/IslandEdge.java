package com.seaofgeese.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.seaofgeese.game.MainScreen;
import com.seaofgeese.game.MainGame;
import com.seaofgeese.game.StaticInteractiveCollisionObject;

public class IslandEdge extends StaticInteractiveCollisionObject {
    @Override
    public void collided() {
        Gdx.app.log("Edge","Collision");
    }

    public IslandEdge(MainScreen screen, Rectangle rect) {
        super(screen, rect);
        fixture.setUserData(this);
        setCategoryFilter(MainGame.DEFAULT_BIT);
    }
}
