package com.pong.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.paint.Color;

public class PongBall extends DynamicCircleEntity implements Collider, UpdateExposer {

    public PongBall(Coordinate2D initialLocation, double radius) {
        super(initialLocation);

        setFill(Color.RED);
        setRadius(radius);
        setMotion(2,-70);
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
//            Player scored a point
        } else if (currentX < 0) {
//            Computer scored a point
        }
    }

    public void bounceBall(double angleOfHit) {
        setDirection(angleOfHit - getDirection());
    }
}
