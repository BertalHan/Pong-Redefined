package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.tutorial.GameLevel;
import com.github.hanyaeger.tutorial.PongRedefined;
import javafx.scene.paint.Color;

public class Border extends DynamicRectangleEntity implements Collider {

    private String type;
    public Border(Coordinate2D location, PongRedefined pongRedefined, GameLevel gameLevel, String type) {
        super(location, new Size(gameLevel.getWidth(), 1));
        this.setFill(Color.WHITE);
        this.type = type;
    }

    public String getBorder() {
        return this.type;
    }

}
