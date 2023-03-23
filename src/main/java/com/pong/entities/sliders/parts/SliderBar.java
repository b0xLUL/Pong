package com.pong.entities.sliders.parts;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class SliderBar extends RectangleEntity {
    public SliderBar(Coordinate2D initialLocation) {
        super(initialLocation);

        setWidth(50);
        setHeight(10);
        setFill(Color.WHITE);
    }
}
