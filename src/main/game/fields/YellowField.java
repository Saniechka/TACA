package main.game.fields;

import main.game.bonuses.*;

import java.io.Serializable;
import java.util.ArrayList;

public class YellowField implements FieldMatrix, Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<ArrayList<Integer>> possibleDiceValues;
    private int points = 0;


    public YellowField() {
        fillPossibleDiceValues();
    }

    private void fillPossibleDiceValues(){
        this.possibleDiceValues = new ArrayList<>(){
            {
                add(new ArrayList<>(){
                    {add(3); add(6); add(5);add(0);}
                });
                add(new ArrayList<>(){
                    {add(2); add(1); add(0);add(5);}
                });
                add(new ArrayList<>(){
                    {add(1); add(0); add(2);add(4);}
                });
                add(new ArrayList<>(){
                    {add(0); add(3); add(4);add(6);}
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
                + possibleDiceValues.get(2).get(i) + possibleDiceValues.get(3).get(i) == 0);
    }
    /**
     * Check if row i is filled
     * @param i
     */
    private boolean isRowFilled(int i){
        return  (possibleDiceValues.get(i).get(0) + possibleDiceValues.get(i).get(1)
                + possibleDiceValues.get(i).get(2) + possibleDiceValues.get(i).get(3) == 0);
    }
    /**
     * Check if row i is filled
     * @param
     */
    private boolean isDiagonalFilled(){
        return ( (possibleDiceValues.get(0).get(0) + possibleDiceValues.get(1).get(1)
                + possibleDiceValues.get(2).get(2) + possibleDiceValues.get(3).get(3)) == 0);
    }


    private int[] ckeckColumn(){
        int[] cords = null;
        return cords;
    }

    @Override
    public void updateSum() {
        if(isColFilled(0)){
            points += 10;
        }else if(isColFilled(1)){
            points +=  14;
        }else if(isColFilled(2)){
            points +=  16;
        }else if(isColFilled(3)){
            points +=  20;
        }
    }


    //This counter ensures that the bonus won't be returned twice.
    int bonusCounter = 0;
    @Override
    public Object checkBonus() {
        if(isRowFilled(0) && bonusCounter == 0){bonusCounter++; return new ExtraBlue(0);}
        if(isRowFilled(1) && bonusCounter == 1){bonusCounter++; return new ExtraOrange(4);}
        if(isRowFilled(2) && bonusCounter == 2){bonusCounter++; return new ExtraGreen(0);}
        if(isRowFilled(3) && bonusCounter == 3){bonusCounter++; return "fox";}
        if(isDiagonalFilled() && bonusCounter == 4){bonusCounter++; return new AdditonalAction();}
        return null;
    }
    /**
     * Check if co-ordinates are valid
     * @param cords
     */
    private boolean areCordsValid(int[] cords) throws CordsOutOfBoundaries {
        return  0 <= cords[0] &&  cords[0] <= 3 && 0 <= cords[1]  && cords[1] <= 3;
    }

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
            possibleDiceValues.get(cords[0]).set(cords[1], 0);
            return true;
        }
        return false;
    }


    @Override
    public int getPoints() {
        return this.points;
    }

    @Override
    public String getColor() {
        return "Yellow";
    }

    public ArrayList<ArrayList<Integer>> getPossibleDiceValues() {
        return possibleDiceValues;
    }

}
