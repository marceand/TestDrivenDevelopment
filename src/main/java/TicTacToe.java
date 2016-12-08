import javax.swing.text.PlainDocument;

/**
 * Created by Marcel on 8/9/2016.
 * https://bitbucket.org/vfarcic/tdd-java-ch03-tic-tac-toe
 */
public class TicTacToe {

    private char[][] board = {{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};
    private char lastPlayer = '\0';

    private static final int SIZE = 3;


    public String play(int x, int y){

        checkAxis(x);
        checkAxis(y);

        lastPlayer = nextPlayer();
        setBoard(x,y);

        if(isWin()){

            return lastPlayer + " is the winner";

        }

        return "No winner";
    }

    private void checkAxis(int axis){
        if(axis < 1 || axis > 3){
            throw new RuntimeException("Piece is outside of board");
        }
    }

    private void setBoard(int x, int y){
        if(board[x-1][y-1] != '\0'){
            throw new RuntimeException("Box is occupied");
        }else {
            board[x-1][y-1] = lastPlayer;
        }
    }

    public char nextPlayer() {

        if(lastPlayer == 'X'){
            return 'O';
        }

        return 'X';
    }

    private boolean isWin(){

        int playTotal = lastPlayer*SIZE;

        for(int i = 0; i < SIZE; i++){

            if(board[i][0] + board[i][1] + board[i][1] == playTotal){
                return true;
            }else if (board[0][i] + board[1][i] + board[2][i] == playTotal){
                return true;
            }
        }

        if(board[0][0] + board[1][1] + board[2][2] == 3*lastPlayer){
            return true;
        }else if(board[2][0] + board[1][1] + board[0][2] == 3*lastPlayer){
            return true;
        }

        return false;

    }

}
