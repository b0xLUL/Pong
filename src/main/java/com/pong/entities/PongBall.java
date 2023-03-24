package com.pong.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.pong.scenes.GameLevel;
import javafx.scene.paint.Color;

import java.util.Random;

public class PongBall extends DynamicCircleEntity implements Collider, UpdateExposer {

    public GameLevel gameLevelObject;
    public Random r;

    public PongBall(Coordinate2D initialLocation, double radius, GameLevel gameLevelObject) {
        super(initialLocation);

        r = new Random();

        int dir = r.nextInt(0, 2) == 1 ? 1 : -1;
        int angle = r.nextInt(90-45, 90+45);

        setFill(Color.RED);
        setRadius(radius);
        setMotion(2,angle * dir);

        this.gameLevelObject = gameLevelObject;
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
}
