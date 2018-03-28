package Model;

import java.util.Random;

public class TicTacToe_ModelAI extends Game {


    public TicTacToe_ModelAI(){
        super();
    }

    @Override
    public void O_move(int row, int col){
        super.O_move(row,col);
        AIMove();
    }

    public void AIMove(){

        Random random = new Random();
        int r = random.nextInt(4) + 1;

        if (r == 1 ) {
            X_move(0,0);
            System.out.println("Computer moves to " + r);
        }

        else if (r == 2 ) {
            X_move(0,2);
            System.out.println("Computer moves to " + r);
        }
        else if (r == 3 ) {
            X_move(2,0);
            System.out.println("Computer moves to " + r);
        }
        else if (r == 4 ) {
            X_move(2,2);
            System.out.println("Computer moves to " + r);
        }

    }


}
