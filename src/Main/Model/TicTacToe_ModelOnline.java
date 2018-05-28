package Main.Model;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import javax.swing.*;

public class TicTacToe_ModelOnline extends Game{

    public boolean isClient = false;
    public boolean isHost = false;
    public boolean turn = false;



    public TicTacToe_ModelOnline(){

        super();
    }


    public void setHostClient(){
        int eingabe = JOptionPane.showConfirmDialog(null,
                "Do you want to be Host?",
                "Host / Client",
                JOptionPane.YES_NO_OPTION);
        if (eingabe == 1) {
            isClient = true;//No
            turn = true;
            System.out.println("you are client");


        } else {
            isHost = true;//Yes
            turn = false;
            System.out.println("You are host");


        }
        System.out.println(eingabe);


    }



}

