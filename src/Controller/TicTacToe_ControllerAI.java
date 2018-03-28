package Controller;

import Model.TicTacToe_ModelAI;
import Model.TicTacToe_ModelOffline;
import Model.TicTacToe_ModelOnline;
import View.TicTacToe_View;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

public class TicTacToe_ControllerAI extends ChangeModus {

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

                ChangeToAIMedium(view);
                model.NewGame();
            });

            ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(2).setOnAction((event) -> {

                ChangeToAIHard(view);
                model.NewGame();
            });

            view.ModusMenu.getItems().get(0).setOnAction((event) -> {

                ChangeToOffline(view);
                model.NewGame();
            });

            view.ModusMenu.getItems().get(1).setOnAction((event) -> {

                ChangeToOnline(view);
                model.NewGame();
            });

            view.Btn1.setOnAction((event) ->
                    System.out.println("AIIIModeee easy")
            );


        }else if (level == 2){
            ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(1).setDisable(true);

            ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(0).setOnAction((event) -> {

                ChangeToAIEasy(view);
                model.NewGame();
            });

            ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(2).setOnAction((event) -> {

                ChangeToAIHard(view);
                model.NewGame();
            });

            view.ModusMenu.getItems().get(0).setOnAction((event) -> {

                ChangeToOffline(view);
                model.NewGame();
            });

            view.ModusMenu.getItems().get(1).setOnAction((event) -> {

                ChangeToOnline(view);
                model.NewGame();
            });

            view.Btn1.setOnAction((event) ->
                    System.out.println("AIIIModeee medium")
            );


        }else if (level == 3){
            ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(2).setDisable(true);

            ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(0).setOnAction((event) -> {

                ChangeToAIEasy(view);
                model.NewGame();
            });

            ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(1).setOnAction((event) -> {

                ChangeToAIMedium(view);
                model.NewGame();
            });

            view.ModusMenu.getItems().get(0).setOnAction((event) -> {

                ChangeToOffline(view);
                model.NewGame();
            });

            view.ModusMenu.getItems().get(1).setOnAction((event) -> {

                ChangeToOnline(view);
                model.NewGame();
            });

            view.Btn1.setOnAction((event) -> {
                model.O_move(0, 0);

            });



        }
    }



}
