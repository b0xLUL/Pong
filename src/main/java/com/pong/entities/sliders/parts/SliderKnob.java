package com.pong.entities.sliders.parts;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import javafx.scene.paint.Color;

public class SliderKnob extends DynamicCircleEntity {
    public SliderKnob(Coordinate2D initialLocation) {
        super(initialLocation);

        setRadius(15);
        setFill(Color.WHITE);
        setStrokeColor(Color.BLACK);
    }
}
