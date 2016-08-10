/**
 * Created by Marcel on 8/9/2016.
 */
public class TicTacToe {

    private char[][] board = {{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};
    private char lastPlayer = '\0';

    public void play(int x, int y){

        checkAxis(x);
        checkAxis(y);

        setBoard(x,y);
        lastPlayer = nextPlayer();
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
            board[x-1][y-1] = 'X';
        }
    }

    public char nextPlayer() {

        if(lastPlayer == 'X'){
            return 'O';
        }

        return 'X';
    }
}
