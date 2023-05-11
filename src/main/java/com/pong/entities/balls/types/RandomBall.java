package com.pong.entities.balls.types;

import com.github.hanyaeger.api.Coordinate2D;
import com.pong.entities.balls.PongBall;
import com.pong.scenes.GameLevel;
import javafx.scene.paint.Color;

import java.util.Random;

public class RandomBall extends PongBall {
    public RandomBall(Coordinate2D initialLocation, double radius, GameLevel gameLevelObject) {
        super(initialLocation, radius, gameLevelObject, Color.YELLOW, 15);
    }

    @Override
    public void bounceBall(double angleOfHit) {
        Random speed = new Random();
        super.setSpeed( speed.nextInt(4, (int) maxSpeed));
        super.bounceBall(angleOfHit);
    }
}
