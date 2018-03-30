package Main.Model;

public class Game {

    public static char[][] PlayBoard = new char[3][3];
    public int NumberOfMoves = 1;




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


        //checks how many spots are free
        int count = 0;
        for(int i = 0; i < getNewBoard().length; i++){
            if( getNewBoard()[i] == '-'){
                count++;
            }
        }
        int SpotsAvailable = count;

        //checks for end points
        if(Evaluation.O_CheckForWinner()){
            return -10;
        }else if (Evaluation.X_CheckForWinner()){
            return +10;
        }else if (SpotsAvailable == 0){
            return 0;
        }






        return 0;
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
