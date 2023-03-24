package com.pong.shared.records;

public record Score() {
    private static int playerScore;
    private static int computerScore;

    private static final int defaultPlayerScore = 0;
    private static final int defaultComputerScore = 0;

    public static int getPlayerScore() {
        return playerScore;
    }

    public static void setPlayerScore(int playerScore) {
        Score.playerScore = playerScore;
    }

    public static int getComputerScore() {
        return computerScore;
    }

    public static void setComputerScore(int computerScore) {
        Score.computerScore = computerScore;
    }

    public static int getDefaultPlayerScore() {
        return defaultPlayerScore;
    }

    public static int getDefaultComputerScore() {
        return defaultComputerScore;
    }

    public String getDefaultScores() {
        return defaultPlayerScore + " " + defaultComputerScore;
    }
}
