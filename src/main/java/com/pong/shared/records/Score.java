package com.pong.shared.records;

public record Score() {

    //Instance fields are NOT ALLOWED IN RECORDS, thats why these are static
    private static int playerScore;
    private static int computerScore;
    private static int highScore;

    private static final int defaultPlayerScore = 0;
    private static final int defaultComputerScore = 0;
    private static final int defaultHighScore = 0;

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        Score.playerScore = playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void setComputerScore(int computerScore) {
        Score.computerScore = computerScore;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        Score.highScore = highScore;
    }

    public int getDefaultPlayerScore() {
        return defaultPlayerScore;
    }

    public int getDefaultComputerScore() {
        return defaultComputerScore;
    }

    public int getDefaultHighScore() {
        return defaultHighScore;
    }

    public String getDefaultScores() {
        return defaultPlayerScore + " " + defaultComputerScore + " " + defaultHighScore;
    }
}
