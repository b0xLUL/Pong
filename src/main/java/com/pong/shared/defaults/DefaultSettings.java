package com.pong.shared.defaults;

/**
 * The {@code DefaultSettings} class is a record that contains default settings
 * for the game.
 * @author Mels Ubbink
 */
public record DefaultSettings() {
    private static final double DefaultVolume = 100;

    @Override
    public String toString() {
        return DefaultVolume + " ";
    }
}
