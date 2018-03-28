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


}
