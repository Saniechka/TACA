package main.serverTest;


import main.game.Board;

import java.io.IOException;

public class Tester {
    static Client c1;
//    static Client c2;
//    static Client c3;
//    static Client c4;

//    public Tester(Board b1, Board b2){
//        this.c1 = new Client(b1);
//        this.c2 = new Client(b2);
//    }


    public static void main(String[] args) throws IOException {
        o();
    }

    public static void o() throws IOException {
//        ServerTest serverTest = new ServerTest();
//
//        serverTest.doCoolStuff();

        //c1              c2
        c1.saveBoard(new Board("XD"));
        c1.accessBoard("XD");
        c1.saveBoard( new Board("XDD"));

//
//        c1.saveBoard(new Board("XD"));
//        c2.saveBoard();

        c1.accessBoard("XDD");
        c1.accessBoard("XD");
    }
}
