//package main.game.fields;
//
//import main.game.bonuses.ExtraBlue;
//import org.junit.Assert;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class YellowFieldTest {
//
//    @Test
//    void isSumUpdated() {
//        YellowField yellowField = new YellowField();
//
//        yellowField.addDiceValue(3, new int[]{0,0});
//        yellowField.addDiceValue(2, new int[]{1,0});
//        yellowField.addDiceValue(1, new int[]{2,0});
//        yellowField.updateSum();
//        assertEquals(10, yellowField.getPoints());
//
//    }
//
//    @Test
//    void isBonusGiven() {
//        YellowField yellowField = new YellowField();
//
//        yellowField.addDiceValue(3, new int[]{0,0});
//        yellowField.addDiceValue(6, new int[]{0,1});
//        yellowField.addDiceValue(5, new int[]{0,2});
//
//        assertTrue(yellowField.checkBonus().equals(new ExtraBlue(0)));
//    }
//
//    @Test
//    void addDiceValue() {
//        YellowField yellowField = new YellowField();
//
//        yellowField.addDiceValue(3, new int[]{0,0});
//        yellowField.addDiceValue(2, new int[]{1,0});
//        yellowField.addDiceValue(1, new int[]{2,0});
//
//        ArrayList<ArrayList<Integer>> expected = new ArrayList<>(){
//            {
//                add(new ArrayList<>(){
//                    {add(0); add(6); add(5);add(0);}
//                });
//                add(new ArrayList<>(){
//                    {add(0); add(1); add(0);add(5);}
//                });
//                add(new ArrayList<>(){
//                    {add(0); add(0); add(2);add(4);}
//                });
//                add(new ArrayList<>(){
//                    {add(0); add(3); add(4);add(6);}
//                });
//            }
//        };
//
//        Assert.assertEquals(expected, yellowField.getPossibleDiceValues());
//
//    }
//}