package main.game.bonuses;

import main.game.Dice;

import java.util.Objects;

public class ExtraGreen {
    private Dice dice;

    public ExtraGreen(int value){
        this.dice = new Dice("Green", value);
    }
    public Dice getDice() {
        return dice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtraGreen extraGreen = (ExtraGreen) o;
        boolean areDiceValuesEqual = (extraGreen.getDice().getValue() == this.dice.getValue());
        return areDiceValuesEqual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dice);
    }


}
