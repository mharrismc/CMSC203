/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: The property class represents a property on a plotcitpl
 * Due: 07/14/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Madison Harris
*/


/*
 * This class represents a property
 */
public class Property 
{
	private String name;
	private String city;
	private double amount;
	private String owner;
	private Plot plot;
	
	//CONSTRUCTORS
	
	//no arg constructor
	public Property()
	{
		this.name="";
		this.city="";
		this.amount=0.0;
		this.owner="";
		this.plot = new Plot();
	}
	
	// Constructor with name, city, amount, and owner
	/**
	 * 
	 * @param name: The name of the property
	 * @param city: The city the property is in
	 * @param amount: The cost of the property rent
	 * @param owner: The name of the property owner
	 */
	public Property(String name, String city, double amount, String owner) {
		this.name = name;
		this.city = city;
		this.amount = amount;
		this.owner = owner;
		this.plot = new Plot(); 
	}
	
	//constructor with parameters
	/**
	 * 
	 * @param name: The name of the property
	 * @param city: The city the property is in
	 * @param amount: The cost of the property rent
	 * @param owner: The name of the property owner
	 * @param xcoord: X coordinate of the property plot
	 * @param ycoord: Y coordinate of the property plot
	 * @param depth: depth of the property plot
	 * @param width: width of the property plot
	 */
	public Property(String name, String city, double amount, String owner, int xcoord, int ycoord, int depth, int width) {
		this.name = name;
		this.city = city;
		this.amount = amount;
		this.owner = owner;
		this.plot = new Plot(xcoord, ycoord, depth, width); 
	}
	
	//copy constructor
	public Property(Property object2)
	{
		name=object2.name;
		city=object2.city;
		amount=object2.amount;
		owner=object2.owner;
		this.plot=new Plot(object2.plot);
	}
	
	//GETTER METHODS
	
	/**
	 * 
	 * @return string representing the property name
	 */
	public String getPropertyName()
	{
		return name;
	}
	
	/**
	 * 
	 * @return string representing the property city
	 */
	public String getCity()
	{
		return city;
	}
	
	/**
	 * 
	 * @return double representing the cost of the property rent
	 */
	public double getRentAmount()
	{
		return amount;
	}
	
	/**
	 * 
	 * @return string representing property owner's name
	 */
	public String getOwner()
	{
		return owner;
	}
	
	/**
	 * 
	 * @return the plot of the property
	 */
	public Plot getPlot()
	{
		return new Plot (plot);
	}
	
	//SETTERS
	
	/**
	 * 
	 * @param name: Property name
	 */
	public void setName(String name)
	{
		this.name=name;
	}
	
	/**
	 * 
	 * @param city: property city
	 */
	public void setCity(String city)
	{
		this.city=city;
	}
	
	/**
	 * 
	 * @param amount: cost of property rent
	 */
	public void setAmount(double amount)
	{
		this.amount=amount;
	}
	
	/**
	 * 
	 * @param owner: Owners name
	 */
	public void setOwner(String owner)
	{
		this.owner=owner;
	}
	
	/**
	 * 
	 * @param plot: plot of property
	 */
	public void setPlot(Plot plot)
	{
		this.plot=new Plot(plot.getX(), plot.getY(), plot.getDepth(), plot.getWidth());
	}
	
	/**
	 * @return Summary of class information
	 */
	public String toString()
	{
		return this.getPropertyName() + "," + this.getCity() + "," + this.getOwner() + "," + this.getRentAmount();
	}
}
