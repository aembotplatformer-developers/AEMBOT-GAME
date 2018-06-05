package com.aembot.game.Screens;

import com.aembot.game.AembotPlatformer;
import com.aembot.game.Bodies.AEMBOT;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class PlayScreen implements Screen {

    public static World world;

    private AembotPlatformer game;
    Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private HUD hud;

    private Box2DDebugRenderer b2dr;
    private AEMBOT aembot;


    public PlayScreen(AembotPlatformer game) {
        this.game = game;
     //   texture = new Texture("badlogic.jpg");
        gamecam = new OrthographicCamera();

        gamePort = new StretchViewport(800, 480, gamecam);

        hud = new HUD(game.batch,0,0,0,this);

        world = new World(new Vector2(0,9.8f),true);

        b2dr = new Box2DDebugRenderer();

        aembot = new AEMBOT();


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        b2dr.render(world,gamecam.combined);
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();




    }

    public void update(float dt){

        world.step(dt,8,3);

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
