package Main.Controller;

import Main.Model.Evaluation;
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

    private TicTacToe_View view;
    TicTacToe_ControllerAI controllerAI;
    private static String currentSheet = "Grass.css";
    public Button b1 = null;
    public Button b2 = null;
    public Button b3 = null;
    private Timeline timeline1;
    private boolean start = false;
    public boolean first = true;






    void ChangeToOnline(TicTacToe_View view) {

        this.view = view;

        System.out.println("You changed the modus to Online");
        Stage Stage = (Stage) view.New_Game_Btn.getScene().getWindow();
        TicTacToe_View newView = new TicTacToe_View(Stage,currentSheet);
        TicTacToe_ModelOnline modelOnline = new TicTacToe_ModelOnline();
        TicTacToe_ControllerOnline controllerOnline = new TicTacToe_ControllerOnline(modelOnline, newView);
    }


    void ChangeToOffline(TicTacToe_View view) {

        this.view = view;

        System.out.println("You changed the modus to Offline");
        Stage stageTheEventSourceNodeBelongs = (Stage) view.New_Game_Btn.getScene().getWindow();
        TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs,currentSheet);
        TicTacToe_ModelOffline modelOffline = new TicTacToe_ModelOffline();
        TicTacToe_ControllerOffline controllerOffline = new TicTacToe_ControllerOffline(modelOffline, newView);
    }

    void ChangeToAIEasy(TicTacToe_View view) {

        this.view = view;


        System.out.println("You changed the modus to AI, Easy");
        Stage stageTheEventSourceNodeBelongs = (Stage) view.New_Game_Btn.getScene().getWindow();
        TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs,currentSheet);
        TicTacToe_ModelAI modelAI = new TicTacToe_ModelAI(view, 1);
        TicTacToe_ControllerAI controllerAI = new TicTacToe_ControllerAI(modelAI, newView, 1);
    }

    void ChangeToAIMedium(TicTacToe_View view) {

        this.view = view;


        System.out.println("You changed the modus to AI, Medium");
        Stage stageTheEventSourceNodeBelongs = (Stage) view.New_Game_Btn.getScene().getWindow();
        TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs, currentSheet);
        TicTacToe_ModelAI modelAI = new TicTacToe_ModelAI(view, 2);
        TicTacToe_ControllerAI controllerAI = new TicTacToe_ControllerAI(modelAI, newView, 2);

    }

    void ChangeToAIHard(TicTacToe_View view) {

        this.view = view;


        System.out.println("You changed the modus to AI, Hard");
        Stage stageTheEventSourceNodeBelongs = (Stage) view.New_Game_Btn.getScene().getWindow();
        TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs,currentSheet);
        TicTacToe_ModelAI modelAI = new TicTacToe_ModelAI(view, 3);
        TicTacToe_ControllerAI controllerAI = new TicTacToe_ControllerAI(modelAI, newView, 3);
    }

    public static void DisableAllButtons(TicTacToe_View view) {


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

    void EnableAllButtons(TicTacToe_View view) {

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

    void ResetTextOfButtons(TicTacToe_View view) {

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

    void ResetImageOfButtons(TicTacToe_View view) {


           view.Btn1.setStyle("-fx-background-image: url('Main/Stuff/transparent.png')");
           view.Btn4.setStyle("-fx-background-image: url('Main/Stuff/transparent.png')");
           view.Btn7.setStyle("-fx-background-image: url('Main/Stuff/transparent.png')");
           view.Btn2.setStyle("-fx-background-image: url('Main/Stuff/transparent.png')");
           view.Btn5.setStyle("-fx-background-image: url('Main/Stuff/transparent.png')");
           view.Btn8.setStyle("-fx-background-image: url('Main/Stuff/transparent.png')");
           view.Btn3.setStyle("-fx-background-image: url('Main/Stuff/transparent.png')");
           view.Btn6.setStyle("-fx-background-image: url('Main/Stuff/transparent.png')");
           view.Btn9.setStyle("-fx-background-image: url('Main/Stuff/transparent.png')");

    }


    static void setCurrentSheet(String s, Scene sc){
        sc.getStylesheets().clear();
        sc.getStylesheets().add(s);


        ChangeModus.currentSheet =s;
    }






    private void OwinnerEffect(Button btn1, Button btn2, Button btn3){

        String RightLabelText = view.RightLabel.getText();


        timeline1 = new Timeline(new KeyFrame(Duration.seconds(0.5), evt -> btn1.setStyle("-fx-background-image: url('Main/Stuff/transparent.png');" )),
                new KeyFrame(Duration.seconds(0.5), evt -> btn2.setStyle("-fx-background-image: url('Main/Stuff/transparent.png');" )),
                new KeyFrame(Duration.seconds(0.5), evt -> btn3.setStyle("-fx-background-image: url('Main/Stuff/transparent.png');" )),
                new KeyFrame(Duration.seconds(0.5), evt -> view.RightLabel.setText(RightLabelText) ),
                new KeyFrame(Duration.seconds(1), evt -> btn1.setStyle("-fx-background-image: url('Main/Stuff/O.png');" )),
                new KeyFrame(Duration.seconds(1), evt -> btn2.setStyle("-fx-background-image: url('Main/Stuff/O.png');" )),
                new KeyFrame(Duration.seconds(1), evt -> btn3.setStyle("-fx-background-image: url('Main/Stuff/O.png');")),
                new KeyFrame(Duration.seconds(1), evt -> view.RightLabel.setText("Winner!")));



        timeline1.setCycleCount(Animation.INDEFINITE);
        timeline1.play();
        start=true;

    }


    private void XwinnerEffect(Button btn1, Button btn2, Button btn3){

        String LeftLabelText = view.LeftLabel.getText();

        timeline1 = new Timeline(new KeyFrame(Duration.seconds(0.5), evt -> btn1.setStyle("-fx-background-image: url('Main/Stuff/transparent.png');" )),
                new KeyFrame(Duration.seconds(0.5), evt -> btn2.setStyle("-fx-background-image: url('Main/Stuff/transparent.png');" )),
                new KeyFrame(Duration.seconds(0.5), evt -> btn3.setStyle("-fx-background-image: url('Main/Stuff/transparent.png');" )),
                new KeyFrame(Duration.seconds(0.5), evt -> view.LeftLabel.setText(LeftLabelText) ),
                new KeyFrame(Duration.seconds(1), evt -> btn1.setStyle("-fx-background-image: url('Main/Stuff/X.png');" )),
                new KeyFrame(Duration.seconds(1), evt -> btn2.setStyle("-fx-background-image: url('Main/Stuff/X.png');" )),
                new KeyFrame(Duration.seconds(1), evt -> btn3.setStyle("-fx-background-image: url('Main/Stuff/X.png');")),
                new KeyFrame(Duration.seconds(1), evt -> view.LeftLabel.setText("Winner!")));



        timeline1.setCycleCount(Animation.INDEFINITE);
        timeline1.play();
        start=true;

    }

    void stopAnimation(){
        if(start)
            timeline1.stop();
        start = false;
    }

    public void startOAnimation() {
        if (Evaluation.getWinnerLine() == 1) {
            OwinnerEffect(view.Btn1, view.Btn2, view.Btn3);
        } else if (Evaluation.getWinnerLine() == 2) {
            OwinnerEffect(view.Btn4, view.Btn5, view.Btn6);
        } else if (Evaluation.getWinnerLine() == 3) {
            OwinnerEffect(view.Btn7, view.Btn8, view.Btn9);
        } else if (Evaluation.getWinnerLine() == 4) {
            OwinnerEffect(view.Btn1, view.Btn4, view.Btn7);
        } else if (Evaluation.getWinnerLine() == 5) {
            OwinnerEffect(view.Btn2, view.Btn5, view.Btn8);
        } else if (Evaluation.getWinnerLine() == 6) {
            OwinnerEffect(view.Btn3, view.Btn6, view.Btn9);
        } else if (Evaluation.getWinnerLine() == 7) {
            OwinnerEffect(view.Btn1, view.Btn5, view.Btn9);
        } else if (Evaluation.getWinnerLine() == 8) {
            OwinnerEffect(view.Btn7, view.Btn5, view.Btn3);
        }
    }

   public void startXAnimation() {
        if (Evaluation.getWinnerLine() == 1) {
            XwinnerEffect(view.Btn1, view.Btn2, view.Btn3);
        } else if (Evaluation.getWinnerLine() == 2) {
            XwinnerEffect(view.Btn4, view.Btn5, view.Btn6);
        } else if (Evaluation.getWinnerLine() == 3) {
            XwinnerEffect(view.Btn7, view.Btn8, view.Btn9);
        } else if (Evaluation.getWinnerLine() == 4) {
            XwinnerEffect(view.Btn1, view.Btn4, view.Btn7);
        } else if (Evaluation.getWinnerLine() == 5) {
            XwinnerEffect(view.Btn2, view.Btn5, view.Btn8);
        } else if (Evaluation.getWinnerLine() == 6) {
            XwinnerEffect(view.Btn3, view.Btn6, view.Btn9);
        } else if (Evaluation.getWinnerLine() == 7) {
            XwinnerEffect(view.Btn1, view.Btn5, view.Btn9);
        } else if (Evaluation.getWinnerLine() == 8) {
            XwinnerEffect(view.Btn7, view.Btn5, view.Btn3);
        }
    }
}