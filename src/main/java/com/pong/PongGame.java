package com.pong;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class PongGame extends YaegerGame {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setSize(new Size(800, 600));
        setGameTitle("Pong");
    }

    @Override
    public void setupScenes() {

    }
}
