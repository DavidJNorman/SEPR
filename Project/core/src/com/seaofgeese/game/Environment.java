package com.seaofgeese.game;

public class Environment {
    public enum Weather {
        CLEAR, RAIN, STORM
    } // NOTE THIS DOWN - CHANGED FROM A1

    private Weather weather;
    private int turnCounter;
    private int maxShips;
    private int ships;

    protected Environment() { //TODO check placeholder values
        this.weather = Weather.CLEAR;
        this.turnCounter = 1;
        this.maxShips = 10;
        this.ships = 0;
    }

    public void addShip() { //NEW - to be used when new Character is instantiated
        this.ships += 1;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    //TODO public void moveNPCs()
    //will be added once we know more about the movement system

    //TODO public void startCombat()

    //TODO public void startShop()

    public void updateEnvironment(){
        //TODO - moveNPCs, update turnCounter, possibly spawn ships, update weather according to chance
    }
}
