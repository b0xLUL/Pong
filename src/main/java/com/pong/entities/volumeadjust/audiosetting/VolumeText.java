package com.pong.entities.volumeadjust.audiosetting;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VolumeText extends DynamicTextEntity {
    public VolumeText(Coordinate2D initialPosition, String text) {
        super(initialPosition, text);
        setFill(Color.WHITE);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFont(Font.font("Roboto", FontWeight.NORMAL, 25));
    }
}
