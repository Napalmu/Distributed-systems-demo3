package fi.utu.tech.assignment4;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws IOException {
        try(Socket s = new Socket("127.0.0.1", 12345);
            var os = s.getOutputStream();
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)));
            BufferedReader in =  new BufferedReader(new InputStreamReader(s.getInputStream()));){

            System.out.println("Lähetetään Hello");
            out.println("Hello");
            out.flush();

            String response = in.readLine();
            System.out.println("Server responded: " + response);

            System.out.println("Varmistus saatu");
            System.out.println("Lähetetään quit");
            out.println("quit");
            out.flush();

            response = in.readLine();
            System.out.println("Server responded: " + response);
        } catch (IOException e){
            throw new RuntimeException(e);
        }




    }

}
