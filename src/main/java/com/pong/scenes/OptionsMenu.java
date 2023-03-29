package com.pong.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.pong.PongGame;
import com.pong.entities.settings.ExitSettings;
import com.pong.entities.settings.volumeadjust.TopText;
import com.pong.entities.settings.volumeadjust.audiosetting.VolumeText;
import com.pong.entities.settings.volumeadjust.audiosetting.buttons.DecreaseButton;
import com.pong.entities.settings.volumeadjust.audiosetting.buttons.IncreaseButton;
import com.pong.entities.settings.volumeadjust.audiosetting.SettingText;
import com.pong.shared.records.Settings;
import com.pong.shared.util.FileHandler;
import javafx.scene.paint.Color;

public class OptionsMenu extends DynamicScene {

    private final PongGame pongGameObject;
    private final Settings settingsRecord;
    private final FileHandler settingsFile;

    private VolumeText currentVolumeText;

    public OptionsMenu(PongGame pongGameObject) {
        this.pongGameObject = pongGameObject;
        this.settingsRecord = pongGameObject.SettingsRecord;
        this.settingsFile = pongGameObject.settingFile;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntities() {

        TopText topText = new TopText(new Coordinate2D(getWidth() / 2, 45));
        SettingText audioSettingText = new SettingText(new Coordinate2D(getWidth() / 5, getHeight() / 4));
        currentVolumeText = new VolumeText(
                new Coordinate2D((getWidth() / 5) + 250, getHeight() / 4),
                settingsRecord.getVolumeInString()
        );
        DecreaseButton volumeDecreaseButton = new DecreaseButton(
                new Coordinate2D((getWidth() / 5) + 300, getHeight() / 4),
                settingsRecord,
                settingsFile,
                this
        );
        IncreaseButton volumeIncreaseButton = new IncreaseButton(
                new Coordinate2D((getWidth() / 5) + 320, getHeight() / 4),
                settingsRecord,
                settingsFile,
                this
        );
        ExitSettings exitSettingsButton = new ExitSettings(
                new Coordinate2D(getWidth() / 2, getHeight() - 45),
                pongGameObject
        );

        addEntity(topText);
        addEntity(audioSettingText);
        addEntity(currentVolumeText);
        addEntity(volumeDecreaseButton);
        addEntity(volumeIncreaseButton);
        addEntity(exitSettingsButton);
    }

    public void settingsUpdated() {
        currentVolumeText.setText(settingsRecord.getVolumeInString());
        System.out.println(settingsRecord.getVolume());
    }
}
