package main.serverTest;

import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 3191;

    public static void main(String[] args) throws  Exception{
        new Server();
    }

    public Server() throws  Exception{
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is runing on port ");
        Socket socket = serverSocket.accept(); // keeps program runing until there's  connection

        ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream intStream = new ObjectInputStream(socket.getInputStream());

        Packet recvPacket = (Packet) intStream.readObject();
        System.out.println(recvPacket.message);

        if(recvPacket.message.equals("Hello!")) {
            Packet packet = new Packet("Hi! - ");
            outStream.writeObject(packet);
        }

        serverSocket.close();
    }
}
