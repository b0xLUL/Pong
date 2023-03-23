package com.pong.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.pong.entities.PongBall;
import com.pong.entities.paddles.types.ComputerPaddle;
import com.pong.entities.paddles.types.PlayerPaddle;

import java.util.ArrayList;

public class GameLevel extends DynamicScene {
    public ArrayList<PongBall> pongBalls = new ArrayList<>();

    public GameLevel() {

    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        pongBalls.add(new PongBall(new Coordinate2D(getWidth()/2, getHeight()/2),10 ));

        addEntity(new PlayerPaddle(new Coordinate2D(5, 100)));
        addEntity(new ComputerPaddle(new Coordinate2D(getWidth() - 25, 100), this));
        addEntity(pongBalls.get(0));
    }
}
