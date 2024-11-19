package fi.utu.tech.assignment4;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {
    private final Socket s;
    public ClientHandler(Socket s) {
        this.s = s;
    }
    public void run() {
        try (Socket socket = this.s;
             InputStream is = socket.getInputStream();
             OutputStream os = socket.getOutputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(is));
             PrintWriter writer = new PrintWriter(os, true);
             ) {
            System.out.printf("Client %s connected"+ System.lineSeparator(), socket.getInetAddress());

                while(true){
                    String line = reader.readLine();
                    System.out.println("Recieved: " + line);
                        if (line.equals("Hello")){
                            writer.println("Ack");
                            writer.flush();
                        }
                        if (line.equals("quit")){
                            writer.println("Closing connection...");
                            writer.flush();
                            socket.close();
                            break;
                        }


                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

