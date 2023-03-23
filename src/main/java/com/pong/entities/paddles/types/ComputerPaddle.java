package com.pong.entities.paddles.types;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;

public class ComputerPaddle extends DynamicRectangleEntity implements Collider {
    public ComputerPaddle(Coordinate2D initialPosition) {
        super(initialPosition, new Size(20, 100));
    }



    private int getClosestPongBallIndex() {
        return 0;
    }
}
