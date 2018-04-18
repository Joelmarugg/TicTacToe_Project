package Main.Controller;

import Main.Model.TicTacToe_ModelOnline;
import Main.View.TicTacToe_View;
import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.layout.Pane;

class TicTacToe_ControllerOnline extends ChangeModus {

    private TicTacToe_View view;
    private TicTacToe_ModelOnline model;

    TicTacToe_ControllerOnline(TicTacToe_ModelOnline model, TicTacToe_View view){

        this.model = model;
        this.view = view;


        (view.HelpMenu.getItems().get(0)).setOnAction((event) -> {

            Pane HelpPane = new Pane();
            HelpPane.setId("HelpPane");
            view.root.setCenter(HelpPane);
            view.New_Game_Btn.setDisable(true);

        });

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

        view.Exit_Btn.setOnAction((event) -> Platform.exit());



        view.Btn1.setOnAction((event) ->
        System.out.println("OOnlineModeee")
        );
    }
}
