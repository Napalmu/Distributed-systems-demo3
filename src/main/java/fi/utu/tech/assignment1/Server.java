package fi.utu.tech.assignment1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        // TODO: Palvelinohjelma
        ServerSocket serverSocket = new ServerSocket(12345);
        while (true) {
            Socket commSocket = serverSocket.accept();
        }
    }
}

