package Main.Controller;

import Main.Model.*;
import Main.View.TicTacToe_View;
import javafx.scene.Scene;
import javafx.scene.control.Menu;

public class TicTacToe_ControllerOffline extends ChangeModus{

    TicTacToe_ModelOffline model;
    TicTacToe_View view;




    public TicTacToe_ControllerOffline(TicTacToe_ModelOffline model, TicTacToe_View view){

        this.model = model;
        this.view = view;
        



        DisableAllButtons(view);


        view.ModusMenu.getItems().get(0).setDisable(true);



        ((Menu) (view.OptionsMenu.getItems().get(0))).getItems().get(0).setOnAction((event) -> {
            //change theme to "Sky"
            setCurrentSheet("Sky.css", view.scene);
        });

        ((Menu) (view.OptionsMenu.getItems().get(0))).getItems().get(1).setOnAction((event) -> {
            //change theme to "Sky"
            setCurrentSheet("Grass.css", view.scene);
        });

        view.ModusMenu.getItems().get(1).setOnAction((event) -> {

            ChangeToOnline(view);
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

        view.New_Game_Btn.setOnAction((event) -> {
            model.NewGame();
            model.ResetNumberOfMoves();
            ResetTextOfButtons(view);
            ResetImageOfButtons(view);
            EnableAllButtons(view);
            System.out.println("you started a new game");
        });

        view.Btn1.setOnAction((event) -> {

            if (model.getNumberOfMoves() % 2 == 0) {
                view.Btn1.setStyle("-fx-background-image: url('Main/Stuff/blackO.png')");
                model.O_move(0,0);
                if (Evaluation.O_CheckForWinner()){
                    DisableAllButtons(view);
                    //view.LeftLabel_Box.setStyle("-fx-background-color: yellow");
                    System.out.println("Player O winns");
                }
            }else{
                view.Btn1.setStyle("-fx-background-image: url('Main/Stuff/blackX.png')");
                model.X_move(0,0);
                if (Evaluation.X_CheckForWinner()){
                    DisableAllButtons(view);
                    //view.RightLabel_Box.setStyle("-fx-background-color: yellow");
                    System.out.println("Player X winns");
                }
            }
            model.IncreaseMoveNumber();
            view.Btn1.setDisable(true);
            if (model.CheckTie()){
                System.out.println("its a tie.. no winner!");
            };
            System.out.println("you pressed button 1");

        });

        view.Btn2.setOnAction((event) -> {

            if (model.getNumberOfMoves() % 2 == 0) {
                view.Btn2.setStyle("-fx-background-image: url('Main/Stuff/blackO.png')");
                model.O_move(0,1);
                if (Evaluation.O_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player O winns");
                }
            }else{
                view.Btn2.setStyle("-fx-background-image: url('Main/Stuff/blackX.png')");
                model.X_move(0,1);
                if (Evaluation.X_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player X winns");
                }
            }
            model.IncreaseMoveNumber();
            view.Btn2.setDisable(true);
            if (model.CheckTie()){
                System.out.println("its a tie.. no winner!");
            };
            System.out.println("you pressed button 2");
        });

        view.Btn3.setOnAction((event) -> {
            if (model.getNumberOfMoves() % 2 == 0) {
                view.Btn3.setStyle("-fx-background-image: url('Main/Stuff/blackO.png')");
                model.O_move(0,2);
                if (Evaluation.O_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player O winns");
                }
            }else{
                view.Btn3.setStyle("-fx-background-image: url('Main/Stuff/blackX.png')");
                model.X_move(0,2);
                if (Evaluation.X_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player X winns");
                }
            }
            model.IncreaseMoveNumber();
            view.Btn3.setDisable(true);
            if (model.CheckTie()){
                System.out.println("its a tie.. no winner!");
            };
            System.out.println("you pressed button 3");
        });

        view.Btn4.setOnAction((event) -> {
            if (model.getNumberOfMoves() % 2 == 0) {
                view.Btn4.setStyle("-fx-background-image: url('Main/Stuff/blackO.png')");
                model.O_move(1,0);
                if (Evaluation.O_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player O winns");
                }
            }else{
                view.Btn4.setStyle("-fx-background-image: url('Main/Stuff/blackX.png')");;
                model.X_move(1,0);
                if (Evaluation.X_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player X winns");
                }
            }
            model.IncreaseMoveNumber();
            view.Btn4.setDisable(true);
            if (model.CheckTie()){
                System.out.println("its a tie.. no winner!");
            };
            System.out.println("you pressed button 4");
        });

        view.Btn5.setOnAction((event) -> {
            if (model.getNumberOfMoves() % 2 == 0) {
                view.Btn5.setStyle("-fx-background-image: url('Main/Stuff/blackO.png')");
                model.O_move(1,1);
                if (Evaluation.O_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player O winns");
                }
            }else{
                view.Btn5.setStyle("-fx-background-image: url('Main/Stuff/blackX.png')");
                model.X_move(1,1);
                if (Evaluation.X_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player X winns");
                }
            }
            model.IncreaseMoveNumber();
            view.Btn5.setDisable(true);
            if (model.CheckTie()){
                System.out.println("its a tie.. no winner!");
            };
            System.out.println("you pressed button 5");
        });

        view.Btn6.setOnAction((event) -> {
            if (model.getNumberOfMoves() % 2 == 0) {
                view.Btn6.setStyle("-fx-background-image: url('Main/Stuff/blackO.png')");
                model.O_move(1,2);
                if (Evaluation.O_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player O winns");
                }
            }else{
                view.Btn6.setStyle("-fx-background-image: url('Main/Stuff/blackX.png')");
                model.X_move(1,2);
                if (Evaluation.X_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player X winns");
                }
            }
            model.IncreaseMoveNumber();
            view.Btn6.setDisable(true);
            if (model.CheckTie()){
                System.out.println("its a tie.. no winner!");
            };
            System.out.println("you pressed button 6");
        });

        view.Btn7.setOnAction((event) -> {
            if (model.getNumberOfMoves() % 2 == 0) {
                view.Btn7.setStyle("-fx-background-image: url('Main/Stuff/blackO.png')");
                model.O_move(2,0);
                if (Evaluation.O_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player O winns");
                }
            }else{
                view.Btn7.setStyle("-fx-background-image: url('Main/Stuff/blackX.png')");
                model.X_move(2,0);
                if (Evaluation.X_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player X winns");
                }
            }
            model.IncreaseMoveNumber();
            view.Btn7.setDisable(true);
            if (model.CheckTie()){
                System.out.println("its a tie.. no winner!");
            };
            System.out.println("you pressed button 7");
        });

        view.Btn8.setOnAction((event) -> {
            if (model.getNumberOfMoves() % 2 == 0) {
                view.Btn8.setStyle("-fx-background-image: url('Main/Stuff/blackO.png')");
                model.O_move(2,1);
                if (Evaluation.O_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player O winns");
                }
            }else{
                view.Btn8.setStyle("-fx-background-image: url('Main/Stuff/blackX.png')");
                model.X_move(2,1);
                if (Evaluation.X_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player X winns");
                }
            }
            model.IncreaseMoveNumber();
            view.Btn8.setDisable(true);
            if (model.CheckTie()){
                System.out.println("its a tie.. no winner!");
            };
            System.out.println("you pressed button 8");
        });

        view.Btn9.setOnAction((event) -> {
            if (model.getNumberOfMoves() % 2 == 0) {
                view.Btn9.setStyle("-fx-background-image: url('Main/Stuff/blackO.png')");
                model.O_move(2,2);
                if (Evaluation.O_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player O winns");
                }
            }else{
                view.Btn9.setStyle("-fx-background-image: url('Main/Stuff/blackX.png')");
                model.X_move(2,2);
                if (Evaluation.X_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player X winns");
                }
            }
            model.IncreaseMoveNumber();
            view.Btn9.setDisable(true);
            if (model.CheckTie()){
                System.out.println("its a tie.. no winner!");
            };
            System.out.println("you pressed button 9");
        });
    }


}
