package two_d_array;

/**
 * This class implements a basic two dimensional array and provides member methods for the following:
 * total, average, row total, column total, highest in row, and lowest in row.
 * This class demonstrates the ability to create arrays and perform logic upon them.
 * The array will be filled with Integer.MIN_VALUE for validation purposes.
 * Math operations will ignore the Integer.MIN_VALUE.
 * @author Mohammad Al-Husseini
 * @version 1.0.0
 */
public class TwoDArray 
{
	////////////////////////////////////////////////Fields////////////////////////////////////////////////
	
	private int twoD[][];
	private int rows, cols;
	private static final int empty = Integer.MIN_VALUE; // To fill the array in order to validate the math
	
	/////////////////////////////////////////////Constructors/////////////////////////////////////////////
	
	/**
	 * Intended constructor that creates the array.
	 * @param r Integer representing the number of rows.    (r > 0)
	 * @param c Integer representing the number of columns. (c > 0)
	 */
	public TwoDArray(int r, int c)
	{
		twoD = new int[r][c];		
		
		rows = r;
		cols = c;
		
		// Fill the array with the empty value
		// Provides good validation, but at a potentially huge performance hit.
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
			{
				twoD[i][j] = empty;
			}
		}
	}

	////////////////////////////////////////////Accessor/Mutator//////////////////////////////////////////
	
	/**
	 * Method that returns the array.
	 * Since the array will be passed by reference this is an accessor and a mutator.
	 * This does somewhat invalidate the private nature of the field.
	 * @return twoD A reference to the private field array.
	 */
	public int[][] getArray()
	{
		return twoD;
	}
	
	////////////////////////////////////////////////Methods///////////////////////////////////////////////
	
	/**
	 * Member method for returning the total of the numbers in the array.
	 * @return total Integer representing the total of all the numbers stored in the array.
	 */
	public int getTotal()
	{
		int total = 0;
		
		// Use nested for loops to iterate through the array
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				// Verify non-empty. Could break the loop, but not sure where the data has been entered.
				if(twoD[i][j] != empty)
					total += twoD[i][j];
			}
		}
		
		return total;
	}
	
	/**
	 * Member method for returning the average of the numbers in the array.
	 * @return avg Double representing the average of all the numbers stored in the array.
	 */
	public double getAverage()
	{
		// Could call the total method as a helper, but I do not want to assume that the array is filled.
		// E.G. total / (cols * rows)
		
		int total = 0;
		int num = 0;
		
		// Use nested for loops to iterate through the array
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				if(twoD[i][j] != empty)
				{
					total += twoD[i][j];
					num++;
				}
			}
		}
		
		return total/((double)num); // avoid integer division
	}
	
	/**
	 * Member method for returning the total of the numbers in a row of the array.
	 * @param r Integer representing the row of the array to be totaled.
	 * @return total Integer representing the total of all the numbers stored the specified row of the array.
	 */
	public int getRowTotal(int r)
	{
		int total = 0;
		
		for(int i = 0; i < cols; i++)
		{
			// Verify non-empty. Could break the loop, but not sure where the data has been entered.
			if(twoD[r][i] != empty)
				total += twoD[r][i];
		}
		
		return total;
	}
	
	/**
	 * Member method for returning the total of the numbers in a column of the array.
	 * @param c Integer representing the column of the array to be totaled.
	 * @return total Integer representing the total of all the numbers stored the specified column of the array.
	 */
	public int getColTotal(int c)
	{
		int total = 0;
		
		for(int i = 0; i < rows; i++)
		{
			// Verify non-empty. Could break the loop, but not sure where the data has been entered.
			if(twoD[i][c] != empty)
				total += twoD[i][c];
		}
		
		return total;
	}
	
	/**
	 * Member method for returning the highest number in a row of the array.
	 * @param r Integer representing the row of the array to be checked.
	 * @return highest Integer representing the highest number in the specified row of the array.
	 */
	public int getHighestInRow(int r)
	{
		// Set the current highest to the first element of the row
		int highest =twoD[r][0];
		
		for(int i = 1; i < cols; i++) // start at the next element in the row
		{
		// Check to see if the new element is higher
		if(twoD[r][i] > highest)
			highest = twoD[r][i];	
		}
		
		return highest;
	}
	
	/**
	 * Member method for returning the lowest number in a row of the array.
	 * @param r Integer representing the row of the array to be checked.
	 * @return lowest Integer representing the lowest number in the specified row of the array or 0 if the row is empty.
	 */
	public int getLowestInRow(int r)
	{
		// This method is complicated by the fact that the empty value is the lowest possible
		int lowest = 0;
		int col = 0;
		
		// Set the current lowest to the first element of the row, unless it is empty
		// Use an enhanced for loop to iterate through the single dimensional array in row r of the two dimensional array
		for(int low : twoD[r])
		{
			if(low == empty)
			{
				col++;
			}
			else
			{
				lowest = low;
				break;
			}
		}
		
		for(int i = col + 1; i < cols; i++) // start at the next element in the row
		{
			// Verify non-empty. Could break the loop, but not sure where the data has been entered.
			if(twoD[r][i] != empty)
			{
				// Check to see if the new element is lowest
				if(twoD[r][i] < lowest)
					lowest = twoD[r][i];
			}
			
		}
		
		return lowest;
	}
}
