package fi.utu.tech.assignment3;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        // TODO: Palvelinohjelma
        ServerSocket serverSocket = new ServerSocket(12345);
        while (true) {
            // Accept blocks until a connection is made
            // This is not a "busy-wait"
            Socket commSocket = serverSocket.accept();
            new Thread(new ClientHandler(commSocket)).start();
        }
    }

}
