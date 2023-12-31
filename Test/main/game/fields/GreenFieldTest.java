//package main.game.fields;
//
//import main.game.fields.GreenField;
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import java.util.ArrayList;
//import org.junit.jupiter.api.Assertions;
//
//class GreenFieldTest {
//
//
//    @Test
//    void addDiceValue() {
//        GreenField greenField = new GreenField();
//
//        greenField.addDiceValue(2);
//        greenField.addDiceValue(5);
//        greenField.addDiceValue(6);
//        greenField.addDiceValue(5);
//        greenField.addDiceValue(5);
//
//        ArrayList<Integer> expected = new ArrayList<>(11) {
//            {
//                int n = 6;
//                add(2);
//                add(5);
//                add(6);
//                add(5);
//                add(5);
//                while (n-- > 0) add(null);
//            }
//        };
//        Assert.assertEquals(expected, greenField.getDiceValues());
//
//    }
//
//    @Test
//    void addDiceValue2() {
//       GreenField greenField = new GreenField();
//
//        greenField.addDiceValue(2);
//        greenField.addDiceValue(6);
//        greenField.addDiceValue(5);
//
//
//        ArrayList<Integer> expected = new ArrayList<>(11) {
//            {
//                int n = 8;
//                add(2);
//                add(6);
//                add(5);
//                while (n-- > 0) add(null);
//            }
//        };
//        Assert.assertEquals(expected, greenField.getDiceValues());
//
//    }
//}
