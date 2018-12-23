package com.mygdx.game.Scene;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.SeaOfGeese;

/**
 * Created by brentaureli on 8/17/15.
 */
public class Hud implements Disposable{

    public Stage stage;
    private Viewport viewport;

    private Integer gold;
    private float timeCount;
    private Integer score;

    private Label countdownLabel;
    private Label scoreLabel;
    private Label timeLabel;
    private Label Empty;

    private Label worldLabel;
    private Label scoreLabel1;

    public Hud(SpriteBatch sb){
        gold = 0;
        timeCount = 0;
        score = 0;


        viewport = new FitViewport(SeaOfGeese.V_WIDTH, SeaOfGeese.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        countdownLabel = new Label(String.format("%03d", gold), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel =new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        timeLabel = new Label("GOLD", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        worldLabel = new Label("MAIN  WORLD", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel1 = new Label("SCORE", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(scoreLabel1).expandX().padTop(10);
        table.add(worldLabel).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);

        table.row();
        table.add(scoreLabel).expandX();
        table.add(Empty).expandX();
        table.add(countdownLabel).expandX();


        stage.addActor(table);

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
