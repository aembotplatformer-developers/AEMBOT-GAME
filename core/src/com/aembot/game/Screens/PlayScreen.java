package com.aembot.game.Screens;

import com.aembot.game.AembotPlatformer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class PlayScreen implements Screen {

    public static final float PPM = 100;

    public static World world;


    private AembotPlatformer game;
    Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private HUD hud;

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;



    public PlayScreen(AembotPlatformer game) {
        this.game = game;
     //   texture = new Texture("badlogic.jpg");
        gamecam = new OrthographicCamera();
        gamePort = new StretchViewport(AembotPlatformer.V_WIDTH,AembotPlatformer.V_HEIGHT, gamecam);
        hud = new HUD(game.batch,0,0,0,this);

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("Strongholdmap1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        gamecam.position.set(gamePort.getWorldWidth()/2, gamePort.getWorldHeight()/2, 0);

        world = new World(new Vector2(0,10),true);

    }

    @Override
    public void show() {

    }

    public void handleInput(float dt){ //Temporary
        if(Gdx.input.isTouched())
            gamecam.position.x+=100*dt;
    }

    public void update(float dt) {
        handleInput(dt);
        gamecam.update();
        renderer.setView(gamecam);
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();
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
