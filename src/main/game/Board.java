package main.game;

import main.game.bonuses.Fox;
import main.game.fields.*;

import java.awt.*;

import main.game.fields.Field;
import main.game.fields.OrangeField;
import main.game.fields.PurpleField;
import main.game.fields.YellowField;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Board implements Serializable {
    private static final long serialVersionUID = 1L;
    public List<Field> Board = new ArrayList<>();
    private static ArrayList<Dice> usedDices = new ArrayList<>();
    private ArrayList<Object> avaiableBonuses = new ArrayList<>();
    int additionalRoll = 0;
    int additionalAction = 0;
    int points;
    static YellowField yellowField = new YellowField();
    static OrangeField orangeField = new OrangeField();
    static PurpleField purpleField = new PurpleField();
    static GreenField greenField = new GreenField();
    static BlueField blueField = new BlueField();
    Fox fox = new Fox(getAllPoints());


    String id;
    public Board(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Checks for additionalAction. Increments additionalAction if found.
     */
    public void checkAdditionalAction(){
        if(yellowField.checkBonus().equals("AdditionalAction")){
            additionalAction++;
        }
        if(orangeField.checkBonus().equals("AdditionalAction")){
            additionalAction++;
        }
        if(purpleField.checkBonus().equals("AdditionalAction")){
            additionalAction++;
        }
        if(greenField.checkBonus().equals("AdditionalAction")){
            additionalAction++;
        }
        if(blueField.checkBonus().equals("AdditionalAction")){
            additionalAction++;
        }
    }

    /**
     * Gets the number of additionalAction.
     * @return number of additionalAction
     */
    public int getAdditionalAction() {
        return additionalAction;
    }

    /**
     * Checks for additional rolls.
     */
    public void checkAdditionalRoll(){
        if(yellowField.checkBonus().equals("AdditionalRoll")){
            additionalRoll++;
        }
        if(orangeField.checkBonus().equals("AdditionalRoll")){
            additionalRoll++;
        }
        if(purpleField.checkBonus().equals("AdditionalRoll")){
            additionalRoll++;
        }
        if(greenField.checkBonus().equals("AdditionalRoll")){
            additionalRoll++;
        }
        if(blueField.checkBonus().equals("AdditionalRoll")){
            additionalRoll++;
        }
    }

    /**
     * Gets number of additional roll
     * @return number of available
     */
    public int getAdditionalRoll(){
        return additionalRoll;
    }

    public void checkBonus(){

    }


    public int[] getAllPoints(){
        int[] points = new int[5];

        points[0] = yellowField.getPoints();
        points[1] = orangeField.getPoints();
        points[2] = purpleField.getPoints();
        points[3] = greenField.getPoints();
        points[4] = blueField.getPoints();

        return points;
    }

    /**
     * Updates points. Must be used at the end of the game.
     */
    public void updatePoints(){
        points += yellowField.getPoints() + orangeField.getPoints()
                + purpleField.getPoints() + greenField.getPoints() +
                blueField.getPoints();
    }

    /**
     * Adds value to the field of given color. Adding is possible to green, orange and purple field.
     * @param dice to add
     * @return true if added successfully, false otherwise.
     */
    public boolean addValue(Dice dice){
        String color = dice.getColor();
        int value = dice.getValue();
        switch (color){
            case "green" ->  {usedDices.add(dice);
                return greenField.addDiceValue(value);}
            case "orange" ->  {usedDices.add(dice);
                return orangeField.addDiceValue(value);}
            case "purple" -> {usedDices.add(dice);
                return purpleField.addDiceValue(value);}
        }
        return false;
    }

    /**
     * Adds value to the field of given color. Adding is possible to yellow and blue field.
     * @param dice to add.
     * @return true if added successfully, false otherwise.
     */
    public static boolean addValue(Dice dice, JButton jButton) throws CordsOutOfBoundaries {
        //extracting cords
        Rectangle rectangle = jButton.getBounds();
        int x = (int)rectangle.getX();
        int y = (int)rectangle.getY();

        String color = dice.getColor();
        int[] cords = null;
        if(color.equals("yellow"))
            cords = JButtonCordsConversionTables.jbuttonToCordsYellowField.get(new int[]{x,y});
        else if(color.equals("blue")){
            cords = JButtonCordsConversionTables.jbuttonToCordsBlueField.get(new int[]{x,y});
        }

        if(cords!=null) {
            int value = dice.getValue();
            switch (color) {
                case "yellow" -> {
                    usedDices.add(dice);
                    return yellowField.addDiceValue(value, cords);
                }
                case "blue" -> {
                    usedDices.add(dice);
                    return blueField.addDiceValue(value, cords);
                }
            }
        }else{
            throw new CordsOutOfBoundaries("Incorrect cords. Cannot be null");
        }
        return false;
    }

}