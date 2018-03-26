package View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TicTacToe_View {

     public boolean Online_1v1 = false;
     public boolean Offline_1v1 = true;
     public boolean AI = false;
     public Button Btn1; public Button Btn2; public Button Btn3;
     public Button Btn4; public Button Btn5; public Button Btn6;
     public Button Btn7; public Button Btn8; public Button Btn9;
     public Button New_Game_Btn;
     public Button Play_Btn;
     public GridPane GameGrid;
     public Menu ModusMenu;



    public TicTacToe_View(Stage PrimaryStage){


        BorderPane root = new BorderPane();

////////////////////////////////GameGrid/////////////////////////////////////
        //GameGrid to play
        GameGrid = new GridPane();
        GameGrid.setStyle("-fx-grid-lines-visible: true");

        //Set the Row/ColumnConstraints
        for (int i = 0 ; i < 3; i++) {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.ALWAYS);
            GameGrid.getRowConstraints().add(row);
        }

        for (int j = 0 ; j < 3; j++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setHgrow(Priority.ALWAYS);
            GameGrid.getColumnConstraints().add(col);
        }

        //Create 9 Buttons
        Btn1 = new Button();Btn2 = new Button();Btn3 = new Button();
        Btn4 = new Button();Btn5 = new Button();Btn6 = new Button();
        Btn7 = new Button();Btn8 = new Button();Btn9 = new Button();

        // Make Button fill out the grid
        Btn1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Btn2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Btn3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Btn4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Btn5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Btn6.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Btn7.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Btn8.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Btn9.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        // Add Buttons to the grid
        GameGrid.add(Btn1,0,0);GameGrid.add(Btn2,1,0);GameGrid.add(Btn3,2,0);
        GameGrid.add(Btn4,0,1);GameGrid.add(Btn5,1,1);GameGrid.add(Btn6,2,1);
        GameGrid.add(Btn7,0,2);GameGrid.add(Btn8,1,2);GameGrid.add(Btn9,2,2);


/////////////////////////////////ControlArea////////////////////////////////////////////////////////
        //Hbox for ControlArea
        HBox ControlArea = new HBox();
        ControlArea.setAlignment(Pos.CENTER);
        ControlArea.setPrefSize(1000, 60);
        ControlArea.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(10))));

        // VBox for Let's Play! button
        VBox Play_Btn_Box = new VBox();
        Play_Btn_Box.setAlignment(Pos.CENTER);
        Play_Btn_Box.prefWidthProperty().bind(ControlArea.widthProperty());
        Play_Btn = new Button("Let's Play!");
        Play_Btn_Box.getChildren().add(Play_Btn);

        // VBox for New Game button
        VBox New_Game_Box = new VBox();
        New_Game_Box.setAlignment(Pos.CENTER);
        New_Game_Box.prefWidthProperty().bind(ControlArea.widthProperty());
        New_Game_Btn = new Button("New Game");
        New_Game_Box.getChildren().add(New_Game_Btn);

        // VBox for Round Counter label
        VBox Round_Counter_Box = new VBox();
        Round_Counter_Box.setAlignment(Pos.CENTER_LEFT);
        Round_Counter_Box.prefWidthProperty().bind(ControlArea.widthProperty());
        Round_Counter_Box.setAlignment(Pos.CENTER);
        Label Round_Counter_Text = new Label("Round x");
        //TODO in CSS Round_Counter_Text.setFont(Font.font("tahoma", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Round_Counter_Box.getChildren().add(Round_Counter_Text);


        ControlArea.getChildren().add(Round_Counter_Box);
        ControlArea.getChildren().add(Play_Btn_Box);
        ControlArea.getChildren().add(New_Game_Box);

//////////////////////////////////MenuBar/////////////////////////////////////////////
        // MenuBar for options and help
        MenuBar MenuBar = new MenuBar();

        // HelpMenu for game description
        ModusMenu = new Menu("Modus", null,
                new MenuItem("Offline 1 Vs. 1"),
                new MenuItem("Online 1 Vs. 1"),
                new Menu("1 Vs. AI", null,
                         new MenuItem("Easy"),
                         new MenuItem("Medium"),
                         new MenuItem("Hard")));


        // HelpMenu for game description
        Menu HelpMenu = new Menu("Help",null,
                new MenuItem("How to play?"));

        // OptionsMenu for different settings
        Menu OptionsMenu = new Menu("Options");
        Menu ThemeMenu = new Menu("Theme", null,
                new MenuItem("Sky"),
                new MenuItem("Fire"),
                new MenuItem("Dogs"),
                new MenuItem("Dark"));
        OptionsMenu.getItems().add(ThemeMenu);


        MenuBar.getMenus().add(HelpMenu);
        MenuBar.getMenus().add(OptionsMenu);
        MenuBar.getMenus().add(ModusMenu);


        root.setTop(MenuBar);
        root.setCenter(GameGrid);
        root.setBottom(ControlArea);








        Scene scene = new Scene(root, 800, 800);
        PrimaryStage.setTitle("Tic Tac Toe");
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }
}
