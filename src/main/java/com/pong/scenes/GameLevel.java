package com.pong.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.pong.entities.PongBall;

public class GameLevel extends DynamicScene {
    protected PongBall[] pongBalls;

    public GameLevel() {
        pongBalls = new PongBall[] {
                new PongBall(new Coordinate2D(10, 10), 10)
        };
    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        addEntity(pongBalls[0]);
    }
}
