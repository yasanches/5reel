package com.game.reel.controller;

/**
 * Controller of reels machine
 *
 * Created by sanches on 3/5/14.
 */
public interface ReelController {

    void setCoinSize(float coinSize);

    void setLines(int lines);

    void setCoins(int coins);

    void spin();

    void betMax();
}
