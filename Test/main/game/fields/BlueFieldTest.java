//package main.game.fields;
//
//import main.game.bonuses.ExtraOrange;
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class BlueFieldTest {
//
//    @Test
//    void updateSum() {
//        BlueField blueField = new BlueField();
//
//        blueField.addDiceValue(2,new int[]{0,1});
//        blueField.addDiceValue(3, new int[]{0,2});
//        blueField.addDiceValue(4, new int[]{0,3});
//        blueField.updateSum();
//        assertEquals(4,blueField.getPoints());
//    }
//
//    @Test
//    void checkBonus() {
//        BlueField blueField = new BlueField();
//
//        blueField.addDiceValue(2, new int[]{0,1});
//        blueField.addDiceValue(3, new int[]{0,2});
//        blueField.addDiceValue(4, new int[]{0,3});
//
//        assertTrue(blueField.checkBonus().equals(new ExtraOrange(5)));
//    }
//
//
//    @Test
//    void addDiceValue() {
//        BlueField blueField = new BlueField();
//
//        blueField.addDiceValue(5, new int[]{1,0});
//        blueField.addDiceValue(6, new int[]{1,1});
//        blueField.addDiceValue(7, new int[]{1,2});
//        blueField.addDiceValue(8, new int[]{1,3});
//
//        ArrayList<ArrayList<Integer>> expected = new ArrayList<>(){
//            {
//                add(new ArrayList<>(){
//                    {add(0); add(2); add(3);add(4);}
//                });
//                add(new ArrayList<>(){
//                    {add(5); add(6); add(7);add(8);}
//                });
//                add(new ArrayList<>(){
//                    {add(9); add(10); add(11);add(12);}
//                });
//            }
//        };
//
//        Assert.assertEquals(expected, blueField.getPossibleDiceValues());
//
//    }
//}