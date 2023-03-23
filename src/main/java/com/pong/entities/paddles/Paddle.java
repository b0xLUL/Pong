package com.pong.entities.paddles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.pong.entities.PongBall;

import java.util.List;

public class Paddle extends DynamicRectangleEntity implements SceneBorderTouchingWatcher, Collided {
    public Paddle(Coordinate2D initialPosition) {
        super(initialPosition, new Size(10, 100));
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);

        switch (border) {
            case TOP -> setAnchorLocationY(0);
            case BOTTOM -> setAnchorLocationY(getSceneHeight() - getHeight());
            default -> {}
        }
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider c : colliders) {
            if (c instanceof PongBall pongBall) {
                pongBall.inverseDirection();
                pongBall.setSpeed( pongBall.getSpeed() + (getSpeed()/2) );
            }
        }
    }
}
