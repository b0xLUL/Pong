package com.pong.entities.balls.types;

import com.github.hanyaeger.api.Coordinate2D;
import com.pong.entities.balls.PongBall;
import com.pong.scenes.GameLevel;
import javafx.scene.paint.Color;

public class FastBall extends PongBall {
    public FastBall(Coordinate2D initialLocation, double radius, GameLevel gameLevelObject) {
        super(initialLocation, radius, gameLevelObject, Color.BLUE, 20);
    }
}
