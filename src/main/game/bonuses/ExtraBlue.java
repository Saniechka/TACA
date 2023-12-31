package main.game.bonuses;

import main.game.Dice;

import java.util.Objects;

public class ExtraBlue {

    public Dice getDice() {
        return dice;
    }

    private Dice dice;

    public ExtraBlue(int value){
       this.dice = new Dice("Blue", value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtraBlue extraBlue = (ExtraBlue) o;
        boolean areDiceValuesEqual = (extraBlue.getDice().getValue() == this.dice.getValue());
        return areDiceValuesEqual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dice);
    }
}
