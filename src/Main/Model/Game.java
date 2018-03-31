package Main.Model;

import java.util.ArrayList;

public class Game {

    public static char[][] PlayBoard = new char[3][3];
    public int NumberOfMoves = 1;
    public char player = 'X';
    public int depth = 0;


    public int SpotsAvailable;



    public void NewGame() {

        for (int i = 0; i < PlayBoard.length; i++) {
            for (int j = 0; j < PlayBoard[i].length; j++) {
                PlayBoard[i][j] = '-';
            }
        }

        for (char[] a : PlayBoard) {
            for (char i : a) {
                System.out.print(i + "\t");
            }
            System.out.println("\n");
        }

    }

    public void X_move(int row, int col) {

        PlayBoard[row][col] = 'X';


        for (char[] a : PlayBoard) {
            for (char i : a) {
                System.out.print(i + "\t");
            }
            System.out.println("\n");
        }


    }

    public void O_move(int row, int col) {

        PlayBoard[row][col] = 'O';


        for (char[] a : PlayBoard) {
            for (char i : a) {
                System.out.print(i + "\t");
            }
            System.out.println("\n");
        }
    }


    public static char[] getNewBoard( ) {
        char[] NewBoard = new char[9];
        int count = 0;
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++,count++) {
                if (PlayBoard[i][j] == '-'){
                    NewBoard[count] = '-';
                }else if(PlayBoard[i][j] == 'X'){
                    NewBoard[count] = 'X';
                }else if(PlayBoard[i][j] == 'O') {
                    NewBoard[count] = 'O';
                }

            }

        }

        return NewBoard;
    }

    public boolean CheckTie(){
        if(NumberOfMoves >= 10 && !Evaluation.O_CheckForWinner() && !Evaluation.X_CheckForWinner()) {
            return true;
        }else {
            return false;
        }
    }

    public int minimax(char[] newPlayBoard, char player){


        char AiPlayer = 'X';
        char HuPlayer = 'O';
        depth++;


        //checks how many spots are free
        int count = 0;
        for(int i = 0; i < getNewBoard().length; i++){
            if( newPlayBoard[i] == '-'){
                count++;
            }
        }
        SpotsAvailable = count;

        //checks for end points
        if(Evaluation.AI_CheckForWinner(newPlayBoard,HuPlayer)){
            return -10;
        }else if (Evaluation.AI_CheckForWinner(newPlayBoard,AiPlayer)){
            return +10;
        }else if (SpotsAvailable == 0){
            return 0;
        }

        int[] moves = new int[9];


        int c = 0;
        for (int i = 0; i < getNewBoard().length; i++) {

            if (newPlayBoard[i] == '-') {
                //System.out.println("trying at pos. " + (EmptySpots(newPlayBoard)[0]) + " at the depth of " + depth);
                newPlayBoard[i] = (char) player;


                int move = 0;

                if (player == AiPlayer) {
                    int result = minimax(newPlayBoard, HuPlayer);
                    move += result;
                } else {
                    int result = minimax(newPlayBoard, AiPlayer);
                    move += result;
                }
                newPlayBoard[i] = '-';
                SpotsAvailable++;

                moves[c] = move;
                c++;
            }
        }


        int BestMove = 0;

        if(player == AiPlayer){
            int BestScore = -10000;
            for(int i = 0; i < moves.length; i++){
                if(moves[i] > BestScore){
                    BestScore = moves[i];
                    BestMove = i;
                }
            }
        }else {
            int BestScore = 10000;
            for (int i = 0; i < moves.length; i++) {
                if (moves[i] < BestScore) {
                    BestScore = moves[i];
                    BestMove = i;

                }
            }
        }
        return EmptySpots(getNewBoard())[BestMove];

    }

    public int[] EmptySpots(char[] board){

        int[] ES = new int[SpotsAvailable];
        int c = 0;
        for (int i = 0; i < getNewBoard().length; i++) {
            if (board[i] == '-') {
                ES[c] = i;
                c++;
            }
        }

        return ES;
    }

    public void IncreaseMoveNumber() {
        NumberOfMoves++;
    }

    public int getNumberOfMoves() {
        System.out.println("this was the " + NumberOfMoves + " move");
        return NumberOfMoves;
    }

    public void ResetNumberOfMoves() {
        NumberOfMoves = 1;
    }


}
