package com.pong;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.pong.scenes.GameLevel;
import com.pong.scenes.OptionsMenu;
import com.pong.scenes.PauseMenu;
import com.pong.scenes.TitleScene;
import com.pong.shared.defaults.DefaultSettings;
import com.pong.shared.util.FileHandler;

import java.util.ArrayList;
import java.util.Arrays;

public class PongGame extends YaegerGame {

    public DefaultSettings Settings;
    private static FileHandler settingFile;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setSize(new Size(800, 600));
        setGameTitle("Pong");

        settingFile = new FileHandler("settings.txt");

        if(!settingFile.FileExists()) {
            Settings = new DefaultSettings();
            setupFiles(settingFile, Settings.toString());
        }
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameLevel());
        addScene(2, new OptionsMenu());
        addScene(3, new PauseMenu());
    }

    private void setupFiles(FileHandler setupFile, String defaultValues) {
        String[] splittedValues = defaultValues.split(" ");
        ArrayList<String> valueList = new ArrayList<String>(Arrays.asList(splittedValues));

        setupFile.CreateFile();
        setupFile.WriteFile(valueList);
    }
}
