package com.aembot.game.Tools;

import com.aembot.game.Screens.PlayScreen;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by mikeo on 6/12/2018.
 */
public class ObjectCollisionHandler implements ContactListener {
    @Override
    public void beginContact(Contact contact) {

        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        if(fixB.getUserData() == "Coin" && fixA.getUserData() == "Player"){
           System.out.println("Coin touch");
            PlayScreen.addScore(100);
            contact.getFixtureB().setUserData("DED");
            System.out.println(contact.getFixtureB().getUserData());
        }

    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
