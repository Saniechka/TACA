//package main.game.fields;
//
//import main.game.fields.PurpleField;
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//class PurpleFieldTest {
//
//
//    @Test
//    void addDiceValue() {
//        PurpleField purpleField = new PurpleField();
//
//        purpleField.addDiceValue(2);
//        purpleField.addDiceValue(5);
//        purpleField.addDiceValue(6);
//        purpleField.addDiceValue(2);
//        purpleField.addDiceValue(3);
//
//
//        ArrayList<Integer> expected = new ArrayList<>(11) {
//            {
//                int n = 6;
//                add(2);
//                add(5);
//                add(6);
//                add(2);
//                add(3);
//                while (n --> 0) add(null);
//            }
//        };
//        Assert.assertEquals(expected, purpleField.getDiceValues());
//
//    }
//
//    @Test
//    void addDiceValue2() {
//        PurpleField purpleField = new PurpleField();
//
//        purpleField.addDiceValue(2);
//        purpleField.addDiceValue(6);
//        purpleField.addDiceValue(5);
//
//
//        ArrayList<Integer> expected = new ArrayList<>(11) {
//            {
//                int n = 8;
//                add(2);
//                add(6);
//                add(5);
//                while (n --> 0) add(null);
//            }
//        };
//        Assert.assertEquals(expected, purpleField.getDiceValues());
//
//    }
//}