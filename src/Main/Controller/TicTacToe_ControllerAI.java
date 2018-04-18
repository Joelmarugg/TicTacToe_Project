package Main.Controller;

import Main.Model.Evaluation;
import Main.Model.TicTacToe_ModelAI;
import Main.View.TicTacToe_View;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import static Main.Controller.ChangeModus.*;

public class TicTacToe_ControllerAI extends ChangeModus {

    TicTacToe_View view;
    TicTacToe_ModelAI model;
    public int level;

    public TicTacToe_ControllerAI(TicTacToe_ModelAI model, TicTacToe_View view, int level) {

        this.model = model;
        this.view = view;
        this.level = level;


        DisableAllButtons(view);
        if (level == 1) {
            ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(0).setDisable(true);

        } else if (level == 2) {
            ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(1).setDisable(true);

        } else if (level == 3) {
            ((Menu) (view.ModusMenu.getItems().get(2))).getItems().get(2).setDisable(true);
        }


        (view.HelpMenu.getItems().get(0)).setOnAction((event) -> {

            Pane HelpPane = new Pane();

            HelpPane.setId("HelpPane");

            view.root.setCenter(HelpPane);
        });

        ((Menu) (view.OptionsMenu.getItems().get(0))).getItems().get(0).setOnAction((event) -> {
            //change theme to "Sky"
            view.scene.getStylesheets().add("Sky.css");

        });
        ((Menu) (view.OptionsMenu.getItems().get(0))).getItems().get(1).setOnAction((event) -> {
            //change theme to "Sky"
            setCurrentSheet("Grass.css", view.scene);
        });

        view.Btn1.setOnAction((event) -> {

            view.Btn1.setStyle("-fx-background-image: url('Main/Stuff/O.png')");
            model.O_move(0, 0);
            if (Evaluation.O_CheckForWinner()) {
                DisableAllButtons(view);
                startOAnimation();
                System.out.println("Player O winns");
            }
            model.IncreaseMoveNumber();
            view.Btn1.setDisable(true);
            System.out.println("you pressed button 1");

            ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setStyle("-fx-background-image: url('Main/Stuff/X.png')");
            ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setDisable(true);
            if (model.Winner) {
                DisableAllButtons(view);
                startXAnimation();
            }
        });

        view.Btn2.setOnAction((event) -> {

            view.Btn2.setStyle("-fx-background-image: url('Main/Stuff/O.png')");
            model.O_move(0, 1);
            if (Evaluation.O_CheckForWinner()) {
                DisableAllButtons(view);
                startOAnimation();
                System.out.println("Player O winns");
            }
            model.IncreaseMoveNumber();
            view.Btn2.setDisable(true);
            System.out.println("you pressed button 2");

            ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setStyle("-fx-background-image: url('Main/Stuff/X.png')");
            ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setDisable(true);
            if (model.Winner) {
                DisableAllButtons(view);
                startXAnimation();
            }
        });

        view.Btn3.setOnAction((event) -> {

            view.Btn3.setStyle("-fx-background-image: url('Main/Stuff/O.png')");
            model.O_move(0, 2);
            if (Evaluation.O_CheckForWinner()) {
                DisableAllButtons(view);
                startOAnimation();
                System.out.println("Player O winns");
            }
            model.IncreaseMoveNumber();
            view.Btn3.setDisable(true);
            System.out.println("you pressed button 3");

            ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setStyle("-fx-background-image: url('Main/Stuff/X.png')");
            ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setDisable(true);
            if (model.Winner) {
                DisableAllButtons(view);
                startXAnimation();
            }
        });

        view.Btn4.setOnAction((event) -> {

            view.Btn4.setStyle("-fx-background-image: url('Main/Stuff/O.png')");
            model.O_move(1, 0);
            if (Evaluation.O_CheckForWinner()) {
                DisableAllButtons(view);
                startOAnimation();
                System.out.println("Player O winns");
            }
            model.IncreaseMoveNumber();
            view.Btn4.setDisable(true);
            System.out.println("you pressed button 4");

            ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setStyle("-fx-background-image: url('Main/Stuff/X.png')");
            ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setDisable(true);
            if (model.Winner) {
                DisableAllButtons(view);
                startXAnimation();
            }
        });

        view.Btn5.setOnAction((event) -> {

            view.Btn5.setStyle("-fx-background-image: url('Main/Stuff/O.png')");
            model.O_move(1, 1);
            if (Evaluation.O_CheckForWinner()) {
                DisableAllButtons(view);
                startOAnimation();
                System.out.println("Player O winns");
            }
            model.IncreaseMoveNumber();
            view.Btn5.setDisable(true);
            System.out.println("you pressed button 5");

            ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setStyle("-fx-background-image: url('Main/Stuff/X.png')");
            ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setDisable(true);
            if (model.Winner) {
                DisableAllButtons(view);
                startXAnimation();
            }
        });

        view.Btn6.setOnAction((event) -> {

            view.Btn6.setStyle("-fx-background-image: url('Main/Stuff/O.png')");
            model.O_move(1, 2);
            if (Evaluation.O_CheckForWinner()) {
                DisableAllButtons(view);
                startOAnimation();
                System.out.println("Player O winns");
            }
            model.IncreaseMoveNumber();
            view.Btn6.setDisable(true);
            System.out.println("you pressed button 6");

            ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setStyle("-fx-background-image: url('Main/Stuff/X.png')");
            ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setDisable(true);
            if (model.Winner) {
                DisableAllButtons(view);
                startXAnimation();
            }
        });

        view.Btn7.setOnAction((event) -> {

            view.Btn7.setStyle("-fx-background-image: url('Main/Stuff/O.png')");
            model.O_move(2, 0);
            if (Evaluation.O_CheckForWinner()) {
                DisableAllButtons(view);
                startOAnimation();
                System.out.println("Player O winns");
            }
            model.IncreaseMoveNumber();
            view.Btn7.setDisable(true);
            System.out.println("you pressed button 7");

            ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setStyle("-fx-background-image: url('Main/Stuff/X.png')");
            ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setDisable(true);
            if (model.Winner) {
                DisableAllButtons(view);
                startXAnimation();
            }
        });

        view.Btn8.setOnAction((event) -> {

            view.Btn8.setStyle("-fx-background-image: url('Main/Stuff/O.png')");
            model.O_move(2, 1);
            if (Evaluation.O_CheckForWinner()) {
                DisableAllButtons(view);
                startOAnimation();
                System.out.println("Player O winns");
            }
            model.IncreaseMoveNumber();
            view.Btn8.setDisable(true);
            System.out.println("you pressed button 8");

            ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setStyle("-fx-background-image: url('Main/Stuff/X.png')");
            ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setDisable(true);
            if (model.Winner) {
                DisableAllButtons(view);
                startXAnimation();
            }
        });

        view.Btn9.setOnAction((event) -> {

            view.Btn9.setStyle("-fx-background-image: url('Main/Stuff/O.png')");
            model.O_move(2, 2);
            if (Evaluation.O_CheckForWinner()) {
                DisableAllButtons(view);
                startOAnimation();
                System.out.println("Player O winns");
            }
            model.IncreaseMoveNumber();
            view.Btn9.setDisable(true);
            System.out.println("you pressed button 9");

            ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setStyle("-fx-background-image: url('Main/Stuff/X.png')");
            ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setDisable(true);
            if (model.Winner) {
                DisableAllButtons(view);
                startXAnimation();
            }

        });

        view.New_Game_Btn.setOnAction((event) -> {
            model.NewGame();
            System.out.println("you started a new game");
            ResetTextOfButtons(view);
            ResetImageOfButtons(view);
            stopAnimation();
            EnableAllButtons(view);
            model.setBeginner();
            if (model.isBeginner) {
                ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setStyle("-fx-background-image: url('Main/Stuff/X.png')");
                ((Button) (model.getNodeByRowColumnIndex(model.row, model.column, view.GameGrid))).setDisable(true);
            }

        });

        view.Play_Btn.setOnAction((event) -> {

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

        view.ModusMenu.getItems().get(0).setOnAction((event) -> {

            ChangeToOffline(view);
            model.NewGame();
        });

        view.ModusMenu.getItems().get(1).setOnAction((event) -> {

            ChangeToOnline(view);
            model.NewGame();
        });


    }


    public int getLevel(){
        return level;
    }


}
