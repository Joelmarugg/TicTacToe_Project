package Main.Controller.Network;

import Main.Controller.TicTacToe_ControllerOnline;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket server;
    public String serverBoard ="-";
    TicTacToe_ControllerOnline mTicTacToe_ControllerOnline;

    public Server(TicTacToe_ControllerOnline cntr) {

        mTicTacToe_ControllerOnline=cntr;

        //Start the server
        try {
            server = new ServerSocket(14909);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server started");

    }

    public void connect() throws IOException {
        while(true) {
            Socket client = server.accept();
            changeBoard(client);
        }

    }
    public void changeBoard(Socket mClient){

        try {

            //look for client
            Socket client = mClient;

            //Send streams to client
            OutputStream out = client.getOutputStream();
            PrintStream writer = new PrintStream(out);

            //receive from client
            InputStream in = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String s = null;
            while ((s = reader.readLine()) != null) {


                if(s.contains("getBoard")){
                    writer.println(serverBoard);
                    writer.flush();
                }
                if(s.contains("changeboard")){


                    serverBoard = s.substring(12,21);
                    char[] actboard = new char[9];
                    for(int i =0; i< serverBoard.length();i++) {
                        actboard[i] = serverBoard.charAt(i);
                    }
                    mTicTacToe_ControllerOnline.gameBoard = actboard;

                    writer.println(serverBoard);
                    writer.flush();
                }

                System.out.println("received from client: " + s);
            }
            writer.close();
            reader.close();

        } catch(IOException e1){

            e1.printStackTrace();
        }


    }
}
