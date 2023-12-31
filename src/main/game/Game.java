package main.game;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Game implements Serializable {
    // gra zaczyna się od rzucania kostek
    public static void startRound(){
        String [] colors ={"blue", "yellow","green","orange","purple", "white"};

        Dice[] dices = createDices(colors);
            Scanner sc = new Scanner(System.in);
            System.out.println("Wybierz 1 kostkę");
            System.out.println("Wpisz kolor małymi literami po angielsku ");
            String choice = sc.nextLine();
            checkColor(choice);
            ArrayList<Dice> all = sort(dices);
            ArrayList<Dice> tray = new ArrayList<>();
            int i = 0;
            while (all.get(i).equals(choice) == false) {
                if (all.get(i + 1).equals(choice) && all.get(i) == all.get(i + 1))
                    return;
                else {
                    tray.add(all.get(i));
                    all.remove(0);
                }
                i++;
            }

            if(all.size() == 0 )
                return;
            else{
                Dice[] dices1 = createDices(getColors(all));

                System.out.println("Wybierz 1 kostkę");
                System.out.println("Wpisz kolor małymi literami po angielsku ");
                String choice1 = sc.nextLine();
                checkColor(choice1);
                ArrayList<Dice> all1 = sort(dices1);

                int i1 = 0;
                while (all.get(i1).equals(choice) == false) {
                    if (all1.get(i1 + 1).equals(choice) && all1.get(i1) == all1.get(i1 + 1))
                        return;
                    else {
                        tray.add(all1.get(i1));
                        all1.remove(0);
                    }
                    i++;
                }


        if(all1.size() == 0 )
            return;
        else{
            Dice[] dices2 = createDices(getColors(all));

            System.out.println("Wybierz 1 kostkę");
            System.out.println("Wpisz kolor małymi literami po angielsku ");
            String choice2 = sc.nextLine();
            checkColor(choice2);
            ArrayList<Dice> all2 = sort(dices1);

            int i2 = 0;
            while (all2.get(i2).equals(choice) == false) {
                if (all2.get(i2 + 1).equals(choice) && all2.get(i2) == all2.get(i2 + 1))
                    return;
                else {
                    tray.add(all2.get(i2));
                    all2.remove(0);
                }
                i++;
            }
        }
            }
    }



    public static ArrayList<Dice> putDice(Dice [] dices, String colors){
        Scanner sc = new Scanner(System.in);
        System.out.println("Wybierz 1 kostkę");
        System.out.println("Wpisz kolor małymi literami po angielsku ");
        String choice = sc.nextLine();
        checkColor(choice);
        ArrayList<Dice> all =  sort(dices);
        ArrayList<Dice> tray = new ArrayList<>();
        int i =0;

        while(all.get(i).equals(choice)== false){
            if(all.get(i+1).equals(choice)  && all.get(i) ==all.get(i+1) )
                return all;
            else{
                tray.add(all.get(i));
                all.remove(0);
            }
            i++;
        }
        return all;
    }



    public static String[] getColors(ArrayList<Dice> ar){
        String [] str = new String[ar.size()];
        for (int i = 0; i <ar.size() ; i++) {
            str[i] = ar.get(i).getColor();
        }
         return  str;
    }



    public static Dice[] createDices(String[] colors){
        Dice [] dices = new Dice[colors.length];
        for (int i = 0; i < colors.length; i++) {
            Dice dice  = new Dice(colors[i]);
            dices[i]= dice;
        }
        return dices;
    }



public static ArrayList<Dice> sort(Dice [] arr){

    int n = arr.length;
    for (int i = 0; i < n - 1; i++)
        for (int j = 0; j < n - i - 1; j++)
            if (arr[j].getValue() > arr[j + 1].getValue()) {
                Dice temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
    Dice[] diceSortArray = new Dice[arr.length];
    ArrayList<Dice> dices = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
        dices.add(arr[i]);
    }
    return  dices;
    }


    public static  void checkColor(String color){
        if (!color.equals("blue") || !color.equals("yellow") || !color.equals("green") || !color.equals("red")
                || !color.equals("purple") || !color.equals("white")) throw  new IllegalArgumentException("Niepoprawny kolor");
    }

    //public static void addToTray()
public static void savetoFile(Board board){
try{
    FileOutputStream fileOut = new FileOutputStream("board.ser");
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(board);
    out.close();
    fileOut.close();
}catch(IOException i){
    i.printStackTrace();
}
}

public void readFromFile(String boardPath){
        Board board = null;
    try {
        FileInputStream fileIn = new FileInputStream(boardPath);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        board = (Board) in.readObject();
        in.close();
        fileIn.close();
    } catch (IOException i) {
        i.printStackTrace();
        return;
    } catch (ClassNotFoundException c) {
        c.printStackTrace();
        return;
    }
    }
}
