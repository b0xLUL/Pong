package com.pong.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.pong.PongGame;
import com.pong.entities.buttons.ExitButton;
import com.pong.entities.buttons.OptionsButton;
import com.pong.entities.buttons.StartButton;
import com.pong.shared.records.Settings;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {

    private final PongGame pongGameObject;
    private final Settings settingsRecord;

    public TitleScene(PongGame pongGameObject) {
        this.pongGameObject = pongGameObject;
        settingsRecord = pongGameObject.SettingsRecord;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
        setBackgroundAudio("audio/backgroundmusic.wav");

        var constrainedVolume = (settingsRecord.getVolume() / 100);
        setBackgroundAudioVolume(constrainedVolume);
    }

    @Override
    public void setupEntities() {
        TextEntity titleText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 2), "Pong");
        StartButton startButton = new StartButton(new Coordinate2D(getWidth() / 2, (getHeight() / 2) + 100), pongGameObject);
        OptionsButton optionsButton = new OptionsButton(new Coordinate2D(getWidth() / 2, (getHeight() /2 ) + 140), pongGameObject);
        ExitButton exitButton = new ExitButton(new Coordinate2D(getWidth() / 2, (getHeight() / 2) + 180));

        //settings voor de titletext
        titleText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        titleText.setFill(Color.BLUE);
        titleText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));

        addEntity(titleText);
        addEntity(startButton);
        addEntity(optionsButton);
        addEntity(exitButton);

    }
}
