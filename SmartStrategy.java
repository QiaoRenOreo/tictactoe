package ss.week5.tictactoe;

import java.util.concurrent.ThreadLocalRandom;

/**P-5.9 Specify and implement a class ss.week5.SmartStrategy, 
 * implementing the ss.week5.Strategy interface. 
 */
 
public class SmartStrategy implements Strategy 
{
	String name="Smart";
	//__________commands______________
	
	@Override
	public String getName() 
	{
		return name;
	}
	/** The method determineMove returns an empty field 
	 * 				using the following recipe:
	• If the middle field is empty, this field is selected;
	• If there is a field that guarantees a direct win, this field is selected.
	• If there is a field with which the opponent could win, this field is selected.
	• If none of the cases above applies, a random field is selected.
	Hint It might be useful to make a copy of the board for the implementation of determineMove.
	The name of this strategy is ’’Smart’’*/
	public int[] emptyFieldsArray (Board b)
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
		return emptyFieldArray;
	}
	public int actualLengthOfEmptyArray (int [] array)
	{
		int filledLength=0;
		for (int j=0; j<array.length;j=j+1)
		{
			if (array[j]==-1)
			{
				filledLength=j-1;
				break;
			}
		}
		return filledLength;
	}
	
	public int directWin (Board b, int[]array, Mark m)
	{		
		int filledLength=actualLengthOfEmptyArray (array);
		for (int arrayIndex=0; arrayIndex<filledLength; arrayIndex=arrayIndex+1)
		{
			b.setField(array[arrayIndex], m);
			if (b.isWinner(m))
			{
				return array[arrayIndex];
				//means there is an empty field that causes a direct win
			}
			b.setField(array[arrayIndex], Mark.EMPTY);
		}
		return -1;//-1 means none of the empty fields can result in a direct win. 
	}
	
	public int opponentWin (Board b, int[]array, Mark m)
	{
		
		int filledLength=actualLengthOfEmptyArray (array);
		for (int arrayIndex=0; arrayIndex<filledLength; arrayIndex=arrayIndex+1)
		{
			b.setField(array[arrayIndex], m.other());
			if (b.isWinner(m.other()))
			{
				return array[arrayIndex];
				//means there is an empty field that causes the opponent to win
			}
			b.setField(array[arrayIndex], Mark.EMPTY);
		}
		return -1;//-1 means none of the empty fields can cause the opponent to win
	}
	@Override
	public int determineMove(Board b, Mark m) 
	{
		Board bCopy=b.deepCopy();
		int [] emptyFields=emptyFieldsArray (bCopy);
		int filledLength=actualLengthOfEmptyArray (emptyFields);
		//• If the middle field is empty, this field is selected;
		int middleFieldRow=bCopy.getDimension()/2;
		int middleFieldCol=bCopy.getDimension()/2;
		int middleField=bCopy.index(middleFieldRow, middleFieldCol);
		
		if (bCopy.isEmptyField(middleField))
		{
			return middleField;
		}
		//• If there is a field that guarantees a direct win, this field is selected.
		else if(directWin (bCopy,emptyFields, m)!=-1 )
		{
			return directWin (bCopy,emptyFields, m);
		}
		//• If there is a field with which the opponent could win, this field is selected.
		else if(opponentWin(bCopy,emptyFields, m)!=-1)
		{
			return opponentWin(bCopy,emptyFields, m);
		}
		//• If none of the cases above applies, a random field is selected.
		else
		{
			int randomNum = ThreadLocalRandom.current().nextInt(0, filledLength + 1);
			return emptyFields[randomNum];
		}
	}
	
}
