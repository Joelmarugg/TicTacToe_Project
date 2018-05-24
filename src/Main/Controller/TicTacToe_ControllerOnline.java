package Main.Controller;

import Main.Controller.Network.Client;
import Main.Controller.Network.Server;
import Main.Model.Game;
import Main.Model.TicTacToe_ModelOnline;
import Main.View.TicTacToe_View;
import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.layout.Pane;

class TicTacToe_ControllerOnline extends ChangeModus {

    private TicTacToe_View view;
    private TicTacToe_ModelOnline model;
    Client c;
    Server s;

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
                    s = new Server();
                }
            };
            t.start();
        }
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

            if (model.turn) {
                if(model.isHost){
                    model.O_move(0,0);
                    //c.getNewBoard();
                }else if (model.isClient){
                    model.X_move(0,0);
                    c.sendTurn();
                }
            }else{
                System.out.println("its not your turn");
            }

        });

        view.Btn2.setOnAction((event) -> {
            char[] board = Game.getNewBoard();
            String message = String.valueOf(board);
            System.out.println(message);


        });

        view.Btn3.setOnAction((event) -> {
            if(c!=null)
            c.sendTurn();
            else
            s.sendTurn();
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
                        s = new Server();
                    }
                };
                t.start();
            }

        });

    }
}
