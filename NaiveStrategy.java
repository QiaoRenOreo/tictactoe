//P 5.6
package ss.week5.tictactoe;

import ss.week5.tictactoe.Board;
import ss.week5.tictactoe.Mark;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
 
public class NaiveStrategy implements Strategy
{
	String name="Naive"; 
	//_____________constructor, needed or not needed?________
	Board board; 
	public NaiveStrategy()
	{
		board=new Board();
	}
	//_____________commands________________________
	@Override
	public String getName() 
	{
		return name;
	}
	
	/**
	 *  determineMove returns an arbitrary empty field on the board.
	 *  the method determineMove chooses an arbitrary empty field. 
	 *  Therefore, you should first construct a collection of empty fields 
	 *  			(using interface java.util.Set). 
	 *  Afterwards, you can use the method Math.random 
	 *  			to select one of these empty fields
	 */
	@Override

		//P 5.6______________________________________
	public int determineMove(Board b, Mark m) 
	{
		int[] emptyFieldArray=new int[b.getDimension()*b.getDimension()];
		int arrayIndex=0;
		for (arrayIndex=0;arrayIndex<emptyFieldArray.length;arrayIndex=arrayIndex+1 )
		{
			emptyFieldArray[arrayIndex]=-1;
		}
		
		for (int i=0;i<b.getDimension()*b.getDimension();i=i+1)
		{
			if(b.isEmptyField(i))
			{
				emptyFieldArray[arrayIndex]=i;
				arrayIndex=arrayIndex+1;
				//emptyFieldArray might be {3,5,6,8,-1,-1,...,-1}
			}
			
		}
		
		int filledLength=0;
		for (int j=0; j<emptyFieldArray.length;j=j+1)
		{
			if (emptyFieldArray[j]==-1)
			{
				filledLength=j-1;
				break;
			}
		}
		int randomNum = ThreadLocalRandom.current().nextInt(0, filledLength + 1);
		return emptyFieldArray[randomNum];
		//____________________
	}

}
