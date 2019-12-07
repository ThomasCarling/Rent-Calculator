package data;

/**
 * A class to store information about a specific bill, such as rent or electricity.
 * @author Thomas
 *
 */
public class HouseholdBill {
    String name;
    double cost;
    int date;
    boolean equallySplit;

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

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDate() {
        return date;
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
	if (!(obj instanceof HouseholdBill))
	    return false;
	HouseholdBill other = (HouseholdBill) obj;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

}
