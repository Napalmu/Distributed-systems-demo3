package fi.utu.tech.assignment3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandler extends Thread {
        Socket s;
        public ClientHandler(Socket s) {
            this.s = s;
        }
        public void run() {
            try (Socket socket = this.s;
                 InputStream is = socket.getInputStream();
                 OutputStream os = socket.getOutputStream();) {
                byte[] received = is.readAllBytes();
                String receivedMessage = new String(received, "utf-8");
                System.out.println("Received: "+ receivedMessage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

