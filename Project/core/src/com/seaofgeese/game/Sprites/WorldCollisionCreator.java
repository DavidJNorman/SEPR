package com.mygdx.game.Sprites;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Screen.PlayScreen;

import com.seaofgeese.game.Sprites.IslandEdge;

public class WorldCollisionCreator {
    public WorldCollisionCreator(PlayScreen screen){
        World world = screen.getWorld();
        TiledMap map = screen.getMap();

        for(MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new IslandEdge(screen, rect);
        }





    }
}
