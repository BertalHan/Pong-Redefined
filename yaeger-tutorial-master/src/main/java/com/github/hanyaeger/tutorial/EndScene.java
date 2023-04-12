package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.tutorial.entities.buttons.EndButton;
import com.github.hanyaeger.tutorial.entities.buttons.StartButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EndScene extends com.github.hanyaeger.api.scenes.StaticScene {

    private PongRedefined pongRedefined;


    public EndScene(PongRedefined pongRedefined) {
        this.pongRedefined = pongRedefined;
    }
    @Override
    public void setupScene() {
//        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities(){
        var endText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "EINDE SPEL"
        );
        endText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        endText.setFill(Color.DARKBLUE);
        endText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(endText);

        var restartButton = new EndButton(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 80), pongRedefined);
        restartButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(restartButton);
    }
}
