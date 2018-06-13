package com.aembot.game.Bodies;

import com.aembot.game.AembotPlatformer;
import com.aembot.game.Screens.PlayScreen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.physics.box2d.*;

import java.awt.*;

/**
 * Created by mikeo on 6/11/2018.
 */
public class Coins extends Sprite{


    private World world;
    private PlayScreen screen;
    private TiledMap map;

    private BodyDef bodyDef;
    private Body body;
    private FixtureDef fixtureDef;
    private CircleShape shape;
    private Fixture fixture;

    public Coins(float x, float y){
        bodyDef = new BodyDef();
        bodyDef.position.set(x,y);
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        world = PlayScreen.world;

        body = world.createBody(bodyDef);


        fixtureDef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5/AembotPlatformer.PPM);

        fixtureDef.shape = shape;
        fixtureDef.restitution = 0;
        fixtureDef.density = 0;

        fixtureDef.filter.categoryBits = AembotPlatformer.PICKUP_BIT;

        fixture = body.createFixture(fixtureDef);
       fixture.setUserData("Coin");

    }


    public boolean isDed(){
        return fixture.getUserData() == "Ded";
    }

    public void terminateCoin() {
        this.bodyDef.position.set(100,100);
    }


}
