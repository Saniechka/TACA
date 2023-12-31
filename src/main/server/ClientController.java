package main.server;

import main.game.Board;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientController implements  Runnable {
    public static ArrayList<ClientController> clientControllers = new ArrayList<>();
    private Socket socket;
    private BufferedReader bufferedReader; // to receive data
    private BufferedWriter bufferedWriter; // to send data
    private String clientUsername;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private ArrayList<Board> boardArrayList;

    public ClientController(Socket socket){
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // bufferReader increases efficiency
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.clientUsername = bufferedReader.readLine();
            this.out = new ObjectOutputStream(socket.getOutputStream());
            this.in = new ObjectInputStream(socket.getInputStream());
            boardArrayList = new ArrayList<>();
            boardArrayList.add(new Board(clientUsername));
            clientControllers.add(this);

        } catch (IOException e){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    @Override
    public void run(){
        //what is run on seperate thread
        String messageFromClient;

        while(socket.isConnected()){
            try{
                Object object =  in.readObject(); // runs on seperate thread so that connection wont  close
                if(object instanceof Board) broadcastMessage((Board) object);
            } catch (IOException | ClassNotFoundException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    /**
     * Sends message to the server and thus to the other users

     */
    public void broadcastMessage(Board board){
        for(ClientController clientController : clientControllers){
            try{
                if(!clientController.clientUsername.equals(clientUsername)){
                    clientController.out.writeObject(board);
                    clientController.out.flush();
                }
            } catch(IOException e){
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    public void broadcastMessage(){
        for(ClientController clientController : clientControllers){
            try{
                if(!clientController.clientUsername.equals(clientUsername)){
                    for(Board board: boardArrayList){
                        clientController.out.writeObject(board);
                        clientController.out.flush();
                    }
                }
            } catch(IOException e){
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    /**
     * Removes client from game - disconects him
     */
    public void removeClientHandler(){
        clientControllers.remove(this);
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        removeClientHandler();;
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
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
