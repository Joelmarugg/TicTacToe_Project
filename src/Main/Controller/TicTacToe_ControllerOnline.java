package Main.Controller;

import Main.Model.TicTacToe_ModelOnline;
import Main.View.TicTacToe_View;
import javafx.scene.control.Menu;

public class TicTacToe_ControllerOnline extends ChangeModus {

    TicTacToe_View view;
    TicTacToe_ModelOnline model;

    public TicTacToe_ControllerOnline (TicTacToe_ModelOnline model, TicTacToe_View view){

        this.model = model;
        this.view = view;
        ChangeModus c = new ChangeModus();

        ((Menu) (view.OptionsMenu.getItems().get(0))).getItems().get(0).setOnAction((event) -> {
            //change theme to "Sky"
            setCurrentSheet("Sky.css", view.scene);
        });

        ((Menu) (view.OptionsMenu.getItems().get(0))).getItems().get(1).setOnAction((event) -> {
            //change theme to "Sky"
            setCurrentSheet("Grass.css", view.scene);
        });

        view.ModusMenu.getItems().get(1).setDisable(true);

        view.ModusMenu.getItems().get(0).setOnAction((event) -> {

            ChangeToOffline(view);
            model.NewGame();
        });

        ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(0).setOnAction((event) -> {

            ChangeToAIEasy(view);
            model.NewGame();
        });

        ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(1).setOnAction((event) -> {

            ChangeToAIMedium(view);
            model.NewGame();
        });

        ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(2).setOnAction((event) -> {

            ChangeToAIHard(view);
            model.NewGame();
        });






        view.Btn1.setOnAction((event) ->
        System.out.println("OOnlineModeee")
        );
    }
}
