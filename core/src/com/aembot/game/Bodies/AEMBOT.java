package com.aembot.game.Bodies;

import com.aembot.game.Screens.PlayScreen;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by mikeo on 6/5/2018.
 */
public class AEMBOT extends Sprite {

    private World world;
    private BodyDef bodyDef;
    private FixtureDef fixtureDef;

    public AEMBOT(){
        world = PlayScreen.world;

        bodyDef = new BodyDef();
        bodyDef.position.set(50,50);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        Body body = world.createBody(bodyDef);


        PolygonShape shape = new PolygonShape();
        shape.setAsBox(10,10);

        fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        body.createFixture(fixtureDef);


    }

}
