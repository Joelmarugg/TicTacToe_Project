package Main.Controller.Network;

import Main.Controller.ChangeModus;
import Main.Controller.TicTacToe_ControllerOnline;
import Main.Model.Evaluation;
import Main.Model.Game;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server  {

    ServerSocket server;
    public String serverBoard ="-";
    TicTacToe_ControllerOnline mTicTacToe_ControllerOnline;
    boolean turn = false;
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
                    if (turn){
                        mTicTacToe_ControllerOnline.hostTurn=true;
                        mTicTacToe_ControllerOnline.clientTurn=false;
                    }
                    writer.println(serverBoard);
                    writer.flush();
                }
                if(s.contains("changeboard")){

                    mTicTacToe_ControllerOnline.hostTurn=true;
                    mTicTacToe_ControllerOnline.clientTurn=false;
                    turn=true;

                    serverBoard = s.substring(12,21);
                    String mserverBoard = s.substring(12,21);
                    char[] actboard = Game.getNewBoard();
                    for(int i =0; i< mserverBoard.length();i++) {
                        if(mserverBoard.charAt(i)!='-') {
                            actboard[i] = mserverBoard.charAt(i);
                            switch (i) {
                                case 0:
                                    mTicTacToe_ControllerOnline.view.Btn1.setStyle("-fx-background-image: url('Main/Stuff/" + ((char) (mserverBoard.toCharArray()[i])) + ".png')");
                                    mTicTacToe_ControllerOnline.view.Btn1.setDisable(true);
                                    break;
                                case 1:
                                    mTicTacToe_ControllerOnline.view.Btn2.setStyle("-fx-background-image: url('Main/Stuff/" + ((char) (mserverBoard.toCharArray()[i])) + ".png')");
                                    mTicTacToe_ControllerOnline.view.Btn2.setDisable(true);
                                    break;
                                case 2:
                                    mTicTacToe_ControllerOnline.view.Btn3.setStyle("-fx-background-image: url('Main/Stuff/" + ((char) (mserverBoard.toCharArray()[i])) + ".png')");
                                    mTicTacToe_ControllerOnline.view.Btn3.setDisable(true);
                                    break;
                                case 3:
                                    mTicTacToe_ControllerOnline.view.Btn4.setStyle("-fx-background-image: url('Main/Stuff/" + ((char) (mserverBoard.toCharArray()[i])) + ".png')");
                                    mTicTacToe_ControllerOnline.view.Btn4.setDisable(true);
                                    break;
                                case 4:
                                    mTicTacToe_ControllerOnline.view.Btn5.setStyle("-fx-background-image: url('Main/Stuff/" + ((char) (mserverBoard.toCharArray()[i])) + ".png')");
                                    mTicTacToe_ControllerOnline.view.Btn5.setDisable(true);
                                    break;
                                case 5:
                                    mTicTacToe_ControllerOnline.view.Btn6.setStyle("-fx-background-image: url('Main/Stuff/" + ((char) (mserverBoard.toCharArray()[i])) + ".png')");
                                    mTicTacToe_ControllerOnline.view.Btn6.setDisable(true);
                                    break;
                                case 6:
                                    mTicTacToe_ControllerOnline.view.Btn7.setStyle("-fx-background-image: url('Main/Stuff/" + ((char) (mserverBoard.toCharArray()[i])) + ".png')");
                                    mTicTacToe_ControllerOnline.view.Btn7.setDisable(true);
                                    break;
                                case 7:
                                    mTicTacToe_ControllerOnline.view.Btn8.setStyle("-fx-background-image: url('Main/Stuff/" + ((char) (mserverBoard.toCharArray()[i])) + ".png')");
                                    mTicTacToe_ControllerOnline.view.Btn8.setDisable(true);
                                    break;
                                case 8:
                                    mTicTacToe_ControllerOnline.view.Btn9.setStyle("-fx-background-image: url('Main/Stuff/" + ((char) (mserverBoard.toCharArray()[i])) + ".png')");
                                    mTicTacToe_ControllerOnline.view.Btn9.setDisable(true);
                                    break;
                            }
                        }
                    }
                    mTicTacToe_ControllerOnline.gameBoard = actboard;


                    System.out.println("received from client: " + s +"actboard:  "+ Arrays.toString(actboard));

                    writer.println(serverBoard);
                    writer.flush();
                }

            }
            writer.close();
            reader.close();

        } catch(IOException e1){

            e1.printStackTrace();
        }


    }
}
