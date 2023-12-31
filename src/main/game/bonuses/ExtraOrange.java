package main.game.bonuses;

import main.game.Dice;

import java.util.Objects;

public class ExtraOrange {
    private Dice dice;

    public ExtraOrange(int value){
        this.dice = new Dice("Orange", value);
    }

    public Dice getDice() {
        return dice;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtraOrange extraOrange = (ExtraOrange) o;
        boolean areDiceValuesEqual = extraOrange.getDice().getValue() == this.dice.getValue();
        return areDiceValuesEqual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dice);
    }
}
