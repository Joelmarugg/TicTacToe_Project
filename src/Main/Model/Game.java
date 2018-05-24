package Main.Model;

public class Game {

    static char[][] PlayBoard = new char[3][3];
    int NumberOfMoves = 1;
    char player = 'X';
    int depth = 0;
    int GoTo;
    public boolean Winner = false;
    int level;
    private int SpotsAvailable;


    public void NewGame() {

      /* PlayBoard = new char[][] {{'O','-','X'},
                                 {'X','-','X'},
                                 {'-','O','O'}};*/
        Winner = false;
        depth = 0;


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
        depth = 0;

        for (char[] a : PlayBoard) {
            for (char i : a) {
                System.out.print(i + "\t");
            }
            System.out.println("\n");
        }
    }


    public static char[] getNewBoard() {
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

    int minimax(char[] newPlayBoard, char player){



        char AiPlayer = 'X';
        char HuPlayer = 'O';
        //depth++;
        System.out.println("looking at depth " + depth);

        //make it easier for other levels
        if (level == 1){
            if ( depth == 1){
                return 0;
            }
        }else if (level == 2){
            if (depth == 3){
                return 0;
            }
        }

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

        // create array to store values of the moves
        int[] moves = new int[SpotsAvailable];


        int c = 0;
        for (int i = 0; i < getNewBoard().length; i++) {

            if (newPlayBoard[i] == '-') {

                newPlayBoard[i] = player;

                int move = 0;

                depth++;
                int result = minimax(newPlayBoard, player == AiPlayer ? HuPlayer:AiPlayer);
                depth--;
                move += result;

                /*
                if (player == AiPlayer) {
                    depth++;
                    int result = minimax(newPlayBoard, HuPlayer);
                    move += result;
                } else {
                   depth++;
                    int result = minimax(newPlayBoard, AiPlayer);
                    move += result;
                }
                */
                newPlayBoard[i] = '-';


                moves[c] = move;
                c++;
            }
        }

        count=0;

        for(int i = 0; i < getNewBoard().length; i++){
            if( newPlayBoard[i] == '-'){
                count++;
            }
        }
        SpotsAvailable = count;

        int BestMove = 0;

        //check for MAX
        if(player == AiPlayer){
            int BestScore = -10000;
            for(int i = 0; i < moves.length; i++){
                if(moves[i] > BestScore){
                    BestScore = moves[i];
                    BestMove = BestScore;
                }
            }
        }else {
            //check for MIN
            int BestScore = 10000;
            for (int i = 0; i < moves.length; i++) {
                if (moves[i] < BestScore) {
                    BestScore = moves[i];
                    BestMove = BestScore;

                }
            }
        }

        position_of(moves,BestMove,newPlayBoard);
        return BestMove;

    }

    private void position_of(int[] Moves, int bestMove, char[] NewPlayBoard) {
        for (int i = 0; i < Moves.length; i++) {
            if (Moves[i] == bestMove) {
                GoTo = EmptySpots(NewPlayBoard)[i];
                break;
            }


        }
    }


    private int[] EmptySpots(char[] board){

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
