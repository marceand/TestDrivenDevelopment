/**
 * Created by Marcel on 8/9/2016.
 */
public class TicTacToe {

    public void play(int x, int y){

        if(x < 1 || x > 3){
            throw new RuntimeException("X is outside of board");
        }else if(y < 1 || y > 3){
            throw new RuntimeException("Y is outside of board");
        }
    }
}
