package fi.utu.tech.assignment6;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {
    private final Socket s;
    private final Hub h;
    public ClientHandler(Socket s, Hub h) {
        this.s = s;
        this.h = h;
    }
    public void run() {
        try (Socket socket = this.s;
             InputStream is = socket.getInputStream();
             OutputStream os = socket.getOutputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(is));
             PrintWriter writer = new PrintWriter(os, true);
        ) {
            //System.out.printf("Client %s connected"+ System.lineSeparator(), socket.getInetAddress());

            while(true){
                String line = reader.readLine();
                if (line == null){break;}
                //System.out.println("Recieved: " + line);
                if(line.contains("LIGHT")) {
                    String[] command = line.split(";");

                    switch (command[1]) {
                        case "ON":
                            h.turnOnLight(Integer.parseInt(command[2]));
                            break;
                        case "OFF":
                            h.turnOffLight(Integer.parseInt(command[2]));
                            break;
                        case "QUERY":
                            StringBuilder s = new StringBuilder();
                            for (int i = 0; i<h.getLights().size(); i++){

                                String light = h.getLights().toArray()[i].toString();
                                char lastChar = light.charAt(light.length()-1);
                                String status = (lastChar == 'F') ? "OFF" : "ON";

                                s.append("ID").append(i).append(";").append(status).append(";");
                            }
                            writer.println(s);
                            writer.flush();
                            break;
                    }

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

