package com.pong.entities.settings;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.pong.PongGame;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ExitSettings extends DynamicTextEntity implements MouseButtonPressedListener, MouseExitListener, MouseEnterListener {

    private final PongGame pongGameObject;

    public ExitSettings(Coordinate2D initialLocation, PongGame pongGameObject) {
        super(initialLocation, "Exit Settings");
        this.pongGameObject = pongGameObject;

        setFill(Color.WHITE);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFont(Font.font("Roboto", FontWeight.EXTRA_BOLD, 35));
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        pongGameObject.setActiveScene(0);
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
