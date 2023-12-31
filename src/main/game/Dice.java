package main.game;

import java.util.Random;

public class Dice  implements  Comparable<Dice> {

    private String color;
    private int value;
    Random rand = new Random();
    String [] colors ={"Blue, Yellow,Green,Red,Purple"}; // ALE  w main napisać żeby potem tworzył sobie objekt

    public Dice(String color) {
        this.color = color;
        this.value = rand.nextInt(6)+1;
    }

    public Dice(String color, int value) {
        this.color = color;
        this.value = value;
    }


    public void setValue(int value) {
        this.value = value;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public int getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int compareTo(Dice o) {
        return  this.value - o.value;
    }
}

