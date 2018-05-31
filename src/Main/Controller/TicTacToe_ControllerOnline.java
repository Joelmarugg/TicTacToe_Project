package Main.Controller;

import Main.Controller.Network.Client;
import Main.Controller.Network.Server;
import Main.Model.Evaluation;
import Main.Model.Game;
import Main.Model.TicTacToe_ModelOnline;
import Main.View.TicTacToe_View;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.layout.Pane;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public class TicTacToe_ControllerOnline extends ChangeModus {

    public TicTacToe_View view;
    private TicTacToe_ModelOnline model;
    Client c;
    Server s;
    public boolean yourTurn = false;
    public char[] gameBoard = Game.getNewBoard();


    TicTacToe_ControllerOnline(TicTacToe_ModelOnline model, TicTacToe_View view){

        this.model = model;
        this.view = view;


        model.NewGame();
        model.ResetNumberOfMoves();
        ResetTextOfButtons(view);
        stopAnimation();
        ResetImageOfButtons(view);
        EnableAllButtons(view);
        model.setHostClient();
        if (model.isClient) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    c = new Client();
                    yourTurn=true;
                    //Server s = new Server();
                }
            };
            t.start();
        }else if (model.isHost){
            Thread t = new Thread() {
                @Override
                public void run() {
                    // Client c = new Client();
                    s = new Server(TicTacToe_ControllerOnline.this);
                    try {
                        s.connect();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();



        }
        Thread checkboard = new Thread() {
            public void run() {
                while (true) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (c != null) {
                        String s = c.communicate("getBoard");
                        for(int i =0; i< s.length();i++) {
                            if (s.toCharArray()[i] != '-') {
                                if(gameBoard[i]!=s.toCharArray()[i]){
                                    yourTurn=true;

                                    System.err.println("Activated Client. \nS: "+ s+" \nC:"+Arrays.toString(gameBoard));
                                }
                                gameBoard[i] = s.toCharArray()[i];
                                switch (i) {
                                    case 0:
                                        view.Btn1.setStyle("-fx-background-image: url('Main/Stuff/" + ((char) (s.toCharArray()[i])) + ".png')");
                                        view.Btn1.setDisable(true);
                                        if (((char)(gameBoard[i]))==('O')){
                                            model.O_move(0, 0);
                                        }else{
                                            model.X_move(0,0);
                                        }
                                        break;
                                    case 1:
                                        view.Btn2.setStyle("-fx-background-image: url('Main/Stuff/" + ((char) (s.toCharArray()[i])) + ".png')");
                                        view.Btn2.setDisable(true);
                                        if (((char)(gameBoard[i]))==('O')){
                                            model.O_move(0, 1);
                                        }else{
                                            model.X_move(0,1);
                                        }

                                        break;
                                    case 2:
                                        view.Btn3.setStyle("-fx-background-image: url('Main/Stuff/" + ((char) (s.toCharArray()[i])) + ".png')");
                                        view.Btn3.setDisable(true);
                                        if (((char)(gameBoard[i]))==('O')){
                                            model.O_move(0, 2);
                                        }else{
                                            model.X_move(0,2);
                                        }
                                        break;
                                    case 3:
                                        view.Btn4.setStyle("-fx-background-image: url('Main/Stuff/" + ((char) (s.toCharArray()[i])) + ".png')");
                                        view.Btn4.setDisable(true);
                                        if (((char)(gameBoard[i]))==('O')){
                                            model.O_move(1, 0);
                                        }else{
                                            model.X_move(1,0);
                                        }
                                        break;
                                    case 4:
                                        view.Btn5.setStyle("-fx-background-image: url('Main/Stuff/" + ((char) (s.toCharArray()[i])) + ".png')");
                                        view.Btn5.setDisable(true);
                                        if (((char)(gameBoard[i]))==('O')){
                                            model.O_move(1, 1);
                                        }else{
                                            model.X_move(1,1);
                                        }
                                        break;
                                    case 5:
                                        view.Btn6.setStyle("-fx-background-image: url('Main/Stuff/" + ((char) (s.toCharArray()[i])) + ".png')");
                                        view.Btn6.setDisable(true);
                                        if (((char)(gameBoard[i]))==('O')){
                                            model.O_move(1, 2);
                                        }else{
                                            model.X_move(1,2);
                                        }
                                        break;
                                    case 6:
                                        view.Btn7.setStyle("-fx-background-image: url('Main/Stuff/" + ((char) (s.toCharArray()[i])) + ".png')");
                                        view.Btn7.setDisable(true);
                                        if (((char)(gameBoard[i]))==('O')){
                                            model.O_move(2, 0);
                                        }else{
                                            model.X_move(2,0);
                                        }
                                        break;
                                    case 7:
                                        view.Btn8.setStyle("-fx-background-image: url('Main/Stuff/" + ((char) (s.toCharArray()[i])) + ".png')");
                                        view.Btn8.setDisable(true);
                                        if (((char)(gameBoard[i]))==('O')){
                                            model.O_move(2, 1);
                                        }else{
                                            model.X_move(2,1);
                                        }
                                        break;
                                    case 8:
                                        view.Btn9.setStyle("-fx-background-image: url('Main/Stuff/" + ((char) (s.toCharArray()[i])) + ".png')");
                                        view.Btn9.setDisable(true);
                                        if (((char)(gameBoard[i]))==('O')){
                                            model.O_move(2, 2);
                                        }else{
                                            model.X_move(2,2);
                                        }
                                        break;
                                }
                                System.out.println("Current board: " + Arrays.toString(gameBoard));

                            }
                        }
                    } else{
                        s.serverBoard = String.valueOf(gameBoard);
                    }


                }
            }
        };
        checkboard.start();


        System.out.println("you started a new game");


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



        view.Btn1.setOnAction((event) -> {


            if (model.isHost) {
                if (yourTurn) {
                    yourTurn=false;

                    model.O_move(0, 0);
                    view.Btn1.setStyle("-fx-background-image: url('Main/Stuff/O.png')");
                    s.serverBoard = String.valueOf(Game.getNewBoard());
                    gameBoard = model.getNewBoard();
                    view.Btn1.setDisable(true);

                    if (Evaluation.O_CheckForWinner()){
                        DisableAllButtons(view);
                        startOAnimation();
                        System.out.println("Player O winns");
                    }
                }else{
                    System.out.println("it's not your turn!");

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("It's Not Your Turn");


                    alert.show();

                }

            } else if (model.isClient) {
                if (yourTurn) {
                    yourTurn=false;
                    model.X_move(0, 0);
                    gameBoard = model.getNewBoard();
                    view.Btn1.setStyle("-fx-background-image: url('Main/Stuff/X.png')");
                    c.communicate("changeboard," + String.valueOf(gameBoard)+"c");
                    view.Btn1.setDisable(true);

                    if (Evaluation.X_CheckForWinner()){
                        DisableAllButtons(view);
                        startXAnimation();
                        System.out.println("Player X winns");
                    }
                }else{
                    System.out.println("it's not your turn!");

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("It's Not Your Turn");

                    alert.show();

                }

            }

            if (model.CheckTie()){
                System.out.println("its a tie.. no winner!");
            }


        });

        view.Btn2.setOnAction((event) -> {
            if (model.isHost) {
                if (yourTurn) {
                    yourTurn=false;

                    model.O_move(0, 1);
                view.Btn2.setStyle("-fx-background-image: url('Main/Stuff/O.png')");
                s.serverBoard = String.valueOf(model.getNewBoard());
                gameBoard =model.getNewBoard();
                view.Btn2.setDisable(true);
                if (Evaluation.O_CheckForWinner()){
                    DisableAllButtons(view);
                    startOAnimation();
                    System.out.println("Player O winns");
                }
            }else{
                System.out.println("it's not your turn!");

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning!");
                alert.setHeaderText("It's Not Your Turn");


                alert.show();

            }

            } else if (model.isClient) {
                if (yourTurn) {
                    yourTurn=false;

                    model.X_move(0, 1);
                gameBoard =model.getNewBoard();
                view.Btn2.setStyle("-fx-background-image: url('Main/Stuff/X.png')");
                c.communicate("changeboard," + String.valueOf(gameBoard)+"c");
                    view.Btn2.setDisable(true);

                    if (Evaluation.X_CheckForWinner()){
                        DisableAllButtons(view);
                        startXAnimation();
                        System.out.println("Player X winns");
                    }
                }else{
                    System.out.println("it's not your turn!");

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("It's Not Your Turn");

                    alert.show();

                }

            }

                    if (model.CheckTie()){
                        System.out.println("its a tie.. no winner!");
                    }




        });

        view.Btn3.setOnAction((event) -> {
            if (model.isHost) {
                if (yourTurn) {
                    yourTurn=false;

                    model.O_move(0, 2);
                view.Btn3.setStyle("-fx-background-image: url('Main/Stuff/O.png')");

                s.serverBoard = String.valueOf(Game.getNewBoard());
                gameBoard = model.getNewBoard();
                    view.Btn3.setDisable(true);
                    if (Evaluation.O_CheckForWinner()){
                        DisableAllButtons(view);
                        startOAnimation();
                        System.out.println("Player O winns");
                    }
                }else{
                    System.out.println("it's not your turn!");

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("It's Not Your Turn");


                    alert.show();

                }

            } else if (model.isClient) {
                    if (yourTurn) {
                        yourTurn=false;

                        model.X_move(0, 2);
                gameBoard =model.getNewBoard();
                view.Btn3.setStyle("-fx-background-image: url('Main/Stuff/X.png')");

                c.communicate("changeboard," + String.valueOf(gameBoard)+"c");
                        view.Btn3.setDisable(true);

                        if (Evaluation.X_CheckForWinner()){
                            DisableAllButtons(view);
                            startXAnimation();
                            System.out.println("Player X winns");
                        }
                    }else{
                        System.out.println("it's not your turn!");

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning!");
                        alert.setHeaderText("It's Not Your Turn");

                        alert.show();

                    }

            }

            if (model.CheckTie()){
                System.out.println("its a tie.. no winner!");
            }
        });

        view.Btn4.setOnAction((event) -> {
            if (model.isHost) {
                if (yourTurn) {
                    yourTurn=false;

                    model.O_move(1, 0);
                view.Btn4.setStyle("-fx-background-image: url('Main/Stuff/O.png')");

                s.serverBoard = String.valueOf(Game.getNewBoard());
                gameBoard = model.getNewBoard();
                    view.Btn4.setDisable(true);

                    if (Evaluation.O_CheckForWinner()){
                        DisableAllButtons(view);
                        startOAnimation();
                        System.out.println("Player O winns");
                    }
                }else{
                    System.out.println("it's not your turn!");

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("It's Not Your Turn");


                    alert.show();

                }

            } else if (model.isClient) {
                    if (yourTurn) {
                model.X_move(1, 0);
                gameBoard =model.getNewBoard();
                view.Btn4.setStyle("-fx-background-image: url('Main/Stuff/X.png')");

                c.communicate("changeboard," + String.valueOf(gameBoard)+"c");
                        view.Btn4.setDisable(true);
                        yourTurn=false;

                        if (Evaluation.X_CheckForWinner()){
                            DisableAllButtons(view);
                            startXAnimation();
                            System.out.println("Player X winns");
                        }
                    }else{
                        System.out.println("it's not your turn!");

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning!");
                        alert.setHeaderText("It's Not Your Turn");

                        alert.show();

                    }

            }

            if (model.CheckTie()){
                System.out.println("its a tie.. no winner!");
            }
        });

        view.Btn5.setOnAction((event) -> {
            if (model.isHost) {
                if (yourTurn) {
                model.O_move(1, 1);
                view.Btn5.setStyle("-fx-background-image: url('Main/Stuff/O.png')");

                s.serverBoard = String.valueOf(Game.getNewBoard());
                gameBoard = model.getNewBoard();
                    view.Btn5.setDisable(true);
                    yourTurn=false;
                    if (Evaluation.O_CheckForWinner()){
                        DisableAllButtons(view);
                        startOAnimation();
                        System.out.println("Player O winns");
                    }
                }else{
                    System.out.println("it's not your turn!");

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("It's Not Your Turn");


                    alert.show();

                }

            } else if (model.isClient) {
                    if (yourTurn) {
                    model.X_move(1, 1);
                gameBoard =model.getNewBoard();
                view.Btn5.setStyle("-fx-background-image: url('Main/Stuff/X.png')");

                c.communicate("changeboard," + String.valueOf(gameBoard)+"c");
                        view.Btn5.setDisable(true);
                        yourTurn=false;

                        if (Evaluation.X_CheckForWinner()){
                            DisableAllButtons(view);
                            startXAnimation();
                            System.out.println("Player X winns");
                        }
                    }else{
                        System.out.println("it's not your turn!");

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning!");
                        alert.setHeaderText("It's Not Your Turn");

                        alert.show();

                    }

            }

            if (model.CheckTie()){
                System.out.println("its a tie.. no winner!");
            }
        });

        view.Btn6.setOnAction((event) -> {
            if (model.isHost) {
                if (yourTurn) {
                model.O_move(1, 2);
                view.Btn6.setStyle("-fx-background-image: url('Main/Stuff/O.png')");

                s.serverBoard = String.valueOf(Game.getNewBoard());
                gameBoard = model.getNewBoard();
                    view.Btn6.setDisable(true);
                    yourTurn=false;
                    if (Evaluation.O_CheckForWinner()){
                        DisableAllButtons(view);
                        startOAnimation();
                        System.out.println("Player O winns");
                    }
                }else{
                    System.out.println("it's not your turn!");

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("It's Not Your Turn");


                    alert.show();

                }

            } else if (model.isClient) {
                    if (yourTurn) {
                    model.X_move(1, 2);
                gameBoard =model.getNewBoard();
                view.Btn6.setStyle("-fx-background-image: url('Main/Stuff/X.png')");

                c.communicate("changeboard," + String.valueOf(gameBoard)+"c");
                        view.Btn6.setDisable(true);
                        yourTurn=false;

                        if (Evaluation.X_CheckForWinner()){
                            DisableAllButtons(view);
                            startXAnimation();
                            System.out.println("Player X winns");
                        }
                    }else{
                        System.out.println("it's not your turn!");

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning!");
                        alert.setHeaderText("It's Not Your Turn");

                        alert.show();

                    }

            }
            if (model.CheckTie()){
                System.out.println("its a tie.. no winner!");
            }
        });

        view.Btn7.setOnAction((event) -> {
            if (model.isHost) {
                if (yourTurn) {
                model.O_move(2, 0);
                view.Btn7.setStyle("-fx-background-image: url('Main/Stuff/O.png')");

                s.serverBoard = String.valueOf(Game.getNewBoard());
                gameBoard = model.getNewBoard();
                    view.Btn7.setDisable(true);
                    yourTurn=false;
                    if (Evaluation.O_CheckForWinner()){
                        DisableAllButtons(view);
                        startOAnimation();
                        System.out.println("Player O winns");
                    }
                }else{
                    System.out.println("it's not your turn!");

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("It's Not Your Turn");


                    alert.show();

                }

            } else if (model.isClient) {
                    if (yourTurn) {
                    model.X_move(2, 0);
                gameBoard =model.getNewBoard();
                view.Btn7.setStyle("-fx-background-image: url('Main/Stuff/X.png')");

                c.communicate("changeboard," + String.valueOf(gameBoard)+"c");
                        view.Btn7.setDisable(true);
                        yourTurn=false;

                        if (Evaluation.X_CheckForWinner()){
                            DisableAllButtons(view);
                            startXAnimation();
                            System.out.println("Player X winns");
                        }
                    }else{
                        System.out.println("it's not your turn!");

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning!");
                        alert.setHeaderText("It's Not Your Turn");

                        alert.show();

                    }

            }

            if (model.CheckTie()){
                System.out.println("its a tie.. no winner!");
            }
        });

        view.Btn8.setOnAction((event) -> {
            if (model.isHost) {
                if (yourTurn) {
                    model.O_move(2, 1);
                    view.Btn8.setStyle("-fx-background-image: url('Main/Stuff/O.png')");

                    s.serverBoard = String.valueOf(Game.getNewBoard());
                    gameBoard = model.getNewBoard();
                    view.Btn8.setDisable(true);
                    yourTurn=false;
                    if (Evaluation.O_CheckForWinner()) {
                        DisableAllButtons(view);
                        startOAnimation();
                        System.out.println("Player O winns");
                    }
                } else {
                    System.out.println("it's not your turn!");

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("It's Not Your Turn");


                    alert.show();

                }

            } else if (model.isClient) {
                if (yourTurn) {
                    model.X_move(2, 1);

                    gameBoard = model.getNewBoard();
                    view.Btn8.setStyle("-fx-background-image: url('Main/Stuff/X.png')");

                    c.communicate("changeboard," + String.valueOf(gameBoard)+"c");
                    view.Btn8.setDisable(true);
                    yourTurn = false;
                    if (Evaluation.X_CheckForWinner()) {
                        DisableAllButtons(view);
                        startXAnimation();
                        System.out.println("Player X winns");
                    }

                } else {
                    System.out.println("it's not your turn!");

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("It's Not Your Turn");

                    alert.show();

                }

            }

            if (model.CheckTie()) {
                System.out.println("its a tie.. no winner!");
            }
        });

        view.Btn9.setOnAction((event) -> {
            if (model.isHost) {
                if (yourTurn) {
                    yourTurn=false;

                    model.O_move(2, 2);
                view.Btn9.setStyle("-fx-background-image: url('Main/Stuff/O.png')");

                s.serverBoard = String.valueOf(Game.getNewBoard());
                gameBoard = model.getNewBoard();
                    view.Btn9.setDisable(true);
                    if (Evaluation.O_CheckForWinner()){
                        DisableAllButtons(view);
                        startOAnimation();
                        System.out.println("Player O winns");
                    }
                }else{
                    System.out.println("it's not your turn!");

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("It's Not Your Turn");


                    alert.show();

                }

            } else if (model.isClient) {
                    if (yourTurn) {
                    model.X_move(2, 2);
                gameBoard =model.getNewBoard();
                view.Btn9.setStyle("-fx-background-image: url('Main/Stuff/X.png')");

                c.communicate("changeboard," + String.valueOf(gameBoard)+"c");
                        view.Btn9.setDisable(true);
                        yourTurn=false;

                        if (Evaluation.X_CheckForWinner()){
                            DisableAllButtons(view);
                            startXAnimation();
                            System.out.println("Player X winns");
                        }
                    }else{
                        System.out.println("it's not your turn!");

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning!");
                        alert.setHeaderText("It's Not Your Turn");

                        alert.show();

                    }

            }
        if (model.CheckTie()){
            System.out.println("its a tie.. no winner!");
        }
        });


        view.New_Game_Btn.setOnAction((event) -> {
           //Exit the game
        });

    }
}
