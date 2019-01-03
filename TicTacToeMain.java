package ss.week5.tictactoe;

import java.util.Objects;

/**P-5.8 
 * Update the class week5.TicTacToe such that 
 * naive computer player can play the game. 
 * If the name ¡°-N¡± is given as an argument, 
 * this means this player is a ComputerPlayer with a naive strategy. 
 * For example, if you start the program with the arguments wim -N, 
 * as in: java week8.TicTacToe wim -N 
 * a game will be created with 
 * 			wim (as X-humanplay) against naive-computer-O.
 * Test the program by playing some games against the naive computer player
*/
public class TicTacToeMain 
{
	static Strategy strategy;
	static Strategy strategySecondComputer;
	static String naive="N";
	static String smart="S";
	static Player playerA;
	static Player playerB;
	
	public static void main(String[] args) //String[] args
    {
    	if (args!=null)
    	{

    		String part1 = args[0]; //check args[0]==null
    		String part2 = args[1]; //check args[1]==null
    		String[] part1Spilitted=part1.split("-");
    		String part1_1 = part1Spilitted[0]; 
    		String part1_2 = part1Spilitted[1]; 
    		
    		String[] part2Spilitted=part2.split("-");
    		String part2_1 = part2Spilitted[0];  
    		String part2_2 = part2Spilitted[1]; 
    		
    		if (part1_1.equals("Computer")&&part2_1.equals("Human"))
    			//"Computer-N Human-Alice"
    		{
    			System.out.println("computer human");
    			/*HumanPlayer*/ playerA=new HumanPlayer(part2_2, Mark.XX);
    			if (part1_2.equals(smart))
    			{
    				strategy=new SmartStrategy(); 
    				/*ComputerPlayer*/ playerB=new ComputerPlayer(strategy,Mark.OO);
    			}
    			else //(part1_2.equals(naive))
    			{
    				strategy=new NaiveStrategy();
    				/*ComputerPlayer*/ playerB=new ComputerPlayer(strategy,Mark.OO);
    			}
    		}
    		else if (part1_1.equals("Human")&&part2_1.equals("Computer"))
    		{
    			System.out.println("human computer");
    			/*HumanPlayer*/ playerA=new HumanPlayer(part1_2, Mark.XX);
    			if (part2_2.equals(smart))
    			{
    				strategy=new SmartStrategy(); 
    				/*ComputerPlayer*/ playerB=new ComputerPlayer(strategy,Mark.OO);
    			}
    			else //(part2_2.equals(naive))
    			{
    				strategy=new NaiveStrategy();
    				/*ComputerPlayer*/ playerB=new ComputerPlayer(strategy,Mark.OO);
    			}
    		}
    		
    		else if (part1_1.equals("Computer")&&part2_1.equals("Computer"))
    		{
    			System.out.println("computer computer");
    			if (part1_2.equals(smart))
    			{
    				strategy=new SmartStrategy(); 
    				/*ComputerPlayer*/ playerA=new ComputerPlayer(strategy,Mark.XX);
    			}
    			else //(part2_2.equals(naive))
    			{
    				strategy=new NaiveStrategy();
    				/*ComputerPlayer*/ playerA=new ComputerPlayer(strategy,Mark.XX);
    			}
    			
    			if (part2_2.equals(smart))
    			{
    				strategySecondComputer=new SmartStrategy(); 
    				/*ComputerPlayer*/ playerB=new ComputerPlayer(strategySecondComputer,Mark.XX);
    			}
    			else //(part2_2.equals(naive))
    			{
    				strategySecondComputer=new NaiveStrategy();
    				/*ComputerPlayer*/ playerB=new ComputerPlayer(strategySecondComputer,Mark.XX);
	    		}
    		}
    		
    		else //(part1_1.equals("Human")&&part2_1.equals("Human"))
    		{ 
    			System.out.println("human human");
    			/*HumanPlayer*/ playerA=new HumanPlayer(part1_2, Mark.XX);
    			/*HumanPlayer*/ playerB=new HumanPlayer(part2_2, Mark.OO);
    		}
        	Game game=new Game(playerA,playerB);
        	game.start();

    	}	else 
    	{
    		System.out.println("args is null");
    	}
    }

}
