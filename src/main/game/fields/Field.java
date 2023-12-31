package main.game.fields;

public interface Field {

    /**
     * Updates current sum of points.
     * @param value to add.
     */
    void updateSum(int value);

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
    boolean addDiceValue(int value);

    String getColor();

    int getPoints();


}
