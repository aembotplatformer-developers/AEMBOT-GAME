package com.aembot.game.Bodies;

import com.aembot.game.Characters.Robot;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import javax.swing.plaf.synth.Region;

/**
 * @author Goirick Saha
 */
public class Coin extends Actor {

    public static final int WIDTH = 32;
    public static final int HEIGHT = 32;
    private TextureRegion region;
    private Texture texture;
    private Vector2 val;
    private Robot robot;

    public Coin() {
        setWidth(WIDTH);
        setHeight(HEIGHT);
        val = new Vector2();
        texture = new Texture("badlogic.jpg");
        region = new TextureRegion(texture, 10, 10,10, 10);
    }

    public void act(float dt) {
        setPosition(100, 100);
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }
}
