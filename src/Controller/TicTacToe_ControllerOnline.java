package Controller;

import Model.TicTacToe_ModelAI;
import Model.TicTacToe_ModelOffline;
import Model.TicTacToe_ModelOnline;
import View.TicTacToe_View;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

public class TicTacToe_ControllerOnline {

    TicTacToe_View view;
    TicTacToe_ModelOnline model;

    public TicTacToe_ControllerOnline (TicTacToe_ModelOnline model, TicTacToe_View view){

        this.model = model;
        this.view = view;

        view.ModusMenu.getItems().get(1).setDisable(true);

        view.ModusMenu.getItems().get(0).setOnAction((event) -> {

            System.out.println("You changed the modus to Offline");
            Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
            TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs);
            TicTacToe_ModelOffline modelOffline = new TicTacToe_ModelOffline();
            TicTacToe_ControllerOffline controllerOffline = new TicTacToe_ControllerOffline(modelOffline,newView);

        });

        ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(0).setOnAction((event) -> {

            System.out.println("You changed the modus to AI, Easy");
            Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
            TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs);
            TicTacToe_ModelAI modelAI = new TicTacToe_ModelAI();
            TicTacToe_ControllerAI controllerAI = new TicTacToe_ControllerAI(modelAI,newView,1);

        });

        ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(1).setOnAction((event) -> {

            System.out.println("You changed the modus to AI, Medium");
            Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
            TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs);
            TicTacToe_ModelAI modelAI = new TicTacToe_ModelAI();
            TicTacToe_ControllerAI controllerAI = new TicTacToe_ControllerAI(modelAI,newView,2);

        });

        ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(2).setOnAction((event) -> {

            System.out.println("You changed the modus to AI, Hard");
            Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
            TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs);
            TicTacToe_ModelAI modelAI = new TicTacToe_ModelAI();
            TicTacToe_ControllerAI controllerAI = new TicTacToe_ControllerAI(modelAI,newView,3);

        });






        view.Btn1.setOnAction((event) ->
        System.out.println("OOnlineModeee")
        );
    }
}
