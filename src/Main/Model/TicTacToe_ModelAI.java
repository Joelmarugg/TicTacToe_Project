package Main.Model;

import Main.Controller.TicTacToe_ControllerAI;
import Main.Main;
import Main.View.TicTacToe_View;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.util.Random;

public class TicTacToe_ModelAI extends Game {

    public TicTacToe_View view;
    public int row;
    public int column;
    public boolean isBeginner = false;


    public TicTacToe_ModelAI(TicTacToe_View view) {
        super();
        this.view = view;


    }

        @Override
        public void O_move ( int row, int col){
            super.O_move(row, col);
            AIMove();
        }

        @Override
        public void X_move ( int row, int col){
            super.X_move(row, col);
            this.row = row;
            this.column = col;
            //((Button) (getNodeByRowColumnIndex(row,col,view.GameGrid))).setText("X"); TODO why is this not working??
        }

        public void AIMove () {

        //TOdo if(getLevel() == 1){
            Random random = new Random();
            int r = random.nextInt(4) + 1;

            if (r == 1) {
                X_move(2, 1);
                System.out.println("Computer moves to " + r);
            } else if (r == 2) {
                X_move(2, 2);
                System.out.println("Computer moves to " + r);
            } else if (r == 3) {
                X_move(2, 0);
                System.out.println("Computer moves to " + r);
            } else if (r == 4) {
                X_move(2, 2);
                System.out.println("Computer moves to " + r);
            }

        /* TODO }else if(controllerAI.getLevel() == 2){
            X_move(1,1);

        }else if(controllerAI.getLevel() == 3){
            X_move(1,1);
        }*/


        }


        public void setBeginner () {
            int eingabe = JOptionPane.showConfirmDialog(null,
                    "Do you want to have the first turn?",
                    "First Turn",
                    JOptionPane.YES_NO_OPTION);
            if (eingabe == 1) {
                NumberOfMoves = 2;//No
                System.out.println("Computer's turn..");
                AIMove();
                isBeginner=true;
            } else {
                NumberOfMoves = 1;//Yes
                System.out.println("Your turn..");
                isBeginner=false;
            }
            System.out.println(eingabe);
            System.out.println(NumberOfMoves);

        }

        public Node getNodeByRowColumnIndex ( final int row, final int column, GridPane GameGrid){
            Node result = null;
            ObservableList<Node> childrens = GameGrid.getChildren();

            for (Node node : childrens) {
                if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {

                    System.out.println("row: " + GridPane.getRowIndex(node));
                    System.out.println("column: " + GridPane.getColumnIndex(node));
                    result = node;
                    break;
                }
            }
            return result;
        }


    }
