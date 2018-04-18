package Main;

import Main.Controller.TicTacToe_ControllerOffline;
import Main.Model.TicTacToe_ModelOffline;
import Main.View.TicTacToe_View;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{



    private TicTacToe_ModelOffline modelOffline;
    private TicTacToe_View view;
    private TicTacToe_ControllerOffline controllerOffline;



    public static void main (String[] args){
        launch(args);

    }

    @Override
    public void start (Stage PrimaryStage){



         modelOffline = new TicTacToe_ModelOffline();
         view = new TicTacToe_View(PrimaryStage, "Grass.css");
         controllerOffline = new TicTacToe_ControllerOffline(modelOffline,view);
    }

}
