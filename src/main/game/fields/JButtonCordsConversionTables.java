package main.game.fields;

import java.util.HashMap;

public class JButtonCordsConversionTables {
    public final static HashMap<int[], int[]> jbuttonToCordsYellowField = new HashMap<>(){
        {
            put(new int[]{30, 286},new int[]{0,0});
            put(new int[]{30, 332},new int[]{1,0});
            put(new int[]{30, 378},new int[]{2,0});
            put(new int[]{78, 286},new int[]{0,1});
            put(new int[]{78, 332},new int[]{1,1});
            put(new int[]{78, 424},new int[]{3,1});
            put(new int[]{127, 286},new int[]{0,2});
            put(new int[]{127, 378},new int[]{2,2});
            put(new int[]{127, 424},new int[]{3,2});
            put(new int[]{175, 332},new int[]{1,3});
            put(new int[]{175, 378},new int[]{2,3});
            put(new int[]{175, 424},new int[]{3,3});

        }
    };


    public final static HashMap<int[], int[]> jbuttonToCordsBlueField = new HashMap<>(){
        {
            put(new int[]{302, 383}, new int[]{1,0});
            put(new int[]{302, 430}, new int[]{2,0});
            put(new int[]{351, 338}, new int[]{0,1});
            put(new int[]{351, 384}, new int[]{1,1});
            put(new int[]{351, 430}, new int[]{2,1});
            put(new int[]{399, 338}, new int[]{0,2});
            put(new int[]{399, 384}, new int[]{1,2});
            put(new int[]{399, 430}, new int[]{2,2});
            put(new int[]{448, 338}, new int[]{0,3});
            put(new int[]{448, 384}, new int[]{1,3});
            put(new int[]{448, 430}, new int[]{2,3});
        }
    };
}
