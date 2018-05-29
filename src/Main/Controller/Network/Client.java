package Main.Controller.Network;

import Main.Model.Game;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Client {

    Socket client;


    public Client(){
        try {
            client = new Socket("localhost", 14909);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Client started");
    }

    public String communicate(String message){
        try {

            //Send streams to server
            OutputStream out = client.getOutputStream();
            PrintStream writer = new PrintStream(out);

            //receive from server
            InputStream in = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));




            //Send to server
            writer.println(message);
            writer.flush();

            String s = null;
            while ((s = reader.readLine()) != null) {
                //System.out.println("received from Server: " + s);
                return s;
            }

            writer.close();
            reader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
