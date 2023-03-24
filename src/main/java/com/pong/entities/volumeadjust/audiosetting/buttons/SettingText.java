package com.pong.entities.volumeadjust.audiosetting.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SettingText extends TextEntity {
    public SettingText(Coordinate2D initialLocation) {
        super(initialLocation, "Audio Volume");
        setFill(Color.WHITE);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFont(Font.font("Roboto", FontWeight.NORMAL, 25));
    }
}
