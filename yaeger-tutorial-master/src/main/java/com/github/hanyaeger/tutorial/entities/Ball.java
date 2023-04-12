package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.GameLevel;
import com.github.hanyaeger.tutorial.PongRedefined;
import com.github.hanyaeger.tutorial.entities.powerups.PaddleSpeedPowerUp;
import com.github.hanyaeger.tutorial.entities.powerups.SpeedPowerUp;
import javafx.scene.input.KeyCode;

import java.util.Random;
import java.util.Set;

public class Ball extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, Collided {

    private double direction;
    private int speed;

    public static int initialSpeed = 5;
    private int lastHit;
    private PongRedefined pongRedefined;
    private GameLevel gameLevel;

    private Pong lastHitPong;
    public Ball(GameLevel gameLevel, Coordinate2D location, String filePath, PongRedefined pongRedefined){
        super(filePath, location);

        this.direction = 135d;
        this.speed = 5;
        this.lastHit = 1;
        this.pongRedefined = pongRedefined;
        setMotion(speed, direction);

        this.gameLevel = gameLevel;
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border){
        double angle;
        switch(border){
            case RIGHT:
                setAnchorLocation(new Coordinate2D(gameLevel.getWidth() / 2.0, gameLevel.getHeight() / 2.0));
                gameLevel.scorePlayer1 += 1;
                break;
            case LEFT:
                setAnchorLocation(new Coordinate2D(gameLevel.getWidth() / 2.0, gameLevel.getHeight() / 2.0));
                gameLevel.scorePlayer2 += 1;
                break;
            default:

                break;
        }
        gameLevel.checkScore();
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Pong) {

            checkAndFixPongSpeed(((Pong) collider));
            lastHitPong = ((Pong) collider);
            double angle = ((Pong) collider).angleTo(this);
            this.direction = angle;
            setMotion(getSpeed(), angle);

            checkAndFixSpeed();
        }

        if (collider instanceof Border) {

            if ( ((Border) collider).getBorder() == "top") {
                if (this.direction > 90 && this.direction < 180) {
                    this.direction = 180 - direction;
                } else if(this.direction < 270) {
                    this.direction = 270 + (270 - direction);
                }
            } else {
                if (this.direction < 359 && this.direction > 270) {
                    this.direction = 270 - (direction - 270);
                } else if(this.direction > 0) {
                    this.direction  = 180 - direction;
                }
            }

            setMotion(getSpeed(), this.direction);
        }

        if (collider instanceof SpeedPowerUp) {

            ((SpeedPowerUp) collider).activate(this, lastHitPong);
            ((SpeedPowerUp) collider).remove();
        }

        if (collider instanceof PaddleSpeedPowerUp) {

            ((PaddleSpeedPowerUp) collider).activate(this, lastHitPong);
            ((PaddleSpeedPowerUp) collider).remove();
        }
    }

    public void checkAndFixSpeed() {
        if (getSpeed() > initialSpeed) {
            setSpeed(initialSpeed);
        }
    }

    public void checkAndFixPongSpeed(Pong pong) {
        if (pong.getSpeed() > pong.initialSpeed) {
            pong.setSpeed(pong.initialSpeed);
        }
    }
}
