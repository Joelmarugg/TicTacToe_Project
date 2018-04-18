package Main.Model;

import Main.View.TicTacToe_View;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import javax.swing.*;

public class TicTacToe_ModelAI extends Game {

    private TicTacToe_View view;
    public int row;
    public int column;
    public boolean isBeginner = false;




    public TicTacToe_ModelAI(TicTacToe_View view, int level) {
        super();
        this.view = view;
        this.level = level;
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

        private void AIMove () {

            if (level == 1) {
                char [] board = getNewBoard();

                int num = minimax(board, player);


                if (GoTo == 0) {
                    X_move(0, 0);
                } else if (GoTo == 1) {
                    X_move(0, 1);
                } else if (GoTo == 2) {
                    X_move(0, 2);
                } else if (GoTo == 3) {
                    X_move(1, 0);
                } else if (GoTo == 4) {
                    X_move(1, 1);
                } else if (GoTo == 5) {
                    X_move(1, 2);
                } else if (GoTo == 6) {
                    X_move(2, 0);
                } else if (GoTo == 7) {
                    X_move(2, 1);
                } else if (GoTo == 8) {
                    X_move(2, 2);
                }
                IncreaseMoveNumber();

                if (Evaluation.X_CheckForWinner()){
                    Winner = true;
                    System.out.println("Player X winns");
                }
                if(CheckTie()){
                    System.out.println("It's a tie... Of course... ;)");
                }

            } else if (level == 2) {
                char [] board = getNewBoard();

                int num = minimax(board, player);


                if (GoTo == 0) {
                    X_move(0, 0);
                } else if (GoTo == 1) {
                    X_move(0, 1);
                } else if (GoTo == 2) {
                    X_move(0, 2);
                } else if (GoTo == 3) {
                    X_move(1, 0);
                } else if (GoTo == 4) {
                    X_move(1, 1);
                } else if (GoTo == 5) {
                    X_move(1, 2);
                } else if (GoTo == 6) {
                    X_move(2, 0);
                } else if (GoTo == 7) {
                    X_move(2, 1);
                } else if (GoTo == 8) {
                    X_move(2, 2);
                }
                IncreaseMoveNumber();

                if (Evaluation.X_CheckForWinner()){
                    Winner = true;
                    System.out.println("Player X winns");
                }
                if(CheckTie()){
                    System.out.println("It's a tie... Of course... ;)");
                }

            }else if (level == 3) {

                //char[] board = {'O', '-', 'X', 'X', '-', 'X', '-', 'O', 'O'};

                char [] board = getNewBoard();

                int num = minimax(board, player);


                if (GoTo == 0) {
                    X_move(0, 0);
                } else if (GoTo == 1) {
                    X_move(0, 1);
                } else if (GoTo == 2) {
                    X_move(0, 2);
                } else if (GoTo == 3) {
                    X_move(1, 0);
                } else if (GoTo == 4) {
                    X_move(1, 1);
                } else if (GoTo == 5) {
                    X_move(1, 2);
                } else if (GoTo == 6) {
                    X_move(2, 0);
                } else if (GoTo == 7) {
                    X_move(2, 1);
                } else if (GoTo == 8) {
                    X_move(2, 2);
                }
                IncreaseMoveNumber();

                if (Evaluation.X_CheckForWinner()){
                    Winner = true;
                    System.out.println("Player X winns");
                }
                if(CheckTie()){
                 System.out.println("It's a tie... Of course... ;)");
                }

            }
        }


        public void setBeginner () {
            int eingabe = JOptionPane.showConfirmDialog(null,
                    "Do you want to have the first turn?",
                    "First Turn",
                    JOptionPane.YES_NO_OPTION);
            if (eingabe == 1) {
                NumberOfMoves = 2;//No
                System.out.println("Computer's turn..");
                isBeginner=true;
                depth = 0;

                AIMove();
            } else {
                NumberOfMoves = 1;//Yes
                System.out.println("Your turn..");
                isBeginner=false;
                depth = 1;

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
