package fi.utu.tech.assignment2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        while (true) {
            Socket commSocket = serverSocket.accept();
            try (Socket socket = commSocket;
                InputStream is = socket.getInputStream()){
                    byte[] received = is.readAllBytes();
                    String receivedMessage = new String(received, "utf-8");
                    System.out.println(receivedMessage);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    }


