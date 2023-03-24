package com.pong;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.pong.scenes.GameLevel;
import com.pong.scenes.OptionsMenu;
import com.pong.scenes.PauseMenu;
import com.pong.scenes.TitleScene;
import com.pong.shared.records.Score;
import com.pong.shared.records.Settings;
import com.pong.shared.util.FileHandler;

import java.util.ArrayList;
import java.util.Arrays;

public class PongGame extends YaegerGame {
    public Settings SettingsRecord;
    public Score ScoreRecord;
    private static FileHandler settingFile;
    private static FileHandler scoreFile;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setSize(new Size(800, 600));
        setGameTitle("Pong");

        settingFile = new FileHandler("settings.txt");
        scoreFile = new FileHandler("score.txt");

        if (!settingFile.FileExists()) {
            SettingsRecord = new Settings();
            setupFiles(settingFile, SettingsRecord.getDefaultVolume());
        } else {
            readToRecord(SettingsRecord, settingFile);
        }

        if(!scoreFile.FileExists()) {
            ScoreRecord = new Score();
            setupFiles(scoreFile, ScoreRecord.getDefaultScores());
        } else {
            readToRecord(ScoreRecord, scoreFile);
        }
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameLevel());
        addScene(2, new OptionsMenu());
        addScene(3, new PauseMenu());
    }

    private void readToRecord(Record record, FileHandler recordFile) {
        System.out.println(recordFile.getFileName() + " already exists, writing existing settings to record..");
    }

    private void setupFiles(FileHandler setupFile, String defaultValues) {
        String[] splittedValues = defaultValues.split(" ");
        ArrayList<String> valueList = new ArrayList<String>(Arrays.asList(splittedValues));

        setupFile.CreateFile();
        setupFile.WriteFile(valueList);
    }
}
