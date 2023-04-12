package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Size;

public class PongRedefined extends com.github.hanyaeger.api.YaegerGame{

    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void setupGame() {
        setGameTitle("PONG REDEFINED");
        setSize(new Size(1400, 900));
    }

    @Override
    public void setupScenes(){
        addScene(0, new TitleScene( this));
        addScene(1, new GameLevel(this));
        addScene(2, new EndScene(this));
    }
}
