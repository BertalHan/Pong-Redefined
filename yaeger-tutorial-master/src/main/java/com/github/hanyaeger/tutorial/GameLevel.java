package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.entities.Ball;
import com.github.hanyaeger.tutorial.entities.Pong;

public class GameLevel extends com.github.hanyaeger.api.scenes.DynamicScene {

    private PongRedefined pongRedefined;
    public GameLevel(PongRedefined pongRedefined) {
        this.pongRedefined = pongRedefined;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/PongBackground.png");
    }

    @Override
    public void setupEntities() {
        var pongLeft = new Pong(new Coordinate2D(getWidth() * 0.04, getHeight() / 2), "sprites/paddle.png", 0);
        pongLeft.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(pongLeft);
        var pongRight = new Pong(new Coordinate2D(getWidth() * 0.96, getHeight() / 2), "sprites/paddle.png", 1);
        pongRight.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(pongRight);
        var ball = new Ball(new Coordinate2D(getWidth() / 2, getHeight() / 2), "sprites/ball.png");
        ball.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(ball);
    }
}
