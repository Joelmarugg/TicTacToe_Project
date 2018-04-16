package Main.Controller.Network;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {


    public Client(){
        try {

            Socket client = new Socket("localhost", 5555);
            System.out.println("Client started");


            //Send streams to server
            OutputStream out = client.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            //receive from server
            InputStream in = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));



            //Send to server
            writer.write("hallo Server!\n");
            writer.flush();

            String s = null;
            while ((s = reader.readLine()) != null) {
                System.out.println("received from Server: " + s);
            }

            writer.close();
            reader.close();


        }catch (UnknownHostException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
