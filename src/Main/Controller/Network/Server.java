package Main.Controller.Network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() {

        try {
            //Start the server
            ServerSocket server = new ServerSocket(5555);
            System.out.println("Server started");

            //look for client
            Socket client = server.accept();

            //Send streams to client
            OutputStream out = client.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            //receive from client
            InputStream in = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String s = null;
            while ((s = reader.readLine()) != null) {
                writer.write(s + "\n");
                writer.flush();
                System.out.println("received from client: " + s);
            }
            writer.close();
            reader.close();

        } catch(IOException e1){

            e1.printStackTrace();
        }


    }
}
