package com.github.hanyaeger.tutorial.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.GameLevel;
import com.github.hanyaeger.tutorial.entities.Ball;
import com.github.hanyaeger.tutorial.entities.Pong;

public class PaddleSpeedPowerUp extends PowerUp {

    private int speedIncrement;

    public PaddleSpeedPowerUp(Coordinate2D initialLocation) {
        super("sprites/PaddleSpeedPowerUp.png", initialLocation);
        this.speedIncrement = 3;
    }

    @Override
    public void activate(Ball ball, Pong pong) {
        if (pong.getSpeed() < pong.initialSpeed + 1) {
            pong.speed = pong.initialSpeed + speedIncrement;
        }
    }
}