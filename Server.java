package ro.mta.ip.TemaJava;

import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

public class Server{
    static final int PORT = 5056;
    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        while (true)
        {
            Socket socket = null;

            try
            {
                socket = serverSocket.accept();
                System.out.println("A new client is connected : " + socket);
                System.out.println("Assigning new thread for this client");

                // create a new thread object
                Thread t = new ClientHandler(socket);

                // Invoking the start() method
                t.start();

            }
            catch (Exception e){
                socket.close();
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler extends Thread
{
    final Socket s;

    public ClientHandler(Socket s)
    {
        this.s = s;
    }

    @Override
    public void run()
    {
        ArrayList<Human> humanList = new ArrayList<>();
        try {
            PrintWriter out =
                    new PrintWriter(s.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in));
            out.println("Server: Conexiune realizata");

            String inputLine,outputLine;
            while ((inputLine = in.readLine()) != null) {
                String[] humans = inputLine.split(" ");
                if(humans[0].equals("Profesor")) {
                    humanList.add(new Profesor(inputLine));
                }
                else if(humans[0].equals("Student")) {
                    humanList.add(new Student(inputLine));
                }

                outputLine = stdIn.readLine();
                out.println(outputLine);

                if (outputLine.equals("Bye.")) {
                    System.out.println("Closing this connection.");
                    this.s.close();
                    System.out.println("Connection closed");

                    Collections.sort(humanList);

                    System.out.println("\nLista ordonata dupa varsta:");
                    for(int i=0;i<humanList.size(); i++)
                    {
                        System.out.println(humanList.get(i).toString());
                    }
                    break;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}