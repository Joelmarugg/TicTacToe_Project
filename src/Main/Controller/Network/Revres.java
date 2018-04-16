/*package Model.Network;



import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class Revres {


    public final ServerSocket server;
    private Boolean stop = false;
    String s = "null";
    Socket socket = null;
    String payload1 ="";
    String end = ",end";
    public String PlayerNames = "Joel";





    public Revres(int port, int backlog, String bindAddr) throws IOException { server = new ServerSocket(port, backlog, InetAddress.getByName(bindAddr)); }



    public void verbinde() {

        while (true) {
            System.out.println("ok");
            try {

                socket = server.accept();
                reinRaus(socket);
            } catch (IOException e) {
                if(e instanceof SocketException)
                    System.out.println("Socket is closed");
                else
                    e.printStackTrace();
            } finally {
                if (socket != null)
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            }
        }
    }

    private void reinRaus(Socket socket) throws IOException {

        ObjectOutput out = null;


        //byte[] yourBytes = bos.toByteArray();


        BufferedReader rein = new BufferedReader(new InputStreamReader(socket
                .getInputStream()));


        System.out.println("we are waiting for messages...");

        while ((s = rein.readLine()) != null && !stop) {
            System.out.println("we have received this message : "+s);


            //client checks available games
            if(s.equals("status")){
                new ObjectOutputStream(socket.getOutputStream()).writeObject(OnlineController.CURRENT_PLAYERS_IN_ROOM+"/"+OnlineController.MAX_PLAYERS+","+ PlayerNames+end);
            }
            //client checks for server availability
            if(s.equals("check")){
                new ObjectOutputStream(socket.getOutputStream()).writeObject("1"+payload1+end);
            }
            //client sends his move
            if(s.equals("join")){
                new ObjectOutputStream(socket.getOutputStream()).writeObject("accept"+userdata.getUsername() + "," + userdata.get_selected_figure()+","+ userdata.getUsername()+end);
                String[] sarr = rein.readLine().split(",");

                PlayerNames += !PlayerNames.equals("")?","+sarr[0]:sarr[0];
                if(sarr.length>1)
                    PlayerFigures += !PlayerFigures.equals("")?","+sarr[1]:sarr[1];
                System.out.println("pl names : "+PlayerNames);

            }



        }

    }

    /*    public ArrayList<ArrayList<Card>> getOnlineCards() {

            return hands;
        }
    */
/*    public void stop() {
        stop = true;
        try {
            //socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Try to shutdown server...");

    }

    public String getOppName() {
        return s;
    }
}*/