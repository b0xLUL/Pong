package com.pong.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.paint.Color;

public class PongBall extends DynamicCircleEntity implements SceneBorderCrossingWatcher {
    protected double radius;
    protected double direction;
    protected double speed;

    public PongBall(Coordinate2D initialLocation, double radius) {
        super(initialLocation);

        this.radius = radius;
        this.direction = 270d;
        this.speed = 2;

        setFill(Color.RED);
        setRadius(radius);
        setMotion(speed, direction);
    }

    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocationX(getSceneWidth());
    }
}
