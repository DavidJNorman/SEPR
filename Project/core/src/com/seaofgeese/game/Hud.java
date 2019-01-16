package com.seaofgeese.game;

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


public class Hud implements Disposable{

    public Stage stage;
    private Viewport viewport;



    QueststateController QuestControl;

    private Integer gold;
    private float timeCount;
    private Integer score;

    private Label goldLabel;
    private Label scoreLabel;
    private Label GOLDLabel;
    private Label Empty;

    private Label QuestLabel;
    private Label scoreLabel1;
    MainGame mainGame;

    public Hud(SpriteBatch sb, MainGame mainGame){
        gold = 0;
        timeCount = 0;
        score = 0;
        this.mainGame = mainGame;

        viewport = new FitViewport(MainGame.V_WIDTH, MainGame.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        goldLabel = new Label(String.format("%03d", gold), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel =new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        GOLDLabel = new Label("GOLD", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

       // QuestLabel = new Label("Active Quests:\n-------------------\n" + QuestControl.toString(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        scoreLabel1 = new Label("SCORE", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(scoreLabel1).expandX().padTop(10);
//        table.add(QuestLabel).expandX().padTop(10);
        table.add(GOLDLabel).expandX().padTop(10);

        table.row();
        table.add(scoreLabel).expandX();
        //table.add(Empty).expandX();
        table.add(goldLabel).expandX();


        stage.addActor(table);

    }

    public void update(float delta){
        timeCount += delta;
        if(timeCount >= 1){
            mainGame.getPlayer().setPoints(mainGame.getPlayer().getPoints()+1);
            timeCount = 0;
        }

        //scoreLabel.setText(String.format("%06d", score));
        scoreLabel.setText(String.format("%06d", mainGame.getPlayer().getPoints()));
        goldLabel.setText(String.format("%03d", mainGame.getPlayer().getGold()));
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}