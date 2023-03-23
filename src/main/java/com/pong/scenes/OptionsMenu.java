package com.pong.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class OptionsMenu extends DynamicScene {
    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntities() {
        var topText = new TextEntity(new Coordinate2D(getWidth() / 2, 45), "Options");
        var audioSettingText = new TextEntity(new Coordinate2D(getWidth() / 4.8, getHeight() / 4), "Audio");

        topText.setFill(Color.WHITE);
        topText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        topText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 70));

        audioSettingText.setFill(Color.WHITE);
        audioSettingText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        audioSettingText.setFont(Font.font("Roboto", FontWeight.NORMAL, 30));

        addEntity(topText);
        addEntity(audioSettingText);
    }
}
