package com.pong.entities.paddles.types;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.pong.entities.PongBall;
import com.pong.entities.paddles.Paddle;
import com.pong.scenes.GameLevel;

public class ComputerPaddle extends Paddle implements Collider, UpdateExposer {
    GameLevel gameLevelObject;

    public ComputerPaddle(Coordinate2D initialPosition, GameLevel gameLevelObject) {
        super(initialPosition);
        this.gameLevelObject = gameLevelObject;
    }

    @Override
    public void explicitUpdate(long timestamp) {
        moveToPongBall();
    }

    private void moveToPongBall() {
        PongBall closestPongBall = getClosestPongBall();

        double thisLocationY = this.getAnchorLocation().getY();
        double ballLocationY = closestPongBall.getAnchorLocation().getY();

        if (thisLocationY < ballLocationY) {
            setMotion(3, 0d);
        } else if (thisLocationY > ballLocationY) {
            setMotion(3, 180d);
        } else {
            setSpeed(0);
        }
    }

    private PongBall getClosestPongBall() {
        PongBall closest = null;
        double distanceToClosest = 0;

        for (PongBall pongBall : gameLevelObject.pongBalls) {
            if (closest == null) {
                closest = pongBall;
                distanceToClosest = pongBall.distanceTo(this);
            } else if ( pongBall.distanceTo(this) < distanceToClosest ) {
                closest = pongBall;
                distanceToClosest = pongBall.distanceTo(this);
            }
        }

        return closest;
    }
}
