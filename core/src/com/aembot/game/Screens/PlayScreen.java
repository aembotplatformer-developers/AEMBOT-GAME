package com.aembot.game.Screens;

import com.aembot.game.AembotPlatformer;
import com.aembot.game.Characters.AEMBOT;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.w3c.dom.css.Rect;

public class PlayScreen implements Screen {

    public static final float PPM = 100;

    public static World world;
    private Box2DDebugRenderer b2dr;

    private AembotPlatformer game;
    Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private HUD hud;
    private AEMBOT aembot;

    public static TmxMapLoader mapLoader = new TmxMapLoader();;
    public static  TiledMap map = mapLoader.load("core/assets/Strongholdmap1.tmx");;
    public static OrthogonalTiledMapRenderer renderer = new OrthogonalTiledMapRenderer(map);;

    public PlayScreen(AembotPlatformer game) {
        this.game = game;
     //   texture = new Texture("badlogic.jpg");
        gamecam = new OrthographicCamera();
        gamePort = new StretchViewport(AembotPlatformer.V_WIDTH,AembotPlatformer.V_HEIGHT, gamecam);
        hud = new HUD(game.batch,0,0,0,this);
        
        gamecam.position.set(gamePort.getWorldWidth()/2, gamePort.getWorldHeight()/2, 0);

        world = new World(new Vector2(0,10),true);
        b2dr = new Box2DDebugRenderer();

        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        for(MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject)object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set(rect.getX()+rect.getWidth()/2, rect.getY() + rect.getHeight()/2);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth()/2, rect.getHeight()/2);

            fdef.shape = shape;

            body.createFixture(fdef);
        }


        aembot = new AEMBOT();

    }

    @Override
    public void show() {

    }

    public void handleInput(float dt){ //Temporary
        if(Gdx.input.isTouched()) {
            gamecam.position.x += 100 * dt;
        }


    }

    public void update(float dt) {
        handleInput(dt);
        world.step(1/60f,5,2);
        gamecam.update();
        renderer.setView(gamecam);
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        b2dr.render(world, gamecam.combined);

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

    public TiledMap getMap(){return map;}
}
