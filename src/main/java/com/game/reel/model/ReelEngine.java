package com.game.reel.model;

/**
 * Created by sanches on 3/5/14.
 */
public class ReelEngine {

    private float coinSize;
    private float credits;
    private float betAmount;
    private float winAmount;

    private int coins;
    private int lines;

    void setCoinSize(float coinSize) {
        this.coinSize = coinSize;
    }

    void setLines(int lines) {
        this.lines = lines;
    }

    void setCoins(int coins) {
        this.coins = coins;
    }

    float getDemoCredits() {
        return credits;
    }

    float getBetAmount() {
        return betAmount;
    }

    float getWinAmount() {
        return winAmount;
    }

    void spin() {

    }

    void betMax() {

    }
}
