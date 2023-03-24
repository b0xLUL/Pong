package com.pong.shared.records;

public record Score() {
    private static int playerScore;
    private static int computerScore;

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
}
