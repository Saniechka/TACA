package main.game.fields;

import main.game.bonuses.ExtraBlue;
import main.game.bonuses.ExtraGreen;
import main.game.bonuses.ExtraOrange;
import main.game.bonuses.ExtraYellow;

import java.io.Serializable;
import java.util.ArrayList;

public class PurpleField implements Field, Serializable {
    private static final long serialVersionUID = 1L;
    private final ArrayList<Integer> diceValues;
    private final ArrayList<String> bonuses = new ArrayList<>();
    private int count = 0;
    private int points = 0;
    private int previous = 0;

    public PurpleField(){
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
        this.points += value;
    }

    //This counter ensure that the bonus won't be returned twice.
    int bonusCounter = 0;
    /**
     * Check if box has bonus and adds it to Array.
     * @return
     */
    @Override
    public Object checkBonus() {
        if(isSquareFilled(2)  && bonusCounter == 0){bonusCounter++; return "AdditonalRoll";}
        if (isSquareFilled(3) && bonusCounter == 1){bonusCounter++; return new ExtraBlue(0);}
        if (isSquareFilled(4) && bonusCounter == 2){bonusCounter++; return "AdditonalAction";}
        if (isSquareFilled(5) && bonusCounter == 3){bonusCounter++; return new ExtraYellow(0);}
        if (isSquareFilled(6) && bonusCounter == 4){bonusCounter++; return "Fox";}
        if (isSquareFilled(7) && bonusCounter == 5){bonusCounter++; return "AdditonalRoll";}
        if (isSquareFilled(8) && bonusCounter == 6){bonusCounter++; return new ExtraGreen(0);}
        if (isSquareFilled(9) && bonusCounter == 7){bonusCounter++; return new ExtraOrange(6);}
        if (isSquareFilled(10)&& bonusCounter == 8){bonusCounter++; return "AdditonalAction";}
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
    public boolean addDiceValue(int value) {
        if(previous == 0 || previous == 6){
            doStuff(value);
            this.previous = value;
            return true;
        } else if(previous < value) {
            doStuff(value);
            this.previous = value;
            return true;
        }
        return false;
    }


    @Override
    public String getColor() {
        return "Purple";
    }


    @Override
    public int getPoints() {
        return this.points;
    }

    public int getSize() {
        return 0;
    }

    public ArrayList<Integer> getDiceValues() {
        return diceValues;
    }
    public ArrayList<String> getBonuses() {
        return bonuses;
    }
}
