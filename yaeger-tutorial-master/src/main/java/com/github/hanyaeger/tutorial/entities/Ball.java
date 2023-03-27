package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Ball extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, Collided {

    private double direction;
    private int speed;

    private int lastHit;
    public Ball(Coordinate2D location, String filePath){
        super(filePath, location);

        this.direction = 260d;
        this.speed = 5;
        this.lastHit = 1;
        setMotion(speed, direction);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border){
        switch(border){
            case RIGHT:
                // player 1 scores
                break;
            case LEFT:
                // player 2 scores
                break;
            default:
                break;
        }
    }

    @Override
    public void onCollision(Collider collider) {
        this.direction = Math.abs(this.direction + 180);
        System.out.println(this.direction);
        setMotion(this.speed, this.direction);
    }
}
