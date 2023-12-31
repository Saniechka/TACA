package main.serverTest;
//file: Client.java
import main.game.Board;

import java.net.*;
import java.io.*;

public class Client {
    static int PORT  = 1234;
    static String flat = "localhost";
    static int n = 2;
    static Socket server;
    static ObjectOutputStream out;
    static ObjectInputStream in;

    private Board board;

    public Client() throws IOException {

        this.server = new Socket(flat,  PORT);
        this.out = new ObjectOutputStream( server.getOutputStream( ) );
        this.in = new ObjectInputStream(server.getInputStream());
    }

    public static void saveBoard(Board boardToSave){
        try {

            out.writeObject( boardToSave );
            out.flush();
            System.out.println("4)");
            System.out.println( in.readObject( ) );
            System.out.println("1)");
//            out.writeObject(BoardToGet);
//            out.flush();
//            System.out.println( in.readObject( ) );

        } catch ( IOException e ) {
            System.out.println( "I/O error " + e ); // I/O error
        } catch ( ClassNotFoundException e2 ) {
            System.out.println( e2 ); // unknown type of response object
        }
    }


    public static void accessBoard(String boardToGet){
        try {

            out.writeObject( boardToGet );

            out.flush();
            System.out.println( ((Board)in.readObject( )).getId()  );

//            out.writeObject(BoardToGet);
//            out.flush();
//            System.out.println( in.readObject( ) );

             server.close( );
        } catch ( IOException e ) {
            System.out.println( "I/O error " + e ); // I/O error
        } catch ( ClassNotFoundException e2 ) {
            System.out.println( e2 ); // unknown type of response object
        }
    }




}