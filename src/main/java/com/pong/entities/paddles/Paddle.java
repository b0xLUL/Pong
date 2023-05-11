package com.pong.entities.paddles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.pong.entities.balls.PongBall;

import java.util.List;

public abstract class Paddle extends DynamicRectangleEntity implements SceneBorderTouchingWatcher, Collided {

    Coordinate2D initialPosition;

    public double paddleSpeed = 8;
    public double computerSpeedMultiplier = .9;

    public Paddle(Coordinate2D initialPosition) {
        super(initialPosition, new Size(30, 100));
        this.initialPosition = initialPosition;
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
                pongBall.collidedWithPaddle(this);
            }
        }
    }

    public void resetPosition() {
        setAnchorLocation(initialPosition);
    }
}
