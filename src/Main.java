import View.TicTacToe_View;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{


    TicTacToe_View view;

    public static void main (String[] args){
        launch(args);

    }

    @Override
    public void start (Stage PrimaryStage){
        //model = new TicTacToe_Model();
        view = new TicTacToe_View(PrimaryStage);
        //controller = TicTacToe_Controller();
    }



}
