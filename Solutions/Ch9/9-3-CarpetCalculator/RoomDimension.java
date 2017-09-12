package carpet_calculator;

/**
 * This class holds a rooms length and width and determines it's area.
 * @author Mohammad Al-Husseini
 * @version 1.0.0
 */
public class RoomDimension 
{
	////////////////////////////////////////////////Fields////////////////////////////////////////////////
	
	double length, width;
	
	/////////////////////////////////////////////Constructors/////////////////////////////////////////////
	
	/**
	 * Intended constructor
	 * @param l Double representing the length of a room.
	 * @param w Double representing the width of a room.
	 */
	public RoomDimension(double l, double w)
	{
		length = l;
		width = w;
	}
	
	////////////////////////////////////////////////Methods///////////////////////////////////////////////
	
	/**
	 * Calculates and returns the area of the room.
	 * @return length multiplied by width Double
	 */
	public double getArea()
	{
		return length * width;
	}
}
