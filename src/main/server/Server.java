package main.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }

    public  void startServer(){
        try{
            while(!serverSocket.isClosed()){

               Socket socket = serverSocket.accept();// waits until clients connect
                System.out.println("Dołączył nowy gracz!");
                ClientController clientController = new ClientController(socket);

                Thread thread = new Thread(clientController);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes socket, reduces nested try catch block.
     */
    public void closeServerSocket(){
        try{
            if (serverSocket != null){
                serverSocket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234); // i wanna talk on socket 1234
        Server server = new Server(serverSocket);
        server.startServer();
    }
}
