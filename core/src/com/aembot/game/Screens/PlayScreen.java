package com.aembot.game.Screens;

import com.aembot.game.AembotPlatformer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class PlayScreen implements Screen {

    private AembotPlatformer game;
    Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private HUD hud;

    public PlayScreen(AembotPlatformer game) {
        this.game = game;
     //   texture = new Texture("badlogic.jpg");
        gamecam = new OrthographicCamera();
        gamePort = new StretchViewport(800, 480, gamecam);
        hud = new HUD(game.batch,0,0,0,this);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
        //game.batch.begin();
      //  game.batch.draw(texture, 0, 0);
        //game.batch.end();



    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public int getHeight(){return gamePort.getScreenHeight();}

    public int getWidth(){return gamePort.getScreenWidth();}

    public Camera getCam(){return gamecam;}
}
