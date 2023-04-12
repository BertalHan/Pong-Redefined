package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.entities.Ball;
import com.github.hanyaeger.tutorial.entities.Border;
import com.github.hanyaeger.tutorial.entities.Pong;
import com.github.hanyaeger.tutorial.entities.ScoreBoard;
import com.github.hanyaeger.tutorial.entities.powerups.PaddleSpeedPowerUp;
import javafx.application.Platform;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.entities.powerups.SpeedPowerUp;
import javafx.animation.AnimationTimer;
import java.util.Random;



public class GameLevel extends DynamicScene {

    public Double scorePlayer1;
    public Double scorePlayer2;

    private Double ScoreLimit = 3.0;
    private PongRedefined pongRedefined;
    private AnimationTimer powerUpSpawner;
    private long previousTime;
    private static final long SPAWN_INTERVAL = 10_000_000_000L; // 5 seconds in nanoseconds
    private Random random;

    public GameLevel(PongRedefined pongRedefined) {
        this.pongRedefined = pongRedefined;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/PongBackground.png");

        this.scorePlayer1 = 0.0;
        this.scorePlayer2 = 0.0;
        random = new Random();
    }

    @Override
    public void setupEntities() {

        var scoreBoard = new ScoreBoard(this);
        scoreBoard.setAnchorPoint(AnchorPoint.TOP_LEFT);
        addEntity(scoreBoard);

        var pongLeft = new Pong(new Coordinate2D(getWidth() * 0.04, getHeight() / 2), "sprites/paddle.png", 0);
        pongLeft.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(pongLeft);

        var pongRight = new Pong(new Coordinate2D(getWidth() * 0.96, getHeight() / 2), "sprites/paddle.png", 1);
        pongRight.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(pongRight);

        var ball = new Ball(this, new Coordinate2D(getWidth() / 2, getHeight() / 2), "sprites/ball.png", this.pongRedefined);
        ball.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(ball);

        var borderTop = new Border(new Coordinate2D(getWidth() / 2, 1), this.pongRedefined, this, "top");
        borderTop.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(borderTop);

        var borderBottom = new Border(new Coordinate2D(getWidth() / 2, getHeight() - 1), this.pongRedefined, this, "bottom");
        borderBottom.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(borderBottom);

        powerUpSpawner = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (now - previousTime > SPAWN_INTERVAL) {
                    double x = 100 + random.nextDouble() * (getWidth() - 200);
                    double y = 100 + random.nextDouble() * (getHeight() - 200);
                    if (Math.random() > 0.5) {
                        var powerUp = new SpeedPowerUp(new Coordinate2D(x, y));
                        addEntity(powerUp);
                    } else {
                        var powerUp = new PaddleSpeedPowerUp(new Coordinate2D(x, y));
                        addEntity(powerUp);
                    }


                    previousTime = now;
                }
            }
        };

        powerUpSpawner.start();

    }

    public void checkScore() {
        System.out.println(this.scorePlayer1 + " " + this.scorePlayer2);
        if (this.scorePlayer1 >= ScoreLimit) {
            Platform.runLater(() -> {
                pongRedefined.setActiveScene(2);
            });
        } else if (this.scorePlayer2 >= ScoreLimit) {
            Platform.runLater(() -> {
                pongRedefined.setActiveScene(2);
            });
        }
    }

}
