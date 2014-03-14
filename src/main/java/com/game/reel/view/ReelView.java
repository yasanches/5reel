package com.game.reel.view;

/**
 * View of reel machine
 *
 * Created by sanches on 3/5/14.
 */
public interface ReelView {

    void showLines(int lines);

    void showCoins(int coins);

    void showDemoCredits(float credits);

    void showBetAmount(float betAmount);

    void showWinAmount(float winAmount);

    void animateReelMachine();

}
