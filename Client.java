package ro.mta.ip.TemaJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException{
        String hostName = "localhost";
        int portNumber = Integer.parseInt("5056");
        try {
            Socket me = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(me.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(me.getInputStream()));
            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in));
            String fromServer, fromUser;
            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye.")) {
                    System.out.println("Connection closed by server...");
                    break;
                }
                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
