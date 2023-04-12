package com.github.hanyaeger.tutorial.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.GameLevel;
import com.github.hanyaeger.tutorial.entities.Ball;
import com.github.hanyaeger.tutorial.entities.Pong;

public class SpeedPowerUp extends PowerUp {

    private double speedIncrease = 3;

    public SpeedPowerUp(Coordinate2D initialLocation) {
        super("sprites/speed-powerup.png", initialLocation);
    }

    @Override
    public void activate(Ball ball, Pong pong) {
        if (ball.getSpeed() < (ball.initialSpeed + 1)) {
            ball.setSpeed(ball.getSpeed() + speedIncrease);
        }
    }
}