package com.pong.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ScoreText extends DynamicTextEntity {
    public ScoreText(Coordinate2D initialPosition, String initialText) {
        super(initialPosition);

        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(Color.BLACK);
        setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        setText(initialText);
    }
}
