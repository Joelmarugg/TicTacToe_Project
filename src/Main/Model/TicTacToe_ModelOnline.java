package Main.Model;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Alert;
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
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Who starts?");
            alert.setHeaderText("You have the first turn.");
            alert.show();
            System.out.println("you are client");


        } else {
            isHost = true;//Yes
            turn = false;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Who starts?");
            alert.setHeaderText("Client has the first turn.");
            alert.show();
            System.out.println("You are host");


        }
        System.out.println(eingabe);


    }



}

