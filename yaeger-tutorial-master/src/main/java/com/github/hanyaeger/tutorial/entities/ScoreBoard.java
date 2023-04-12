package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import com.github.hanyaeger.tutorial.GameLevel;
import javafx.scene.paint.Color;

public class ScoreBoard extends DynamicTextEntity implements UpdateExposer {
    private double oldPlayerScore1;
    private double oldPlayerScore2;
    private GameLevel gameLevel;

    public ScoreBoard(GameLevel gameLevel) {
        super(new Coordinate2D(10.0, 10.0));

        setFill(Color.WHITE);

        this.gameLevel = gameLevel;

        oldPlayerScore1 = gameLevel.scorePlayer1;
        oldPlayerScore2 = gameLevel.scorePlayer2;

        updateText();
    }

    private void updateText() {
        setText("Speler 1: " + gameLevel.scorePlayer1 + ", Speler 2: " + gameLevel.scorePlayer2);
    }


    @Override
    public void explicitUpdate(long l) {
        double threshold = 0.000001;

        if (Math.abs(oldPlayerScore1 - gameLevel.scorePlayer1) > threshold || Math.abs(oldPlayerScore2 - gameLevel.scorePlayer2) > threshold) {
            updateText();
            oldPlayerScore1 = gameLevel.scorePlayer1;
            oldPlayerScore2 = gameLevel.scorePlayer2;
        }
    }
}
