package com.seaofgeese.game;

public class Combat {
    private int turnCounter;
    private boolean myTurn;

    protected Combat() {
        this.turnCounter = 1;
        this.myTurn = true;
    }

    //TODO decide if methods should be private

    private void loadCombat() {}

    private void updateTurn() {}

    private void attack(String weapon) {}

    private void enemyAttack() {}

    //TODO private void minigame() ???
}
