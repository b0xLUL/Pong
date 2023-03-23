package com.pong;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.pong.scenes.GameLevel;
import com.pong.scenes.OptionsMenu;
import com.pong.scenes.TitleScene;

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
        addScene(0, new TitleScene(this));
        addScene(1, new GameLevel());
        addScene(2, new OptionsMenu());
    }
}
