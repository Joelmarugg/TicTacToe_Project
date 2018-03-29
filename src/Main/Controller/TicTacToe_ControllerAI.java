package Main.Controller;

import Main.Model.Evaluation;
import Main.Model.TicTacToe_ModelAI;
import Main.View.TicTacToe_View;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;

public class TicTacToe_ControllerAI extends ChangeModus {

    TicTacToe_View view;
    TicTacToe_ModelAI model;
    public int level;

    public TicTacToe_ControllerAI(TicTacToe_ModelAI model, TicTacToe_View view, int level){

        this.model = model;
        this.view = view;
        this.level = level;

        DisableAllButtons(view);

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

                view.Btn1.setText("O");
                model.O_move(0,0);
                if (Evaluation.O_CheckForWinner()){
                     DisableAllButtons(view);
                     System.out.println("Player O winns");
                }
                model.IncreaseMoveNumber();
                view.Btn1.setDisable(true);
                if (model.CheckTie()){
                    System.out.println("its a tie.. no winner!");
                };
                System.out.println("you pressed button 1");
                ((Button)(model.getNodeByRowColumnIndex(model.row,model.column,view.GameGrid))).setText("X");

            });

            view.Btn2.setOnAction((event) -> {

                view.Btn2.setText("O");
                model.O_move(0,1);
                if (Evaluation.O_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player O winns");
                }
                model.IncreaseMoveNumber();
                view.Btn2.setDisable(true);
                if (model.CheckTie()){
                    System.out.println("its a tie.. no winner!");
                };
                System.out.println("you pressed button 2");
                ((Button)(model.getNodeByRowColumnIndex(model.row,model.column,view.GameGrid))).setText("X");

            });

            view.Btn3.setOnAction((event) -> {

                view.Btn3.setText("O");
                model.O_move(0,2);
                if (Evaluation.O_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player O winns");
                }
                model.IncreaseMoveNumber();
                view.Btn3.setDisable(true);
                if (model.CheckTie()){
                    System.out.println("its a tie.. no winner!");
                };
                System.out.println("you pressed button 3");
                ((Button)(model.getNodeByRowColumnIndex(model.row,model.column,view.GameGrid))).setText("X");

            });

            view.Btn4.setOnAction((event) -> {

                view.Btn4.setText("O");
                model.O_move(1,0);
                if (Evaluation.O_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player O winns");
                }
                model.IncreaseMoveNumber();
                view.Btn4.setDisable(true);
                if (model.CheckTie()){
                    System.out.println("its a tie.. no winner!");
                };
                System.out.println("you pressed button 4");
                ((Button)(model.getNodeByRowColumnIndex(model.row,model.column,view.GameGrid))).setText("X");

            });

            view.Btn5.setOnAction((event) -> {

                view.Btn5.setText("O");
                model.O_move(1,1);
                if (Evaluation.O_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player O winns");
                }
                model.IncreaseMoveNumber();
                view.Btn5.setDisable(true);
                if (model.CheckTie()){
                    System.out.println("its a tie.. no winner!");
                };
                System.out.println("you pressed button 5");
                ((Button)(model.getNodeByRowColumnIndex(model.row,model.column,view.GameGrid))).setText("X");

            });

            view.Btn6.setOnAction((event) -> {

                view.Btn6.setText("O");
                model.O_move(1,2);
                if (Evaluation.O_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player O winns");
                }
                model.IncreaseMoveNumber();
                view.Btn6.setDisable(true);
                if (model.CheckTie()){
                    System.out.println("its a tie.. no winner!");
                };
                System.out.println("you pressed button 6");
                ((Button)(model.getNodeByRowColumnIndex(model.row,model.column,view.GameGrid))).setText("X");

            });

            view.Btn7.setOnAction((event) -> {

                view.Btn7.setText("O");
                model.O_move(2,0);
                if (Evaluation.O_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player O winns");
                }
                model.IncreaseMoveNumber();
                view.Btn7.setDisable(true);
                if (model.CheckTie()){
                    System.out.println("its a tie.. no winner!");
                };
                System.out.println("you pressed button 7");
                ((Button)(model.getNodeByRowColumnIndex(model.row,model.column,view.GameGrid))).setText("X");

            });

            view.Btn8.setOnAction((event) -> {

                view.Btn8.setText("O");
                model.O_move(2,1);
                if (Evaluation.O_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player O winns");
                }
                model.IncreaseMoveNumber();
                view.Btn8.setDisable(true);
                if (model.CheckTie()){
                    System.out.println("its a tie.. no winner!");
                };
                System.out.println("you pressed button 8");
                ((Button)(model.getNodeByRowColumnIndex(model.row,model.column,view.GameGrid))).setText("X");

            });

            view.Btn9.setOnAction((event) -> {

                view.Btn9.setText("O");
                model.O_move(2,2);
                if (Evaluation.O_CheckForWinner()){
                    DisableAllButtons(view);
                    System.out.println("Player O winns");
                }
                model.IncreaseMoveNumber();
                view.Btn9.setDisable(true);
                if (model.CheckTie()){
                    System.out.println("its a tie.. no winner!");
                };
                System.out.println("you pressed button 9");
                ((Button)(model.getNodeByRowColumnIndex(model.row,model.column,view.GameGrid))).setText("X");

            });

            view.New_Game_Btn.setOnAction((event) -> {
                model.NewGame();
                System.out.println("you started a new game");
                ResetTextOfButtons(view);
                EnableAllButtons(view);
                model.setBeginner();
                if(model.isBeginner==true)
                    ((Button)(model.getNodeByRowColumnIndex(model.row,model.column,view.GameGrid))).setText("X");

            });

            view.Play_Btn.setOnAction((event) -> {

            });


        }
    }

    public int getLevel(){
        return level;
    }


}
