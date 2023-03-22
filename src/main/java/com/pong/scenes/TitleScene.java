package com.pong.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.pong.entities.StartButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {
    public TitleScene() {

    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        var mainText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Pong"
        );

        mainText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        mainText.setFill(Color.DARKBLUE);
        mainText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));

        var startButton = new StartButton(
                new Coordinate2D(getWidth() / 2, (getHeight() / 2) + 100)
        );

        addEntity(mainText);
        addEntity(startButton);
    }
}
