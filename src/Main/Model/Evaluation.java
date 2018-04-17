package Main.Model;

import Main.Controller.ChangeModus;

public class Evaluation extends Game {

    private static int winnerLine;
    

    public static boolean X_CheckForWinner() {
        if (PlayBoard[0][0] == 'X' && PlayBoard[0][1] == 'X' && PlayBoard[0][2] == 'X') {
            setWinnerLine(1);
            return true;
        } else if (PlayBoard[1][0] == 'X' && PlayBoard[1][1] == 'X' && PlayBoard[1][2] == 'X') {
            setWinnerLine(2);
            return true;
        } else if (PlayBoard[2][0] == 'X' && PlayBoard[2][1] == 'X' && PlayBoard[2][2] == 'X') {
            setWinnerLine(3);
            return true;
        } else if (PlayBoard[0][0] == 'X' && PlayBoard[1][0] == 'X' && PlayBoard[2][0] == 'X') {
            setWinnerLine(4);
            return true;
        } else if (PlayBoard[0][1] == 'X' && PlayBoard[1][1] == 'X' && PlayBoard[2][1] == 'X') {
            setWinnerLine(5);
            return true;
        } else if (PlayBoard[0][2] == 'X' && PlayBoard[1][2] == 'X' && PlayBoard[2][2] == 'X') {
            setWinnerLine(6);
            return true;
        } else if (PlayBoard[0][0] == 'X' && PlayBoard[1][1] == 'X' && PlayBoard[2][2] == 'X') {
            setWinnerLine(7);
            return true;
        } else if (PlayBoard[2][0] == 'X' && PlayBoard[1][1] == 'X' && PlayBoard[0][2] == 'X') {
            setWinnerLine(8);
            return true;
        } else
            return false;
    }

    public static boolean O_CheckForWinner() {
        if (PlayBoard[0][0] == 'O' && PlayBoard[0][1] == 'O' && PlayBoard[0][2] == 'O') {
            setWinnerLine(1);
            return true;
        } else if (PlayBoard[1][0] == 'O' && PlayBoard[1][1] == 'O' && PlayBoard[1][2] == 'O') {
            setWinnerLine(2);
            return true;
        } else if (PlayBoard[2][0] == 'O' && PlayBoard[2][1] == 'O' && PlayBoard[2][2] == 'O') {
            setWinnerLine(3);
            return true;
        } else if (PlayBoard[0][0] == 'O' && PlayBoard[1][0] == 'O' && PlayBoard[2][0] == 'O') {
            setWinnerLine(4);
            return true;
        } else if (PlayBoard[0][1] == 'O' && PlayBoard[1][1] == 'O' && PlayBoard[2][1] == 'O') {
            setWinnerLine(5);
            return true;
        } else if (PlayBoard[0][2] == 'O' && PlayBoard[1][2] == 'O' && PlayBoard[2][2] == 'O') {
            setWinnerLine(6);
            return true;
        } else if (PlayBoard[0][0] == 'O' && PlayBoard[1][1] == 'O' && PlayBoard[2][2] == 'O') {
            setWinnerLine(7);
            return true;
        } else if (PlayBoard[2][0] == 'O' && PlayBoard[1][1] == 'O' && PlayBoard[0][2] == 'O') {
            setWinnerLine(8);
            return true;
        } else
            return false;
    }
    public static void setWinnerLine(int i){
        winnerLine = i;
    }
    
    public static int getWinnerLine(){
        
        return winnerLine;
        
    }

    public static boolean AI_CheckForWinner(char[] board, char player){

        if (board[0] == player && board[1] == player && board[2] == player) {
            setWinnerLine(1);
            return true;
        } else if (board[3] == player && board[4] == player && board[5] == player) {
            setWinnerLine(2);
            return true;
        } else if (board[6] == player && board[7] == player && board[8] == player) {
            setWinnerLine(3);
            return true;
        } else if (board[0] == player && board[3] == player && board[6] == player) {
            setWinnerLine(4);
            return true;
        } else if (board[1] == player && board[4] == player && board[7] == player) {
            setWinnerLine(5);
            return true;
        } else if (board[2] == player && board[5] == player && board[8] == player) {
            setWinnerLine(6);
            return true;
        } else if (board[0] == player && board[4] == player && board[8] == player) {
            setWinnerLine(7);
            return true;
        } else if (board[2] == player && board[4] == player && board[6] == player) {
            setWinnerLine(8);
            return true;
        } else
            return false;
    }
}

