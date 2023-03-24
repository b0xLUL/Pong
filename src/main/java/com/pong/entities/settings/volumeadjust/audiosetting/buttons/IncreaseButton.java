package com.pong.entities.settings.volumeadjust.audiosetting.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.pong.scenes.OptionsMenu;
import com.pong.shared.records.Settings;
import com.pong.shared.util.FileHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class IncreaseButton extends DynamicTextEntity implements MouseButtonPressedListener, MouseExitListener, MouseEnterListener {

    private final Settings settingsRecord;
    private final FileHandler settingsFile;
    private final OptionsMenu optionsMenuObject;

    public IncreaseButton(Coordinate2D initialLocation, Settings settingsRecord, FileHandler settingsFile, OptionsMenu optionsMenuObject) {
        super(initialLocation, "+");
        this.settingsRecord = settingsRecord;
        this.settingsFile = settingsFile;
        this.optionsMenuObject = optionsMenuObject;

        setFill(Color.WHITE);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFont(Font.font("Roboto", FontWeight.EXTRA_BOLD, 30));
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if(settingsRecord.getVolume() + 1 > 100d) return; //dit werkt. check het maar als je het niet geloofd.

        settingsRecord.setVolume(settingsRecord.getVolume() + 1);
        if(settingsFile.FileExists()) {
            settingsFile.WriteFile(settingsRecord.getVolume() + "");
        }
        optionsMenuObject.settingsUpdated();
    }

    @Override
    public void onMouseEntered() {
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
    }
}
