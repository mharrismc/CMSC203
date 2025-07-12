/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: The plot class represents an area of space and determines overlapping and encompassing relations
 * Due: 07/14/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Madison Harris
*/


import java.util.Scanner;

/*
 * This class represents the creation of a plot
 */

public class Plot 
{
	private int xcoord;
	private int ycoord;
	
	private int depth;
	private int width;
	
	//Scanner object to read input
	Scanner keyboard= new Scanner(System.in);
	
	
	//CONSTRUCTORS
	
	//no arg constructor
	public Plot()
	{
		this.xcoord=0;
		this.ycoord=0;
		this.depth=1;
		this.width=1;
	}
	//set only depth and width
	public Plot(int depth, int width)
	{
		this.xcoord=0;
		this.ycoord=0;
		this.depth=depth;
		this.width=width;
	}
	
	
	//set all values
	public Plot(int xcoord, int ycoord, int depth, int width)
	{
		this.xcoord=xcoord;
		this.ycoord=ycoord;
		this.depth=depth;
		this.width=width;
	}
	
	//copy constructor
	public Plot(Plot object2)
	{
		xcoord=object2.xcoord;
		ycoord=object2.ycoord;
		depth=object2.depth;
		width=object2.width;	
	}
	
	//GETTERS
	
	/**
	 * 
	 * @return X coordinate of plot
	 */
	public int getX()
	{
		return xcoord;
	}
	
	/**
	 * 
	 * @return Y coordinate of plot
	 */
	public int getY()
	{
		return ycoord;
	}
	
	/**
	 * 
	 * @return depth of plot
	 */
	public int getDepth()
	{
		return depth;
	}
	
	/**
	 * 
	 * @return width of plot
	 */
	public int getWidth()
	{
		return width;
	}
	
	//SETTERS
	
	/**
	 * Sets x coordinate of plot
	 * @param xcoord
	 */
	public void setXcoord(int xcoord) {
		this.xcoord = xcoord;
	}
	
	/**
	 * sets y coordinate of plot
	 * @param ycoord
	 */
	public void setYcoord(int ycoord) {
		this.ycoord = ycoord;
	}

	/**
	 * sets width of plot
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * sets depth of plot
	 * @param depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	

	
	//check if plot instance overlaps current plot
	/**
	 * 
	 * @param plot object
	 * @return boolean signaling if plots overlap
	 */
	
	public boolean overlaps(Plot plot) 
	{
	    if (plot.xcoord + plot.width <= this.xcoord || 
	        this.xcoord + this.width <= plot.xcoord || 
	        plot.ycoord + plot.depth <= this.ycoord || 
	        this.ycoord + this.depth <= plot.ycoord) 
	    {
	        return false; //signal no overlap found
	    }
	    return true; 
	}
	
	
	//check if current plot contains plot instance
	/**
	 * 
	 * @param plot object
	 * @return boolean signing if current plot contains plot instance
	 */
	public boolean encompasses(Plot plot)
	{
		if (plot.xcoord>=(this.xcoord) && (plot.xcoord<=(this.xcoord+this.width)))
		{
			if((plot.xcoord +plot.width)<= (this.xcoord+this.width))
			{
				if(plot.ycoord>=this.ycoord && (plot.ycoord+plot.depth)<=(this.ycoord +this.depth))
				{
					return true;
				}
			}
			
			
		}
		return false;
	}
	
	/**
	 * @return summary of plot information
	 */
	public String toString()
	{
		return xcoord+"," +ycoord+","+depth+"," + width+"";
	}
	
	

	
	
	
}
