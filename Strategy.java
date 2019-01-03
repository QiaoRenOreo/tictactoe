//P5.5
package ss.week5.tictactoe;
import ss.week5.tictactoe.Board;
import ss.week5.tictactoe.Mark;

public interface Strategy 
{
	/**
	 * returns the name of the strategy;
	 */
	public String getName();
	
	/**
	 * returns a next legal move, 
	 * given the Board b, for the player with Mark m
	 */
	public int determineMove(Board b, Mark m);
	
}
