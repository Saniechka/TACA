package main.serverTest;

//file: Server.java
import main.game.Board;

import java.net.*;
import java.io.*;


public class ServerTest {
    final static int PORT = 1234;



    public static void main(String[] args) throws IOException {
        doCoolStuff();
    }

    public static void doCoolStuff() throws IOException {
        ServerSocket ss = new ServerSocket(PORT);
        while ( true )
            new ServerConnection( ss.accept() ).start( );
    }
}

class ServerConnection extends Thread {
    Socket client;
    ObjectInputStream in;
    ObjectOutputStream out;
    static BoardHolder boardHolder = new BoardHolder();
    ServerConnection ( Socket client ) throws IOException {
        this.client = client;
        this.in = new ObjectInputStream(client.getInputStream());
        this.out = new ObjectOutputStream( client.getOutputStream() );
        setPriority( NORM_PRIORITY - 1 );
    }
    int i = 0;
    public void run( ) {
        try {

            while ( true ) {
                //addBoardToBoardHandler(in.readObject());

                Object ob = in.readObject();
                System.out.println("1)");
                System.out.println(ob);
                if(ob instanceof Board) {

                    addBoardToBoardHandler(ob);
                    out.flush();
                    i++;
                    System.out.println("2)");
                }else if(ob instanceof String) {
                   // Object ob2 = in.readObject();
                    out.writeObject(getBoardFromBoardHandler(ob));
                    out.flush();
                    i--;
                    System.out.println("3)");
                }

            }
        } catch ( EOFException e3 ) { // Normal EOF
            try {
                client.close( );
            } catch ( IOException e ) { }
        } catch ( IOException e ) {
            System.out.println( "I/O error " + e ); // I/O error
        } catch ( ClassNotFoundException e2 ) {
            System.out.println( e2 ); // unknown type of request object
        }
    }


    private void addBoardToBoardHandler(Object request){
        if ( request instanceof Board ){
            boardHolder.removeBoard((Board)request);
            boardHolder.addBoard((Board)request);
        }
    }

    private Board getBoardFromBoardHandler(Object request){
        if(request instanceof String){
            String id = (String) request;
            return boardHolder.getBoard(id);
        } else return null;
    }

    private Object processRequest( Object request, String id ) {
        if ( request instanceof DateRequest )
            return new java.util.Date( );
        else if ( request instanceof WorkRequest )
            return ((WorkRequest)request).execute( );
        else if (request instanceof  Board)
            return new Board(id);
        else return null;
    }
}