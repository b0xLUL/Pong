package com.pong.shared.records;

/**
 * The {@code DefaultSettings} class is a record that contains default settings
 * for the game.
 * @author Mels Ubbink
 */
public record Settings() {
    private static final double DefaultVolume = 100;
    private static double volume;

    public String getDefaultVolume() {
        return DefaultVolume + " ";
    }

    public double getVolume() {
        return volume;
    }

    public String getVolumeInString() {
        return volume + "";
    }

    public void setVolume(double volume) {
        Settings.volume = volume;
    }
}
