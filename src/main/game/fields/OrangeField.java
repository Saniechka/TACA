package main.game.fields;

import main.game.bonuses.ExtraBlue;
import main.game.bonuses.ExtraPurple;
import main.game.bonuses.ExtraYellow;

import java.io.Serializable;
import java.util.ArrayList;

public class OrangeField implements Field, Serializable {
    private static final long serialVersionUID = 1L;
    private final ArrayList<Integer> diceValues;
    private final ArrayList<String> bonuses = new ArrayList<>();
    private int count = 0;
    private int points = 0;

    public OrangeField(){
        this.diceValues = new ArrayList<>(11);
        int n = 10;
        while(n  -- > 0) diceValues.add(null);
    }

    /**
     *
     * @param value to add.
     */
    @Override
    public void updateSum(int value) {
        if(count == 4 || count == 7 ||  count == 9){
            this.points += 2*value;
        }else if(count == 11){
            this.points += 3*value;
        }else{
            this.points += value;
        }
    }


    public int getPoints() {
        return points;
    }

    //This counter ensure that the bonus won't be returned twice.
    int bonusCounter = 0;
    /**
     * Check if box has any bonus
     * @return
     */
    @Override
    public Object checkBonus() {
        if(isSquareFilled(2)  && bonusCounter == 0){bonusCounter++; return "AdditonalRoll";}
        if (isSquareFilled(4) && bonusCounter == 1){bonusCounter++; return new ExtraYellow(0);}
        if (isSquareFilled(5) && bonusCounter == 2){bonusCounter++; return "AdditonalAction";}
        if (isSquareFilled(7) && bonusCounter == 3){bonusCounter++; return "Fox";}
        if (isSquareFilled(9) && bonusCounter == 4){bonusCounter++; return new ExtraPurple(6);}
        return null;
    }

    private boolean isSquareFilled(int i){
        return  (diceValues.get(i) == 0);
    }

    /**
     * Adds values to the orange field
     * @param value to add
     */
    @Override
    public boolean addDiceValue(int value) {
        diceValues.add(count,value);
        if(diceValues.size() > 11) diceValues.remove(diceValues.size()-1);
        this.count++;
        checkBonus();
        updateSum(value);
        return true;
    }

    @Override
    public String getColor() {
        return "Orange";
    }


    public int getSize() {
        return diceValues.size();
    }

    public ArrayList<Integer> getDiceValues() {
        return diceValues;
    }

    public ArrayList<String> getBonuses() {
        return bonuses;
    }

}
