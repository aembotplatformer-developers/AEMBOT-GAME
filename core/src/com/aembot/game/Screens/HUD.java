package com.aembot.game.Screens;

import com.aembot.game.AembotPlatformer;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.*;
import java.awt.Label;

public class HUD {
    private Viewport viewport;
    public Stage stage;

    private int score;

    private com.badlogic.gdx.scenes.scene2d.ui.Label levelL,levelTitle;
    private com.badlogic.gdx.scenes.scene2d.ui.Label scoreL,scoreTitle;
    private com.badlogic.gdx.scenes.scene2d.ui.Label ammoL,ammoTitle;

    public HUD(SpriteBatch HudBatch, int score, int level, int ammo, PlayScreen screen){

        this.score = score;

    viewport = new FitViewport(AembotPlatformer.V_WIDTH,AembotPlatformer.V_HEIGHT,new OrthographicCamera());
    stage = new Stage(viewport,HudBatch);

    levelL = new com.badlogic.gdx.scenes.scene2d.ui.Label((String.format("%02d",level)), new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle(new BitmapFont(), Color.WHITE));
    scoreL = new com.badlogic.gdx.scenes.scene2d.ui.Label((String.format("%06d",this.score)), new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle(new BitmapFont(), Color.WHITE));
    ammoL = new com.badlogic.gdx.scenes.scene2d.ui.Label((String.format("%03d",ammo)), new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle(new BitmapFont(), Color.WHITE));
    levelTitle = new com.badlogic.gdx.scenes.scene2d.ui.Label((String.format("Level")), new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle(new BitmapFont(), Color.WHITE));
    scoreTitle = new com.badlogic.gdx.scenes.scene2d.ui.Label((String.format("Score")), new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle(new BitmapFont(), Color.WHITE));
    ammoTitle = new com.badlogic.gdx.scenes.scene2d.ui.Label((String.format("Ammo")), new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle(new BitmapFont(), Color.WHITE));

    Table table = new Table();

    table.setY(viewport.getScreenY() - 50);

    table.setY(175);
    table.setX(AembotPlatformer.V_WIDTH/2);

    table.add(levelTitle).pad(10);
    table.add(scoreTitle).pad(10);
    table.add(ammoTitle).pad(10);
    table.row();
    table.add(levelL).padTop(10);
    table.add(scoreL).padTop(10);
    table.add(ammoL).padTop(10);


    stage.addActor(table);
    }

    public void update(int score){
        scoreL.setText(String.format("%06d",score));

    }
}
