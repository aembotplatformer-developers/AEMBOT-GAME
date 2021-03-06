package com.aembot.game;

import com.aembot.game.Screens.PlayScreen;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/**
 * @author Goirick Saha
 */
public class AembotPlatformer extends Game {
	public SpriteBatch batch;
	public static final int V_WIDTH = 268;
	public static final int V_HEIGHT = 200;
	public static final float PPM = 100;
	public static final short CHARACTER_BIT = 3;
	public static final short PLATFORM_BIT = 1;
	public static final short PICKUP_BIT = 2;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
