import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Marcel on 8/8/2016.
 */
public class TicTacToeSpec {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    TicTacToe ticTacToe;
    @Before
    public final void Before(){
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException(){
        exception.expect(RuntimeException.class);
        ticTacToe.play(5,2);
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException(){
        exception.expect(RuntimeException.class);
        ticTacToe.play(2,5);
    }

    @Test
    public void whenOccupiedThenRuntimeException(){

        ticTacToe.play(2,1);
        exception.expect(RuntimeException.class);
        ticTacToe.play(2,1);

    }

    @Test
    public void givenFirstTurnWhenNextPlayerThenX(){
        char expectedPlayer = 'X';
        Assert.assertEquals(expectedPlayer, ticTacToe.nextPlayer());
    }

    @Test
    public void givenLastTurnWasXWhenNextPlayerThenO(){

        char expectedPlayer = 'O';

        ticTacToe.play(1,1);

        Assert.assertEquals(expectedPlayer, ticTacToe.nextPlayer());
    }

    @Test
    public void whenPlayNoWinner(){

        String expectedNoWinner = "No winner";

        String actualNoWinner = ticTacToe.play(1,1);

        Assert.assertEquals(expectedNoWinner, actualNoWinner);
    }

    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner(){

        String expectedWinner = "X is the winner";

        ticTacToe.play(1,1); // X
        ticTacToe.play(2,1); // O
        ticTacToe.play(1,2); // X
        ticTacToe.play(2,2); // O
        String actualWinner = ticTacToe.play(1,3); // X

        Assert.assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void whenPlayAndWholeVerticalLineThenWinner(){

        String expectedWinner = "O is the winner";

        ticTacToe.play(1,2); // X
        ticTacToe.play(1,1); // O
        ticTacToe.play(1,3); // X
        ticTacToe.play(2,1); // O
        ticTacToe.play(2,2); // X
        String actualWinner = ticTacToe.play(3,1); // O

        Assert.assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void whenPlayAndTopBottomDiagonalLineThenWinner(){

        String expectedWinner = "X is the winner";

        ticTacToe.play(1,1); // X
        ticTacToe.play(1,2); // O
        ticTacToe.play(2,2); // X
        ticTacToe.play(1,3); // O
        String actualWinner = ticTacToe.play(3,3); // X

        Assert.assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void whenPlayAndBottomTopDiagonalLineThenWinner(){

        String expectedWinner = "X is the winner";

        ticTacToe.play(3,1); // X
        ticTacToe.play(1,2); // O
        ticTacToe.play(2,2); // X
        ticTacToe.play(3,3); // O
        String actualWinner = ticTacToe.play(1,3); // X

        Assert.assertEquals(expectedWinner, actualWinner);
    }

}
