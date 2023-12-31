package main.game.bonuses;

import main.game.Dice;

public class ExtraPurple {
    private Dice dice;

    public ExtraPurple(int value){

        this.dice = new Dice("Purple", value);
    }
    public Dice getDice() {
        return dice;
    }



}
