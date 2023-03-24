package com.pong.entities.volumeadjust.audiosetting.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.pong.shared.records.Settings;
import com.pong.shared.util.FileHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DecreaseButton extends DynamicTextEntity implements MouseButtonPressedListener, MouseExitListener, MouseEnterListener {

    private final Settings settingsRecord;
    private final FileHandler settingsFile;

    public DecreaseButton(Coordinate2D initialLocation, Settings settingsRecord, FileHandler settingsFile) {
        super(initialLocation, "-");
        this.settingsRecord = settingsRecord;
        this.settingsFile = settingsFile;

        setFill(Color.WHITE);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFont(Font.font("Roboto", FontWeight.EXTRA_BOLD, 30));
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if(settingsRecord.getVolume() - 1 < 0d) return; //dit werkt. check het maar als je het niet geloofd.

        settingsRecord.setVolume(settingsRecord.getVolume() - 1);
        if(settingsFile.FileExists()) {
            settingsFile.WriteFile(settingsRecord.getVolume() + "");
        }


        System.out.println(settingsRecord.getVolume());
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
