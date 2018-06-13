package com.aembot.game.Characters;

import com.aembot.game.AembotPlatformer;
import com.aembot.game.Screens.PlayScreen;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
/**
 * @author Goirick Saha
 */

public class Robot extends Enemy{
    public Body body;
    private FixtureDef fixtureDef;

    public Robot(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        //Implement robot sprite here

        setBounds(getX(), getY(), 16/AembotPlatformer.PPM, 16/AembotPlatformer.PPM);
    }

    @Override
    protected void defineEnemy()
    {
        BodyDef bodyDef = new BodyDef();
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

    public void update(float dt)
    {
        //stateTime += dt;
        setPosition(body.getPosition().x-getWidth()/2, body.getPosition().y-getHeight()/2);
        body.setLinearVelocity(velocity);
    }
}
