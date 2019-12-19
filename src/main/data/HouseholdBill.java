package data;

import control.datainterfaces.Bill;
import data.format.DateOfMonth;
import data.format.Pounds;

/**
 * A class to store information about a specific bill, such as rent or electricity.
 * @author Thomas
 *
 */
public class HouseholdBill implements Bill{
    private String name;
    private double cost;
    private int date;
    private boolean equallySplit;

    public HouseholdBill(String name, double cost, int date, boolean split) {
	this.name = name;
	this.cost = cost;
	this.date = date;
	this.equallySplit = split;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }
    
    public String getStringCost() {
	return Pounds.toGBP(cost);
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDate() {
        return date;
    }
    
    public String getStringDate() {
	return DateOfMonth.toString(date);
    }

    public void setDate(int date) {
        this.date = date;
    }

    public boolean isEquallySplit() {
        return equallySplit;
    }

    public void setEquallySplit(boolean equallySplit) {
        this.equallySplit = equallySplit;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!(obj instanceof Bill))
	    return false;
	Bill other = (Bill) obj;
	if (name == null) {
	    if (other.getName() != null)
		return false;
	} else if (!name.equals(other.getName()))
	    return false;
	return true;
    }


}
