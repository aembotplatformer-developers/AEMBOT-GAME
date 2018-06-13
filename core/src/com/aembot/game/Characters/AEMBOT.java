package com.aembot.game.Characters;

import com.aembot.game.AembotPlatformer;
import com.aembot.game.Screens.PlayScreen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by mikeo on 6/5/2018.
 */
public class AEMBOT extends Sprite {

    public static String PlayerID;

    private World world;
    private BodyDef bodyDef;
    public Body body;
    private FixtureDef fixtureDef;
    private Rectangle bounds;

    private float playerX, playerY;

    public AEMBOT(){
        //bounds.set(getX(), getY(), getWidth(), getHeight());
        world = PlayScreen.world;

        bodyDef = new BodyDef();
        bodyDef.position.set(32/ AembotPlatformer.PPM,32/AembotPlatformer.PPM);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bodyDef);


        fixtureDef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5/AembotPlatformer.PPM);
        fixtureDef.shape = shape;

        fixtureDef.filter.categoryBits = AembotPlatformer.CHARACTER_BIT;
        fixtureDef.restitution = 0;
       // fixtureDef.filter.maskBits = AembotPlatformer.PLATFORM_BIT;
        Fixture fixture = body.createFixture(fixtureDef);
        fixture.setUserData("Player");

    }

    public void moveXRight(){
        body.applyLinearImpulse(new Vector2(0.05f,0),body.getWorldCenter(),true);
    }

    public void moveXLeft(){
        body.applyLinearImpulse(new Vector2(-0.05f,0),body.getWorldCenter(),true);
    }

    public void moveY(){
        body.applyLinearImpulse(new Vector2(0,4f),body.getWorldCenter(),true);

    }

}
