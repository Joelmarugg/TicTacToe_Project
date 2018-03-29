package Controller;

import Controller.TicTacToe_ControllerOnline;
import Model.TicTacToe_ModelAI;
import Model.TicTacToe_ModelOffline;
import Model.TicTacToe_ModelOnline;
import View.TicTacToe_View;
import javafx.stage.Stage;

public class ChangeModus {

    TicTacToe_View view;

    public void ChangeToOnline(TicTacToe_View view){

        this.view = view;

        System.out.println("You changed the modus to Online");
        Stage Stage = (Stage) view.Btn1.getScene().getWindow();
        TicTacToe_View newView = new TicTacToe_View(Stage);
        TicTacToe_ModelOnline modelOnline = new TicTacToe_ModelOnline();
        TicTacToe_ControllerOnline controllerOnline = new TicTacToe_ControllerOnline(modelOnline,newView);
    }

    public void ChangeToOffline(TicTacToe_View view){

        this.view = view;

        System.out.println("You changed the modus to Offline");
        Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
        TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs);
        TicTacToe_ModelOffline modelOffline = new TicTacToe_ModelOffline();
        TicTacToe_ControllerOffline controllerOffline = new TicTacToe_ControllerOffline(modelOffline,newView);
    }

    public void ChangeToAIEasy(TicTacToe_View view) {

        this.view = view;

        System.out.println("You changed the modus to AI, Easy");
        Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
        TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs);
        TicTacToe_ModelAI modelAI = new TicTacToe_ModelAI();
        TicTacToe_ControllerAI controllerAI = new TicTacToe_ControllerAI(modelAI, newView, 1);
    }

    public void ChangeToAIMedium(TicTacToe_View view) {

        this.view = view;

        System.out.println("You changed the modus to AI, Medium");
        Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
        TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs);
        TicTacToe_ModelAI modelAI = new TicTacToe_ModelAI();
        TicTacToe_ControllerAI controllerAI = new TicTacToe_ControllerAI(modelAI,newView,2);
    }

    public void ChangeToAIHard(TicTacToe_View view) {

        this.view = view;

        System.out.println("You changed the modus to AI, Hard");
        Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
        TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs);
        TicTacToe_ModelAI modelAI = new TicTacToe_ModelAI();
        TicTacToe_ControllerAI controllerAI = new TicTacToe_ControllerAI(modelAI,newView,3);
    }

    public void DisableAllButtons(TicTacToe_View view){

        this.view = view;

        view.Btn1.setDisable(true); view.Btn4.setDisable(true); view.Btn7.setDisable(true);
        view.Btn2.setDisable(true); view.Btn5.setDisable(true); view.Btn8.setDisable(true);
        view.Btn3.setDisable(true); view.Btn6.setDisable(true); view.Btn9.setDisable(true);
    }

    public void EnableAllButtons(TicTacToe_View view){

        this.view = view;

        view.Btn1.setDisable(false); view.Btn4.setDisable(false); view.Btn7.setDisable(false);
        view.Btn2.setDisable(false); view.Btn5.setDisable(false); view.Btn8.setDisable(false);
        view.Btn3.setDisable(false); view.Btn6.setDisable(false); view.Btn9.setDisable(false);
    }

    public void ResetTextOfButtons(TicTacToe_View view){

        this.view = view;

        view.Btn1.setText(""); view.Btn4.setText(""); view.Btn7.setText("");
        view.Btn2.setText(""); view.Btn5.setText(""); view.Btn8.setText("");
        view.Btn3.setText(""); view.Btn6.setText(""); view.Btn9.setText("");
    }

}
