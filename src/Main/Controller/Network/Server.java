package Main.Controller.Network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket server;

    public Server() {

        //Start the server
        try {
            server = new ServerSocket(14909);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server started");

    }

    public void sendTurn(){

        try {

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
