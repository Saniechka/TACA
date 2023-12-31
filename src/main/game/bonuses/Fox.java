package main.game.bonuses;

import main.game.Board;

import java.io.Serializable;

public class Fox implements Serializable {
    private static final long serialVersionUID = 1L;
    Board board;
    int[] listOfPoints;

    public Fox(int[] listOfPoints){
        this.listOfPoints = listOfPoints;}

    /**
     * Searches through array of points and returns the smallest number.
     * @return smallest number in the array.
     */
    public int takeSmallest(){
        int points = 0;

        for (int x:
             listOfPoints) {
            if(points==0){
                points = x;
            }else if(points > x){
                points = x;
            }
        }
        return points;
    }

}
