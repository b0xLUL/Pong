package com.pong.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.paint.Color;

public class PongBall extends DynamicCircleEntity implements SceneBorderCrossingWatcher, Collider {

    public PongBall(Coordinate2D initialLocation, double radius) {
        super(initialLocation);

        setFill(Color.RED);
        setRadius(radius);
        setMotion(2,-70);
    }

    public void notifyBoundaryCrossing(SceneBorder border) {
        if (border == SceneBorder.TOP || border == SceneBorder.BOTTOM) {
            bounceBall( border == SceneBorder.TOP ? 180 : -180 );
        }
    }

    public void bounceBall(double angleOfHit) {
        setDirection(angleOfHit - getDirection());
    }
}
