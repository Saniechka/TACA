package main.game.fields;

import main.game.bonuses.ExtraBlue;
import main.game.bonuses.ExtraPurple;
import main.game.bonuses.ExtraYellow;

import java.io.Serializable;
import java.util.ArrayList;

public class GreenField implements Field, Serializable {
    private static final long serialVersionUID = 1L;
    private final ArrayList<Integer> diceValues;
    private final ArrayList<String> bonuses = new ArrayList<>();
    int[] requiredValues = {1,2,3,4,5,1,2,3,4,5,6,0};
    int[] pointsCounter = {1,3,6,10,15,21,28,36,45,55,66};
    private int count = 0;
    private int points = 0;

    public GreenField(){
        this.diceValues = new ArrayList<>(11);
        int n = 10;
        while (n --> 0) diceValues.add(null);
    }

    /**
     *
     * @param value to add.
     */
    public void updateSum(int value){
        this.points += pointsCounter[count];
    }

    public int getPoints(){
        return points;}


    public ArrayList<Integer> getDiceValues (){
        return diceValues;}

    //This counter ensure that the bonus won't be returned twice.
    int bonusCounter = 0;
    /**
     * Check if box has bonus and adds it to Array.
     * @return
     */
    public Object checkBonus(){
        if (isSquareFilled(3)&& bonusCounter == 0){bonusCounter++; return "AdditonalAction";}
        if (isSquareFilled(5)&& bonusCounter == 1){bonusCounter++; return new ExtraBlue(0);}
        if (isSquareFilled(6)&& bonusCounter == 2){bonusCounter++; return "AdditonalAction";}
        if (isSquareFilled(8)&& bonusCounter == 3){bonusCounter++; return new ExtraPurple(6);}
        if (isSquareFilled(9)&& bonusCounter == 4){bonusCounter++; return "AdditionalRoll";}
        return null;
    }

    private boolean isSquareFilled(int i){
        return  (diceValues.get(i) == 0);
    }

    public void doStuff(int value){
        diceValues.add(count, value);
        this.count++;
        if(diceValues.size() > 11) diceValues.remove(diceValues.size()-1);
        checkBonus();
        updateSum(value);
    }
    /**
     * Adds values to the orange field
     * @param value to add
     */
    @Override
    public boolean addDiceValue(int value) throws IllegalArgumentException {
        if(value >= requiredValues[this.count]){
            doStuff(value);
            return true;
        }
        return false;
    }

    @Override
    public String getColor() {
        return "Green";
    }


}
