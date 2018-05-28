package Main.Controller;

import Main.Controller.Network.Client;
import Main.Controller.Network.Server;
import Main.Model.Game;
import Main.Model.TicTacToe_ModelOnline;
import Main.View.TicTacToe_View;
import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class TicTacToe_ControllerOnline extends ChangeModus {

    private TicTacToe_View view;
    private TicTacToe_ModelOnline model;
    Client c;
    Server s;
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
                        for(int i =0; i< s.length();i++){
                            gameBoard[i]= s.toCharArray()[i];

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
                model.O_move(0, 0);
                view.Btn1.setStyle("-fx-background-image: url('Main/Stuff/O.png')");
                s.serverBoard = String.valueOf(Game.getNewBoard());
                gameBoard =model.getNewBoard();

            } else if (model.isClient) {
                model.X_move(0, 0);
                view.Btn1.setStyle("-fx-background-image: url('Main/Stuff/X.png')");
                c.communicate("changeboard," + String.valueOf(Game.getNewBoard()));

            }

            view.Btn1.setDisable(true);
        });

        view.Btn2.setOnAction((event) -> {
            if (model.isHost) {
                model.O_move(0, 1);
                view.Btn2.setStyle("-fx-background-image: url('Main/Stuff/O.png')");

                s.serverBoard = String.valueOf(model.getNewBoard());
                gameBoard =model.getNewBoard();

            } else if (model.isClient) {
                model.X_move(0, 1);
                view.Btn2.setStyle("-fx-background-image: url('Main/Stuff/X.png')");
                c.communicate("changeboard," + String.valueOf(Game.getNewBoard()));

            }

            view.Btn2.setDisable(true);


        });

        view.Btn3.setOnAction((event) -> {
            if (model.isHost) {
                model.O_move(0, 2);
                view.Btn3.setStyle("-fx-background-image: url('Main/Stuff/O.png')");

                s.serverBoard = String.valueOf(Game.getNewBoard());
                gameBoard = model.getNewBoard();

            } else if (model.isClient) {
                model.X_move(0, 2);
                view.Btn3.setStyle("-fx-background-image: url('Main/Stuff/X.png')");

                c.communicate("changeboard," + String.valueOf(Game.getNewBoard()));

            }

            view.Btn3.setDisable(true);
        });

        view.New_Game_Btn.setOnAction((event) -> {
            model.NewGame();
            System.out.println("you started a new game");
            ResetTextOfButtons(view);
            ResetImageOfButtons(view);
            stopAnimation();
            EnableAllButtons(view);
            model.setHostClient();
            if (model.isClient) {
                Thread t = new Thread() {
                    @Override
                    public void run() {
                        c = new Client();
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
                    }
                };
                t.start();
            }

        });

        //checkboard.start();

    }
}
