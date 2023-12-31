package main.server;

import main.game.Board;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Player {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private String username;

    public Player(Socket socket, String username) {
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // bufferReader increases efficiency
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new ObjectOutputStream(socket.getOutputStream());
            this.in = new ObjectInputStream(socket.getInputStream());
            this.username = username;
        } catch (IOException e) {
            closeEverything(socket, bufferedWriter, bufferedReader, out, in);
        }
    }

    public void sendBoard(Board board) {
        try{
            out.writeObject(board);
            out.flush();

        }catch (IOException e){
            closeEverything(socket, bufferedWriter,bufferedReader, out, in);
        }
    }

    /**
     * Listen for the messages. When message is writen by others, it prints it in console.
     */
    public void listenForMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Object ob;

                while (socket.isConnected()) {
                    try {
                        ob = in.readObject();
                        if(ob instanceof Board)
                             System.out.println(((Board) ob).getId());
                    } catch (IOException | ClassNotFoundException e) {
                        closeEverything(socket, bufferedWriter, bufferedReader, out, in);
                    }
                }
            }
        }).start();
    }

    public void closeEverything(Socket socket, BufferedWriter bufferedWriter, BufferedReader bufferedReader, ObjectOutputStream out, ObjectInputStream in){
        try {
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(bufferedWriter != null){
                bufferedWriter.close();
            }
            if(socket != null){
                socket.close();
            }
            if(out != null){
                out.close();
            }
            if(in != null){
                in.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz swój nick dla gry: ");
        String username = scanner.nextLine();
        Socket socket = new Socket("localhost", 1234);
        Player player = new Player(socket, username);
        player.listenForMessage();
        player.sendBoard(new Board(username + " adda"));
    }
}
