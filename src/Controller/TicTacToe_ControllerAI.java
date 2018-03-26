package Controller;

import Model.TicTacToe_ModelAI;
import Model.TicTacToe_ModelOffline;
import Model.TicTacToe_ModelOnline;
import View.TicTacToe_View;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

public class TicTacToe_ControllerAI {

    TicTacToe_View view;
    TicTacToe_ModelAI model;
    int level;

    public TicTacToe_ControllerAI(TicTacToe_ModelAI model, TicTacToe_View view, int level){

        this.model = model;
        this.view = view;
        this.level = level;

        if(level == 1) {
            ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(0).setDisable(true);

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

            view.ModusMenu.getItems().get(0).setOnAction((event) -> {

                System.out.println("You changed the modus to Offline");
                Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
                TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs);
                TicTacToe_ModelOffline modelOffline = new TicTacToe_ModelOffline();
                TicTacToe_ControllerOffline controllerOffline = new TicTacToe_ControllerOffline(modelOffline,newView);

            });

            view.ModusMenu.getItems().get(1).setOnAction((event) -> {

                System.out.println("You changed the modus to Online");
                Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
                TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs);
                TicTacToe_ModelOnline modelOnline = new TicTacToe_ModelOnline();
                TicTacToe_ControllerOnline controllerOnline = new TicTacToe_ControllerOnline(modelOnline,newView);

            });

            view.Btn1.setOnAction((event) ->
                    System.out.println("AIIIModeee easy")
            );


        }else if (level == 2){
            ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(1).setDisable(true);

            ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(0).setOnAction((event) -> {

                System.out.println("You changed the modus to AI, Easy");
                Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
                TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs);
                TicTacToe_ModelAI modelAI = new TicTacToe_ModelAI();
                TicTacToe_ControllerAI controllerAI = new TicTacToe_ControllerAI(modelAI,newView,1);

            });

            ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(2).setOnAction((event) -> {

                System.out.println("You changed the modus to AI, Hard");
                Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
                TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs);
                TicTacToe_ModelAI modelAI = new TicTacToe_ModelAI();
                TicTacToe_ControllerAI controllerAI = new TicTacToe_ControllerAI(modelAI,newView,3);

            });

            view.ModusMenu.getItems().get(0).setOnAction((event) -> {

                System.out.println("You changed the modus to Offline");
                Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
                TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs);
                TicTacToe_ModelOffline modelOffline = new TicTacToe_ModelOffline();
                TicTacToe_ControllerOffline controllerOffline = new TicTacToe_ControllerOffline(modelOffline,newView);

            });

            view.ModusMenu.getItems().get(1).setOnAction((event) -> {

                System.out.println("You changed the modus to Online");
                Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
                TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs);
                TicTacToe_ModelOnline modelOnline = new TicTacToe_ModelOnline();
                TicTacToe_ControllerOnline controllerOnline = new TicTacToe_ControllerOnline(modelOnline,newView);

            });

            view.Btn1.setOnAction((event) ->
                    System.out.println("AIIIModeee medium")
            );


        }else if (level == 3){
            ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(2).setDisable(true);

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

            view.ModusMenu.getItems().get(0).setOnAction((event) -> {

                System.out.println("You changed the modus to Offline");
                Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
                TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs);
                TicTacToe_ModelOffline modelOffline = new TicTacToe_ModelOffline();
                TicTacToe_ControllerOffline controllerOffline = new TicTacToe_ControllerOffline(modelOffline,newView);

            });

            view.ModusMenu.getItems().get(1).setOnAction((event) -> {

                System.out.println("You changed the modus to Online");
                Stage stageTheEventSourceNodeBelongs = (Stage) view.Btn1.getScene().getWindow();
                TicTacToe_View newView = new TicTacToe_View(stageTheEventSourceNodeBelongs);
                TicTacToe_ModelOnline modelOnline = new TicTacToe_ModelOnline();
                TicTacToe_ControllerOnline controllerOnline = new TicTacToe_ControllerOnline(modelOnline,newView);

            });

            view.Btn1.setOnAction((event) ->
                    System.out.println("AIIIModeee hard")
            );

        }
    }



}
