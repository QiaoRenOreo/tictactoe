//P 5.7

package ss.week5.tictactoe;
import ss.week5.tictactoe.Board;
import ss.week5.tictactoe.Mark;


public class ComputerPlayer extends Player
{
	Strategy strategyComp;
	//_____________________Two Constructors______________
	 
	/**
	 * that constructs a computer player using the given mark and strategy
	 * The name of the ComputerPlayer is the name of the strategy, 
	 * followed by a hyphen (¡¯¡¯-¡¯¡¯) * ,
	 * followed by a representation of the player¡¯s mark.
	 */
	public ComputerPlayer (Strategy strategy,Mark mark)
	{ 
		super(strategy.getName()+"-"+mark, mark);
		strategyComp=strategy; 
	}
	
	/**
	 * that constructs a computer player using the given mark and a naive strategy.
	 */
	public ComputerPlayer (Mark mark)
	{
		this(new NaiveStrategy(),mark); 
	}
	//_____________________commands_________________________
	
	@Override
	public int determineMove(Board board) 
	{
		return  strategyComp.determineMove(board, getMark());

	}

}
