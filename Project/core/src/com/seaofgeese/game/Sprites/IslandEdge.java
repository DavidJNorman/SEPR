package com.seaofgeese.game.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Screen.PlayScreen;
import com.mygdx.game.SeaOfGeese;

public class IslandEdge extends StaticInteractiveCollisionObject {
    @Override
    public void collided() {
        Gdx.app.log("Edge","Collision");
    }

    public IslandEdge(PlayScreen screen, Rectangle rect) {
        super(screen, rect);
        fixture.setUserData(this);
        setCategoryFilter(SeaOfGeese.DEFAULT_BIT);
    }
}
