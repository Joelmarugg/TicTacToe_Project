package Model;

public class Evaluation extends Game {

    public static boolean X_CheckForWinner() {
        if (PlayBoard[0][0] == 'X' && PlayBoard[0][1] == 'X' && PlayBoard[0][2] == 'X') {
            return true;
        } else if (PlayBoard[1][0] == 'X' && PlayBoard[1][1] == 'X' && PlayBoard[1][2] == 'X') {
            return true;
        } else if (PlayBoard[2][0] == 'X' && PlayBoard[2][1] == 'X' && PlayBoard[2][2] == 'X') {
            return true;
        } else if (PlayBoard[0][0] == 'X' && PlayBoard[1][0] == 'X' && PlayBoard[2][0] == 'X') {
            return true;
        } else if (PlayBoard[0][1] == 'X' && PlayBoard[1][1] == 'X' && PlayBoard[2][1] == 'X') {
            return true;
        } else if (PlayBoard[0][2] == 'X' && PlayBoard[1][2] == 'X' && PlayBoard[2][2] == 'X') {
            return true;
        } else if (PlayBoard[0][0] == 'X' && PlayBoard[1][1] == 'X' && PlayBoard[2][2] == 'X') {
            return true;
        } else if (PlayBoard[2][0] == 'X' && PlayBoard[1][1] == 'X' && PlayBoard[0][2] == 'X') {
            return true;
        } else
            return false;
    }

    public static boolean O_CheckForWinner() {
        if (PlayBoard[0][0] == 'O' && PlayBoard[0][1] == 'O' && PlayBoard[0][2] == 'O') {
            return true;
        } else if (PlayBoard[1][0] == 'O' && PlayBoard[1][1] == 'O' && PlayBoard[1][2] == 'O') {
            return true;
        } else if (PlayBoard[2][0] == 'O' && PlayBoard[2][1] == 'O' && PlayBoard[2][2] == 'O') {
            return true;
        } else if (PlayBoard[0][0] == 'O' && PlayBoard[1][0] == 'O' && PlayBoard[2][0] == 'O') {
            return true;
        } else if (PlayBoard[0][1] == 'O' && PlayBoard[1][1] == 'O' && PlayBoard[2][1] == 'O') {
            return true;
        } else if (PlayBoard[0][2] == 'O' && PlayBoard[1][2] == 'O' && PlayBoard[2][2] == 'O') {
            return true;
        } else if (PlayBoard[0][0] == 'O' && PlayBoard[1][1] == 'O' && PlayBoard[2][2] == 'O') {
            return true;
        } else if (PlayBoard[2][0] == 'O' && PlayBoard[1][1] == 'O' && PlayBoard[0][2] == 'O') {
            return true;
        } else
            return false;
    }

}
