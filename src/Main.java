import Controller.TicTacToe_ControllerOffline;
import Controller.TicTacToe_ControllerAI;
import Controller.TicTacToe_ControllerOnline;
import Model.TicTacToe_ModelAI;
import Model.TicTacToe_ModelOffline;
import Model.TicTacToe_ModelOnline;
import View.TicTacToe_View;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{


    TicTacToe_ModelOnline modelOnline;
    TicTacToe_ModelOffline modelOffline;
    TicTacToe_ModelAI modelAI;

    TicTacToe_View view;

    TicTacToe_ControllerOnline controllerOnline;
    TicTacToe_ControllerOffline controllerOffline;
    TicTacToe_ControllerAI controllerAI;

    public static void main (String[] args){
        launch(args);

    }

    @Override
    public void start (Stage PrimaryStage){


        /*if (view.Online_1v1){
            modelOnline = new TicTacToe_ModelOnline();
            view = new TicTacToe_View(PrimaryStage);
            controllerOnline = new TicTacToe_ControllerOnline(modelOnline, view);
        }else if(view.Offline_1v1){
           */ modelOffline = new TicTacToe_ModelOffline();
            view = new TicTacToe_View(PrimaryStage);
            controllerOffline = new TicTacToe_ControllerOffline(modelOffline,view);
        /*}else if (view.AI){
            modelAI = new TicTacToe_ModelAI();
            view = new TicTacToe_View(PrimaryStage);
            controllerAI = new TicTacToe_ControllerAI(modelAI,view);
        }*/
    }



}
