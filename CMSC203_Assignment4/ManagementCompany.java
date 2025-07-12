/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: The Management Company class represents a management company
 * up to 5 properties can be added to a management company
 * this class performs tasks such as calculating the total rent amount of all propertiesnamep
 * Due: 07/14/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Madison Harris
*/


/*
 * This class represents the Management Company
 */
public class ManagementCompany {

	private String name;
	private String taxID;
	private int percent;
	
	public static final int MAX_PROPERTY=5;
	private static final int MGMT_WIDTH=10;
	private static final int MGMT_DEPTH=10;
	
	Property[] property= new Property[MAX_PROPERTY];
	
	Plot plot= new Plot(MGMT_DEPTH, MGMT_WIDTH);
	
	private int numberOfProperties;
	
	
	//CONSTRUCTORS
	
	//no arg constructor
	public ManagementCompany()
	{
		this.name="";
		this.taxID="";
		this.percent=0;
		this.numberOfProperties=0;
		
		this.plot=new Plot(MGMT_DEPTH, MGMT_WIDTH);
				
	}
	
	//Initialize instance variables, default plot, percent as int
	public ManagementCompany(String name, String taxID, int percent)
	{
		this.name=name;
		this.taxID=taxID;
		this.percent=percent;

		this.plot=new Plot(MGMT_DEPTH, MGMT_WIDTH);
	}
	
	//takes percent as a double, default plot
	public ManagementCompany(String name, String taxID, double percent) {
	    this.name = name;
	    this.taxID = taxID;
	    this.percent = (int) percent; 
	    this.plot = new Plot(MGMT_DEPTH, MGMT_WIDTH);
	}
	
	//all parameters
	public ManagementCompany(String name, String taxID, int percent, int xcoord, int ycoord)
	{
		this.name=name;
		this.taxID=taxID;
		this.percent=percent;
		this.numberOfProperties=0;

		this.plot=new Plot(xcoord,ycoord,MGMT_DEPTH, MGMT_WIDTH);
	}
	
	//copy constructor
	public ManagementCompany(ManagementCompany object2)
	{
		name=object2.name;
		taxID=object2.taxID;
		percent=object2.percent;
		numberOfProperties=object2.numberOfProperties;

		this.plot=new Plot(object2.plot);
	}
	
	//GETTERS
	
	/**
	 * 
	 * @return The name of the management company
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * @return The company taxID
	 */
	public String getTaxID()
	{
		return taxID;
	}
	
	/**
	 * 
	 * @return The percent fee of the management company
	 */
	public int getPercent()
	{
		return percent;
	}
	
	/**
	 * 
	 * @return The number of properties created
	 */
	public int getNumberOfProperties()
	{
		return numberOfProperties;
	}
	
	/**
	 * 
	 * @return A property object
	 */
	public Property[] getProperties()
	{
		return property;
	}
	
	/**
	 * 
	 * @return a plot object
	 */
	public Plot getPlot()
	{
		return plot;
	}
	
	//SETTERS
	
	/**
	 * 
	 * @param name: Sets the management company name
	 */
	public void setName(String name)
	{
		this.name=name;
	}
	
	/**
	 * 
	 * @param taxID: Sets the management companys taxID
	 */
	public void setTaxID(String taxID)
	{
		this.taxID=taxID;
	}
	
	/**
	 * 
	 * @param percent: Sets the management company percent fee
	 */
	public void setPercent(int percent)
	{
		this.percent=percent;
	}
	
	/**
	 * 
	 * @param property: Sets property list
	 */
	public void setProperties(Property[] property)
	{
		this.property= property;
	}
	
	/**
	 * 
	 * @param plot
	 * Sets a plot object
	 */
	public void setPlot(Plot plot)
	{
		this.plot=new Plot(plot);
	}
	
	//add property methods
	
	/**
	 * 
	 * @param prop
	 * @return integer reflecting outcome of if statement
	 */
	public int addProperty(Property prop)
	{
		if(numberOfProperties>=MAX_PROPERTY)
		{
			return -1;
		}
		
		if(prop==null)
		{
			return -2;
		}
		
		if(!this.plot.encompasses(prop.getPlot()))
		{
			return -3;
		}
		
		for (int i = 0; i < numberOfProperties; i++) {
		    if (property[i] != null && property[i].getPlot().overlaps(prop.getPlot())) {
		        return -4;
		    }
		}
		
		property[numberOfProperties++]=new Property(prop);
		
		return numberOfProperties-1;
		
	}
	
	/**
	 * 
	 * @param name
	 * @param city
	 * @param amount
	 * @param owner
	 * @param xcoord
	 * @param ycoord
	 * @param depth
	 * @param width
	 * @return call to overloaded addProperty method(returns integer based on outcome of if)
	 */
	public int addProperty(String name, String city, double amount, String owner, int xcoord, int ycoord, int depth, int width)
	{
		Property prop= new Property(name, city, amount, owner, xcoord, ycoord, depth, width);
		return addProperty(prop);
		
	}
	
	/**
	 * 
	 * @return total rent of all properties
	 */
	public double getTotalRent() 
	{
		double total=0.0;
		
		for(int i=0; i<numberOfProperties; i++)
		{
			total+=property[i].getRentAmount();
		}
		return total;
	}
	
	/**
	 * 
	 * @return the name of the most expensive property
	 */
	public Property getHighestRentProperty()
	{
		double max=property[0].getRentAmount();
		Property maxProp=property[0];
		for (int i=0; i<numberOfProperties; i++)
		{
			if (property[i].getRentAmount()>max)
			{
				max=property[i].getRentAmount();
				maxProp=property[i];
			}
		}
		return maxProp;
	}
	
	/**
	 * Removes the last property from the list
	 */
	public void removeLastProperty()
	{
		if (numberOfProperties>0)
		{
			property[numberOfProperties-1]=null;
			numberOfProperties--;
		}
	}
	
	/**
	 * 
	 * @return Boolean reflecting property list fill status
	 */
	public boolean isPropertiesFull()
	{
		if (numberOfProperties==MAX_PROPERTY)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return number of properties created
	 */
	
	public int getPropertiesCount()
	{
		return numberOfProperties;
	}
	
	/**
	 * 
	 * @return Boolean reflecting if management fee is a valid percent value (0-100)
	 */
	public boolean isManagementFeeValid()
	{
		if(percent >=0 && percent<=100)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * @return summary of information from methods
	 */
	public String toString() {
	    String returnText = "List of the properties for " + name + ", taxID: " + taxID + "\n";
	    returnText += "______________________________________________________\n";
	    
	    for (int i = 0; i < numberOfProperties; i++) {
	        if (property[i] != null) {
	            returnText += property[i].toString() + "\n";
	        }
	    }
	    
	    returnText += "______________________________________________________\n\n";
	    
	    double totalRent = getTotalRent();
	    double managementFee = totalRent * (percent / 100.0);
	    
	    returnText += " total management Fee: " + managementFee;
	    
	    return returnText;
	}

	
}
