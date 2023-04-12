package com.github.hanyaeger.tutorial.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.tutorial.entities.Ball;
import com.github.hanyaeger.tutorial.entities.Pong;

public abstract class PowerUp extends SpriteEntity implements Collider {

    public PowerUp(String imageLocation, Coordinate2D initialLocation) {
        super(imageLocation, initialLocation);
    }

    public abstract void activate(Ball ball, Pong pong);
}