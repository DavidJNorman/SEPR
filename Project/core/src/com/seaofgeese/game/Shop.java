package com.seaofgeese.game;

public class Shop {

    // DIFFERENCE - prices stored as constants
    private static final int CANNON_UPGRADE_PRICE = 50;
    private static final int SAIL_UPGRADE_PRICE = 50;
    private static final int STRUCTURE_UPGRADE_PRICE = 75;
    private static final int CANNON_REPAIR_PRICE = 25;
    private static final int SAIL_REPAIR_PRICE = 25;
    private static final int STRUCTURE_REPAIR_PRICE = 40;
    private static final int AMMUNITION_PRICE = 10;

    // DIFFERENCE - "not enough gold" error abstracted to method

    private void notEnoughGoldError() {
        throw new IllegalStateException("Player does not have enough gold")
    }

    // DIFFERENCE - public instead of private
    // DIFFERENCE - player passed as parameter

    public void upgradeMaxCannon(Player player) {
        if (player.getGold() - CANNON_UPGRADE_PRICE >= 0) {
            player.setGold(player.getGold() - CANNON_UPGRADE_PRICE);
            player.setMaxCannonHealth(player.getMaxCannonHealth() + 10);
        } else {
            notEnoughGoldError();
        }
    }

    public void upgradeMaxSail(Player player) {
        if (player.getGold() - SAIL_UPGRADE_PRICE >= 0) {
            player.setGold(player.getGold() - SAIL_UPGRADE_PRICE);
            player.setMaxSailHealth(player.getMaxSailHealth() + 10);
        } else {
            notEnoughGoldError();
        }
    }

    public void upgradeMaxStructure(Player player) {
        if (player.getGold() - STRUCTURE_UPGRADE_PRICE >= 0) {
            player.setGold(player.getGold() - STRUCTURE_UPGRADE_PRICE);
            player.setMaxStructureHealth(player.getMaxStructureHealth() + 10);
        } else {
            notEnoughGoldError();
        }
    }

    public void repairCannon(Player player) {
        if (player.getGold() - CANNON_REPAIR_PRICE >= 0) {
            player.setGold(player.getGold() - CANNON_REPAIR_PRICE);
            player.setCannonHealth(player.getCannonHealth() + 30);
            if (player.getCannonHealth() > player.getMaxCannonHealth()) {
                player.setCannonHealth(player.getMaxCannonHealth());
            }
        } else {
            notEnoughGoldError();
        }
    }

    public void repairSail(Player player) {
        if (player.getGold() - SAIL_REPAIR_PRICE >= 0) {
            player.setGold(player.getGold() - SAIL_REPAIR_PRICE);
            player.setSailHealth(player.getSailHealth() + 30);
            if (player.getSailHealth() > player.getMaxSailHealth()) {
                player.setSailHealth(player.getMaxSailHealth());
            }
        } else {
            notEnoughGoldError();
        }
    }

    public void repairStructure(Player player) {
        if (player.getGold() - STRUCTURE_REPAIR_PRICE >= 0) {
            player.setGold(player.getGold() - STRUCTURE_REPAIR_PRICE);
            player.setStructureHealth(player.getStructureHealth() + 30);
            if (player.getStructureHealth() > player.getMaxStructureHealth()) {
                player.setStructureHealth(player.getMaxStructureHealth());
            }
        } else {
            notEnoughGoldError();
        }
    }

    public void buyAmmunition(Player player, String ammoType) {
        if (player.getGold() - AMMUNITION_PRICE >= 0) {
            player.setGold(player.getGold() - AMMUNITION_PRICE);
            player.addAmmunition(ammoType, 10);
        } else {
            notEnoughGoldError();
        }
    }

    // TODO add minigame???
}
