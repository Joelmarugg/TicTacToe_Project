package Main.Controller;

import Main.Model.TicTacToe_ModelAI;
import Main.Model.TicTacToe_ModelOffline;
import Main.Model.TicTacToe_ModelOnline;
import Main.View.TicTacToe_View;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;


public class ChangeModus {

    TicTacToe_View view;
    TicTacToe_ControllerAI controllerAI;
    static public String currentSheet ="Grass.css";
    public Button b1 = null;
    public Button b2 = null;
    public Button b3 = null;
    public Timeline timeline1;
public boolean start = false;






    public void ChangeToOnline(TicTacToe_View view) {

        this.view = view;

        System.out.println("You changed the modus to Online");
        Stage Stage = (Stage) view.Btn1.getScene().getWindow();
        TicTacToe_View newView = new TicTacToe_View(Stage,currentSheet);
        TicTacToe_ModelOnline modelOnline = new TicTacToe_ModelOnline();
        TicTacToe_ControllerOnline controllerOnline = new TicTacToe_ControllerOnline(modelOnline, newView);
    }


    public void ChangeToOffline(TicTacToe_View view) {

        this.view = view;

        System.out.println("You changed the modus to Offline");
        Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
        TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs,currentSheet);
        TicTacToe_ModelOffline modelOffline = new TicTacToe_ModelOffline();
        TicTacToe_ControllerOffline controllerOffline = new TicTacToe_ControllerOffline(modelOffline, newView);
    }

    public void ChangeToAIEasy(TicTacToe_View view) {

        this.view = view;


        System.out.println("You changed the modus to AI, Easy");
        Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
        TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs,currentSheet);
        TicTacToe_ModelAI modelAI = new TicTacToe_ModelAI(view, 1);
        TicTacToe_ControllerAI controllerAI = new TicTacToe_ControllerAI(modelAI, newView, 1);
    }

    public void ChangeToAIMedium(TicTacToe_View view) {

        this.view = view;


        System.out.println("You changed the modus to AI, Medium");
        Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
        TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs, currentSheet);
        TicTacToe_ModelAI modelAI = new TicTacToe_ModelAI(view, 2);
        TicTacToe_ControllerAI controllerAI = new TicTacToe_ControllerAI(modelAI, newView, 2);
    }

    public void ChangeToAIHard(TicTacToe_View view) {

        this.view = view;


        System.out.println("You changed the modus to AI, Hard");
        Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
        TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs,currentSheet);
        TicTacToe_ModelAI modelAI = new TicTacToe_ModelAI(view, 3);
        TicTacToe_ControllerAI controllerAI = new TicTacToe_ControllerAI(modelAI, newView, 3);
    }

    public static void DisableAllButtons(TicTacToe_View view) {

        view = view;

        view.Btn1.setDisable(true);
        view.Btn4.setDisable(true);
        view.Btn7.setDisable(true);
        view.Btn2.setDisable(true);
        view.Btn5.setDisable(true);
        view.Btn8.setDisable(true);
        view.Btn3.setDisable(true);
        view.Btn6.setDisable(true);
        view.Btn9.setDisable(true);
    }

    public void EnableAllButtons(TicTacToe_View view) {

        this.view = view;

        view.Btn1.setDisable(false);
        view.Btn4.setDisable(false);
        view.Btn7.setDisable(false);
        view.Btn2.setDisable(false);
        view.Btn5.setDisable(false);
        view.Btn8.setDisable(false);
        view.Btn3.setDisable(false);
        view.Btn6.setDisable(false);
        view.Btn9.setDisable(false);
    }

    public void ResetTextOfButtons(TicTacToe_View view) {

        this.view = view;

        view.Btn1.setText("");
        view.Btn4.setText("");
        view.Btn7.setText("");
        view.Btn2.setText("");
        view.Btn5.setText("");
        view.Btn8.setText("");
        view.Btn3.setText("");
        view.Btn6.setText("");
        view.Btn9.setText("");
    }

    public void ResetImageOfButtons(TicTacToe_View view) {
        view.Btn1.setStyle("-fx-background-image: empty");
        view.Btn4.setStyle("-fx-background-image: empty");
        view.Btn7.setStyle("-fx-background-image: empty");
        view.Btn2.setStyle("-fx-background-image: empty");
        view.Btn5.setStyle("-fx-background-image: empty");
        view.Btn8.setStyle("-fx-background-image: empty");
        view.Btn3.setStyle("-fx-background-image: empty");
        view.Btn6.setStyle("-fx-background-image: empty");
        view.Btn9.setStyle("-fx-background-image: empty");
    }


    public static void setCurrentSheet(String s, Scene sc){
        sc.getStylesheets().clear();
        sc.getStylesheets().add(s);


        ChangeModus.currentSheet =s;
    }






    public void OwinnerEffect(Button btn1, Button btn2, Button btn3){

        timeline1 = new Timeline(new KeyFrame(Duration.seconds(0.5), evt -> btn1.setStyle("-fx-background-image: empty;" )),
                new KeyFrame(Duration.seconds(0.5), evt -> btn2.setStyle("-fx-background-image: empty;" )),
                new KeyFrame(Duration.seconds(0.5), evt -> btn3.setStyle("-fx-background-image: empty;" )),
                new KeyFrame(Duration.seconds(1), evt -> btn1.setStyle("-fx-background-image: url('Main/Stuff/O.png');" )),
                new KeyFrame(Duration.seconds(1), evt -> btn2.setStyle("-fx-background-image: url('Main/Stuff/O.png');" )),
                new KeyFrame(Duration.seconds(1), evt -> btn3.setStyle("-fx-background-image: url('Main/Stuff/O.png');")));



        timeline1.setCycleCount(Animation.INDEFINITE);
        timeline1.play();
        start=true;

    }
    public void stopAnimation(){
        if(start)
        timeline1.stop();
        start = false;
    }

    public void XwinnerEffect(TicTacToe_View view){



    }

}