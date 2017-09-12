package carpet_calculator;

/**
 * This class utilizes a RoomDimension object as a field, 
 * contains static fields for price and carpet type, and calculates the cost to carpet a room.
 * This class demonstrates the ability to work with enumerated types and object aggregation.
 * @author Mohammad Al-Husseini
 * @version 1.0.0
 */
public class RoomCarpet 
{
	////////////////////////////////////////////////Fields////////////////////////////////////////////////
	
	static public enum CType              {SHAG, SHORT, MEDIUM, LONG};
	static final public double[] prices = {7.99, 5.99,  6.99,   8.99};
	private CType selection;
	private RoomDimension area;
	
	/////////////////////////////////////////////Constructors/////////////////////////////////////////////
	
	/**
	 * Intended constructor
	 * @param l Double representing the length of a room.
	 * @param w Double representing the width of a room.
	 * @param sel CType enum type representing the carpet type.
	 */
	public RoomCarpet(double l, double w, CType sel)
	{
		area = new RoomDimension(l, w);
		selection = sel;
	}
	
	////////////////////////////////////////////////Methods///////////////////////////////////////////////
	
	/**
	 * Calculates and returns the cost to carpet the room.
	 * @return price multiplied by area Double
	 */
	public double getCost()
	{
		return prices[selection.ordinal()] * area.getArea();
	}
}
