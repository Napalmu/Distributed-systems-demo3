package fi.utu.tech.assignment3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandler extends Thread {
    // TODO: Toteuta asiakaspalvelija tänne
        Socket s;
        public ClientHandler(Socket s) {
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

            try {
                OutputStream os = s.getOutputStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

// Waiting for the client to send data
            while (true) {

            }


        }
    }

