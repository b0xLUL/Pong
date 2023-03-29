package com.pong.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.pong.PongGame;
import com.pong.entities.PongBall;
import com.pong.entities.ScoreText;
import com.pong.entities.paddles.types.ComputerPaddle;
import com.pong.entities.paddles.types.PlayerPaddle;
import com.pong.shared.records.Score;
import com.pong.shared.records.Settings;
import com.pong.shared.util.FileHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.Set;

public class GameLevel extends DynamicScene implements KeyListener {
    public ArrayList<PongBall> pongBalls = new ArrayList<>();
    public PongGame pongGameObject;
    private final Score scoreRecord;
    private final Settings settingsRecord;
    private final FileHandler scoreFile;

    public ScoreText playerScoreText;
    public ScoreText computerScoreText;
    public ScoreText highScoreText;

    public PlayerPaddle playerPaddle;
    public ComputerPaddle computerPaddle;

    public GameLevel(PongGame pongGameObject) {
        this.pongGameObject = pongGameObject;
        scoreRecord = pongGameObject.ScoreRecord;

        this.scoreFile = pongGameObject.scoreFile;
        settingsRecord = pongGameObject.SettingsRecord;
    }

    @Override
    public void setupScene() {
        var upperLimit = 1.0d;
        var lowerLimit = 0.0d;
        var oldRange = (100.0 - 0.0);
        var newRange = (upperLimit - lowerLimit);
        var constrainedVolume = (((settingsRecord.getVolume() - 0.0) * newRange) / oldRange) + lowerLimit;

        setBackgroundAudio("audio/backgroundmusic.wav");
        setBackgroundAudioVolume(constrainedVolume);
    }

    @Override
    public void setupEntities() {
        playerPaddle = new PlayerPaddle(new Coordinate2D(5, 100));
        computerPaddle = new ComputerPaddle(new Coordinate2D(getWidth() - 25, 100), this);

        double hWidth = getWidth()/2;
        playerScoreText = new ScoreText(new Coordinate2D(hWidth - 50, 50), "" + 0);
        computerScoreText = new ScoreText(new Coordinate2D(hWidth + 50, 50), "" + 0);
        highScoreText = new ScoreText(new Coordinate2D(hWidth, getHeight()-50), "Highscore: " + scoreRecord.getHighScore());

        highScoreText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 30));

        addEntity(playerScoreText);
        addEntity(computerScoreText);
        addEntity(highScoreText);
        addEntity(computerPaddle);
        addEntity(playerPaddle);

        resetEntities();
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.ESCAPE)) {
            updateHighScore();
            pongGameObject.setActiveScene(0);
        }
    }

    public void createPongBall() {

        pongBalls.add(new PongBall(
           new Coordinate2D(getWidth()/2, getHeight()/2),
           10,
           this
        ));

        addEntity( pongBalls.get(pongBalls.size()-1) );
    }

    public void resetEntities() {
        // Reset pong balls
        for (PongBall pongBall : pongBalls) {
            pongBall.remove();
        }

        pongBalls.clear();

        for (int i = 0; i < 1; i++) {
            createPongBall();
        }

        // Reset paddles
        playerPaddle.resetPosition();
        computerPaddle.resetPosition();
    }

    public void playerScored() {
        resetEntities();
        scoreRecord.setPlayerScore(scoreRecord.getPlayerScore()+1);
        playerScoreText.setText("" + scoreRecord.getPlayerScore());
        updateHighScore();
    }

    public void computerScored() {
        resetEntities();
        scoreRecord.setComputerScore(scoreRecord.getComputerScore()+1);
        computerScoreText.setText("" + scoreRecord.getComputerScore());
    }

    public void updateHighScore() {
        if (scoreRecord.getPlayerScore() > scoreRecord.getHighScore()) {
            scoreRecord.setHighScore(scoreRecord.getPlayerScore());
            highScoreText.setText("Highscore: " + scoreRecord.getHighScore());

            ArrayList<String> scores = new ArrayList<>();
            scores.add("0");
            scores.add("0");
            scores.add(scoreRecord.getPlayerScore() + "");

            if(scoreFile.FileExists()) {
                scoreFile.WriteFile(scores);
            }
        }
    }
}
