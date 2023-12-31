package main.serverTest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client1 {

    public static void main(String[] args) throws Exception {
        new Client1();
    }

    public Client1() throws Exception{
        Socket socket = new Socket("127.0.0.1", Server.PORT);

        ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());


        Packet packet = new Packet("Hello!");
        outStream.writeObject(packet);

        Packet recvPacket = (Packet)inStream.readObject();
        System.out.println(recvPacket.message);


        outStream.close();
        socket.close();

    }
}

