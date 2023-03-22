package com.pong.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.pong.PongGame;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartButton extends TextEntity implements MouseEnterListener, MouseExitListener, MouseButtonPressedListener {

    private final PongGame pongGameObject;

    public StartButton(Coordinate2D initialLocation, PongGame pongGameObject) {
        super(initialLocation, "Play");

        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(Color.PURPLE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));

        this.pongGameObject = pongGameObject;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        pongGameObject.setActiveScene(1);
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.PINK);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.PURPLE);
        setCursor(Cursor.DEFAULT);
    }
}
