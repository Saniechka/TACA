package main.game.fields;

import main.game.bonuses.*;

import java.io.Serializable;
import java.util.ArrayList;

public class BlueField implements FieldMatrix, Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<ArrayList<Integer>> possibleDiceValues;
    private int points = 0;
    int[] pointsCounter = {1,2,4,7,11,16,22,29,37,46,56};
    int counter = 0;

    public BlueField(){fillPossibleDiceValues();};

    @Override
    public void updateSum() {
        int n;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                if(possibleDiceValues.get(i).get(j) == 0)
                    counter++;
            }}
        this.points = pointsCounter[counter+1];
    }


    //This counter ensure that the bonus won't be returned twice.
    int bonusCounter = 0;
    /**
     * Check if box has any bonus
     * @return
     */
    public Object checkBonus() {
        if (isColFilled(0) && bonusCounter == 0){bonusCounter++; return new AdditonalRoll();}
        if (isColFilled(1) && bonusCounter == 1){bonusCounter++; return new ExtraGreen(0);}
        if (isColFilled(2) && bonusCounter == 2){bonusCounter++; return new ExtraPurple(6);}
        if (isColFilled(3) && bonusCounter == 3){bonusCounter++; return new AdditonalAction();}
        if (isRowFilled(0) && bonusCounter == 4){bonusCounter++; return new ExtraOrange(5);}
        if (isRowFilled(1) && bonusCounter == 5){bonusCounter++; return new ExtraYellow(0);}
        if (isRowFilled(2) && bonusCounter == 6){bonusCounter++; return "Fox";}
        return null;
    }

    /**
     * Adds values to the blue field
     * @param value to add
     */
    @Override
    public boolean addDiceValue(int value, int[] cords) {
        try {
            if(!areCordsValid(cords)){
                return false;
            }
        } catch (CordsOutOfBoundaries ex){
            System.out.println(ex.getMessage());
        }
        if(possibleDiceValues.get(cords[0]).get(cords[1]) == value){
            possibleDiceValues.get(cords[0]).set(cords[1], value);
            return true;
        }
        return false;
    }


    public int getPoints() {
        return this.points;
    }

    @Override
    public String getColor() {
        return "Blue";
    }


    private void fillPossibleDiceValues(){
        this.possibleDiceValues = new ArrayList<>(){
            {
                add(new ArrayList<>(){
                    {add(0); add(2); add(3); add(4);}
                });
                add(new ArrayList<>(){
                    {add(5); add(6); add(7);add(8);}
                });
                add(new ArrayList<>(){
                    {add(9); add(10); add(11);add(12);}
                });
            }
        };
    }
    /**
     * Check if column i is filled
     * @param i
     */
    private boolean isColFilled(int i){
        return  (possibleDiceValues.get(0).get(i) + possibleDiceValues.get(1).get(i)
                + possibleDiceValues.get(2).get(i) == 0);
    }
    /**
     * Check if diagonal of the field is filled
     * @param i
     */
    private boolean isRowFilled(int i){
        return  (possibleDiceValues.get(i).get(0) + possibleDiceValues.get(i).get(1)
                + possibleDiceValues.get(i).get(2) + possibleDiceValues.get(i).get(3) == 0);
    }
    /**
     * Check if co-ordinates are valid
     * @param cords
     */
    private boolean areCordsValid(int[] cords) throws CordsOutOfBoundaries {
        return  0 <= cords[0] &&  cords[0] <= 2 && 0 <= cords[1]  && cords[1] <= 3;
    }
    public ArrayList<ArrayList<Integer>> getPossibleDiceValues() {
        return possibleDiceValues;
    }
}
