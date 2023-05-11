package com.pong.entities.balls;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.pong.entities.paddles.Paddle;
import com.pong.scenes.GameLevel;
import javafx.scene.paint.Color;

import java.util.Random;

public class PongBall extends DynamicCircleEntity implements Collider, UpdateExposer {

    public GameLevel gameLevelObject;
    public Random r;
    public double maxSpeed;

    public PongBall(Coordinate2D initialLocation, double radius, GameLevel gameLevelObject, Color color, double maxSpeed) {
        super(initialLocation);

        r = new Random();

        int dir = r.nextInt(0, 2) == 1 ? 1 : -1;
        int angle = r.nextInt(90-45, 90+45);

        setFill(color);
        setRadius(radius);
        setMotion(4,angle * dir);

        this.gameLevelObject = gameLevelObject;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void explicitUpdate(long timestamp) {
        double currentY = getAnchorLocation().getY();
        double currentX = getAnchorLocation().getX();

        if (currentY + getRadius() > getSceneHeight()) {
            bounceBall(-180);
        } else if (currentY < -getRadius()) {
            bounceBall(180);
        }

        if (currentX > getSceneWidth() - getRadius()) {
            gameLevelObject.playerScored();
        } else if (currentX < 0) {
            gameLevelObject.computerScored();
        }
    }

    public void bounceBall(double angleOfHit) {
        setDirection(angleOfHit - getDirection());
    }

    public void collidedWithPaddle(Paddle collidingPaddle) {
        bounceBall(0);
        setSpeed(Math.min(getSpeed() + collidingPaddle.getSpeed()/4, maxSpeed));
    }
}
