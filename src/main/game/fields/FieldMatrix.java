package main.game.fields;

public interface FieldMatrix {


    /**
     * Updates current sum of points.
     */
    void updateSum();

    /**
     * Checks possible bonus and returns it
     * @return String corresponded to bonus.
     */
    Object checkBonus();

    /**
     * Adds given values to box
     * @param value to add
     * @return True if value is added, false if value can't be added.
     */
    boolean addDiceValue(int value, int[] cords);

    int getPoints();

    String getColor();
}
