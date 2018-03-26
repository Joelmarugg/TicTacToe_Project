package Model;

public class TicTacToe_ModelOffline {

    public static char[][] PlayBoard = new char[3][3];
    public int NumberOfMoves = 1;



public TicTacToe_ModelOffline(){


}

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

    public boolean CheckTie(){
    if(NumberOfMoves >= 10 && !Evaluation.O_CheckForWinner() && !Evaluation.X_CheckForWinner()) {
        return true;
    }else {
        return false;
    }
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
