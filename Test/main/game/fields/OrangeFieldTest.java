//package main.game.fields;
//
//import main.game.fields.OrangeField;
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//class OrangeFieldTest {
//
//    @Test
//    void updateSum() {
//        OrangeField orangeField = new OrangeField();
//
//        orangeField.addDiceValue(2);
//        orangeField.addDiceValue(5);
//        orangeField.addDiceValue(6);
//        orangeField.addDiceValue(2);
//        orangeField.addDiceValue(1);
//
//
//        int expectedValue = 18;
//
//        Assert.assertEquals(expectedValue,orangeField.getPoints());
//    }
//
//    @Test
//    void checkBonus() {
//        OrangeField orangeField = new OrangeField();
//
//        orangeField.addDiceValue(2);
//        orangeField.addDiceValue(5);
//        orangeField.addDiceValue(6);
//        orangeField.addDiceValue(2);
//        orangeField.addDiceValue(1);
//
//
//        ArrayList<String> expectedBonusesList = new ArrayList<>(11) {
//            {
//               add("AdditionalRoll");
//               add("YellowX");
//            }
//        };
//
//
//        Assert.assertEquals(expectedBonusesList, orangeField.getBonuses());
//    }
//
//    @Test
//    void addDiceValue() {
//        OrangeField orangeField = new OrangeField();
//
//        orangeField.addDiceValue(2);
//        orangeField.addDiceValue(5);
//        orangeField.addDiceValue(6);
//        orangeField.addDiceValue(2);
//        orangeField.addDiceValue(1);
//
//
//        ArrayList<Integer> expected = new ArrayList<Integer>(11) {
//            {
//                int n = 6;
//                add(2);
//                add(5);
//                add(6);
//                add(2);
//                add(1);
//                while (n --> 0) add(null);
//            }
//        };
//        Assert.assertEquals(expected, orangeField.getDiceValues());
//
//    }
//}