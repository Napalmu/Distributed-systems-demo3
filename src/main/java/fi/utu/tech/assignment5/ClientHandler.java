package fi.utu.tech.assignment5;

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
                if (line == null){break;}
                System.out.println("Recieved: " + line);
                if(line.contains("LIGHT")) {
                    String[] command = line.split(";");

                    switch (command[1]) {
                        case "ON":
                            System.out.printf("Kytketään lamppu %s PÄÄLLE" + System.lineSeparator(), command[2]);
                            break;
                        case "OFF":
                            System.out.printf("Kytketään lamppu %s POIS" + System.lineSeparator(), command[2]);
                            break;
                        case "QUERY":
                            System.out.println("Kyselykomento vastaanotettu");
                            break;
                    }
                    writer.println("Komento suoritettu onnistuneesti");
                    writer.flush();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

