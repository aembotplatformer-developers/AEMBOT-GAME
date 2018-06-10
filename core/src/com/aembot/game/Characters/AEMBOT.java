package com.aembot.game.Characters;

import com.aembot.game.AembotPlatformer;
import com.aembot.game.Screens.PlayScreen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by mikeo on 6/5/2018.
 */
public class AEMBOT extends Sprite {

    private World world;
    private BodyDef bodyDef;
    public Body body;
    private FixtureDef fixtureDef;

    private float playerX, playerY;


    public AEMBOT(){



        world = PlayScreen.world;


        bodyDef = new BodyDef();
        bodyDef.position.set(32/ AembotPlatformer.PPM,32/AembotPlatformer.PPM);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
         body = world.createBody(bodyDef);



        fixtureDef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5/AembotPlatformer.PPM);
        fixtureDef.shape = shape;
        fixtureDef.restitution = 0;
        body.createFixture(fixtureDef);


    }

    public void moveXRight(){
        body.applyLinearImpulse(new Vector2(0.1f,0),body.getWorldCenter(),true);
    }

    public void moveXLeft(){
        body.applyLinearImpulse(new Vector2(-0.1f,0),body.getWorldCenter(),true);
    }

    public void moveY(){
        body.applyLinearImpulse(new Vector2(0,4f),body.getWorldCenter(),true);

    }





}
