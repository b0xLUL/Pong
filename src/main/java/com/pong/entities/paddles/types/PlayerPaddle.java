package com.pong.entities.paddles.types;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.pong.entities.paddles.Paddle;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class PlayerPaddle extends Paddle implements KeyListener {

    public PlayerPaddle(Coordinate2D initialPosition) {
        super(initialPosition);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotion(this.paddleSpeed, 0d);
        } else if (pressedKeys.contains(KeyCode.UP)) {
            setMotion(this.paddleSpeed, 180d);
        } else {
            setSpeed(0);
        }
    }
}
