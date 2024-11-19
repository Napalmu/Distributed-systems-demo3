package fi.utu.tech.assignment2;

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
            new Thread(new CommHandler(commSocket)).start();
        }
    }

    static class CommHandler implements Runnable {
        Socket s;
        public CommHandler(Socket s) {
            this.s = s;
        }
        public void run() {
            try (Socket socket = this.s;
            InputStream is = socket.getInputStream()){
                byte[] received = is.readAllBytes();
                String receivedMessage = new String(received, "utf-8");
                System.out.println(receivedMessage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            /*
            try {
                OutputStream os = s.getOutputStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

// Waiting for the client to send data
            while (true) {

            }*/


        }
    }

}
