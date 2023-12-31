package main.game;


import java.io.IOException;
import java.util.Scanner;

public class Play {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Wpisz ilosć członków");
        int k = sc.nextInt();
        if(k>4 || k<2) throw  new IllegalArgumentException("Niepoprawna ilość członków gry");

        switch (k){
            case 2:
                for (int i = 0; i < 6; i++) {

                }
                break;

            case 3:
                for (int i = 0; i < 5 ; i++) {

                }
                break;

            case 4:
                for (int i = 0; i < 4 ; i++) {

                }
                break;
        }

        System.out.println( "koniec gry");
        System.out.println("wyniki");

    }

}
