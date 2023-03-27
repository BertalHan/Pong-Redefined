package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Pong extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Collider {

    private int id;
    public Pong(Coordinate2D location, String filePath, int id){
        super(filePath, location);
        this.id = id;
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (this.id == 0) {
            if(pressedKeys.contains(KeyCode.W)){
                setMotion(3,180d);
            } else if(pressedKeys.contains(KeyCode.S)){
                setMotion(3,0d);
            } else {
                setSpeed(0);
            }
        } else {
            if(pressedKeys.contains(KeyCode.UP)){
                setMotion(3,180d);
            } else if(pressedKeys.contains(KeyCode.DOWN)){
                setMotion(3,0d);
            } else {
                setSpeed(0);
            }
        }

    }

    public int getId() {
        return this.id;
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border){
        setSpeed(0);

        switch(border){
            case TOP:
                setAnchorLocationY(getHeight() / 2 + 1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() / 2 - 1);
                break;
            default:
                break;
        }
    }
}
