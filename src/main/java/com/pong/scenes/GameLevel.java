package com.pong.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.pong.PongGame;
import com.pong.entities.PongBall;
import com.pong.entities.paddles.types.ComputerPaddle;
import com.pong.entities.paddles.types.PlayerPaddle;

import java.util.ArrayList;
import java.util.Random;

public class GameLevel extends DynamicScene {
    public ArrayList<PongBall> pongBalls = new ArrayList<>();
    public PongGame pongGameObject;

    public GameLevel(PongGame pongGameObject) {
        this.pongGameObject = pongGameObject;
    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        setPongBalls();
        addEntity(new PlayerPaddle(new Coordinate2D(5, 100)));
        addEntity(new ComputerPaddle(new Coordinate2D(getWidth() - 25, 100), this));
    }

    public void setPongBalls() {
        for (PongBall pongBall : pongBalls) {
            pongBall.remove();
        }

        pongBalls.clear();

        for (int i = 0; i < 1; i++) {
            createPongBall();
        }
    }

    public void createPongBall() {
        Random r = new Random();

        double hWidth = getWidth()/2;
        double hHeight = getHeight()/2;

        pongBalls.add(new PongBall(
                new Coordinate2D(
                        r.nextDouble(hWidth - hWidth/2, hWidth + hWidth/2),
                        r.nextDouble(hHeight - hHeight/2, hHeight + hHeight/2)
                ),
                10,
                this
        ));

        addEntity( pongBalls.get(pongBalls.size()-1) );
    }

    public void playerScored() {
        setPongBalls();
    }

    public void computerScored() {
        setPongBalls();
    }
}
