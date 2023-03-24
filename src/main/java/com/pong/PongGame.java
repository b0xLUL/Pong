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
    public FileHandler settingFile;
    public FileHandler scoreFile;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setSize(new Size(800, 600));
        setGameTitle("Pong");

        settingFile = new FileHandler("settings.txt");
        scoreFile = new FileHandler("score.txt");
        SettingsRecord = new Settings();
        ScoreRecord = new Score();

        if (!settingFile.FileExists()) {
            setupFiles(settingFile, SettingsRecord.getDefaultVolume());
        } else {
            readToSettingsRecord(SettingsRecord, settingFile);
        }

        if(!scoreFile.FileExists()) {
            setupFiles(scoreFile, ScoreRecord.getDefaultScores());
        } else {
            readToScoreRecord(ScoreRecord, scoreFile);
        }
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameLevel(this, scoreFile));
        addScene(2, new OptionsMenu(this, settingFile));
        addScene(3, new PauseMenu());
    }

    private void readToSettingsRecord(Settings record, FileHandler recordFile) {
        System.out.println(recordFile.getFileName() + " already exists, writing existing settings to record..");
        ArrayList<String> readOutLines = recordFile.ReadFile();

        for(String dataInString : readOutLines) {
            double dataInDouble = Double.parseDouble(dataInString);
            record.setVolume(dataInDouble);
        }
    }

    private void readToScoreRecord(Score record, FileHandler recordFile) {
        System.out.println(recordFile.getFileName() + " already exists, writing existing settings to record..");
        ArrayList<String> readOutLines = recordFile.ReadFile();

        //0 = Player
        //1 = computer
        //2 = player-highscore
        int[] dataInInt = new int[3];

        int i = 0;
        for(String dataInString : readOutLines) {
            dataInInt[i] = Integer.parseInt(dataInString);
            i++;
        }

        record.setPlayerScore(dataInInt[0]);
        record.setComputerScore(dataInInt[1]);
        record.setHighScore(dataInInt[2]);
    }


    private void setupFiles(FileHandler setupFile, String defaultValues) {
        String[] splittedValues = defaultValues.split(" ");
        ArrayList<String> valueList = new ArrayList<>(Arrays.asList(splittedValues));

        setupFile.CreateFile();
        setupFile.WriteFile(valueList);
    }
}
