package main.game.bonuses;

import main.game.Dice;

import java.util.Objects;

public class ExtraYellow {
    private Dice dice;

    public ExtraYellow(int value){
        this.dice = new Dice("Purple", value);
    }
    public Dice getDice() {
        return dice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtraYellow extraYellow = (ExtraYellow) o;
        boolean areDiceValuesEqual = (extraYellow.getDice().getValue() == this.dice.getValue());
        return areDiceValuesEqual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dice);
    }

}
