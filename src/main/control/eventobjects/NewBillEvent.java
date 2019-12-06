package control.eventobjects;

import java.util.EventObject;

/**
 * An EventObject containing information about a new Bill.
 * @author Thomas
 *
 */
public class NewBillEvent extends EventObject {

    private static final long serialVersionUID = 5476155857332098709L;
    private String name;
    private String cost;
    private String date;
    private boolean equallySplit;
    
    /**
     * Creates a new instance of a NewBillEvent, with information about the new bill to be created.
     * @param source the Object on which the event initially occurred.
     * @param name the name of the new bill.
     * @param cost the total cost of the new bill.
     * @param date the date of the month on which the bill must be paid.
     * @param equallySplit whether or not the bill is split equally between the tenants.
     */
    public NewBillEvent(Object source, String name, String cost, String date, boolean equallySplit) {
	super(source);
	this.name = name;
	this.cost = cost;
	this.date = date;
	this.equallySplit = equallySplit;
    }

    /***
     * Method to return the name.
     * @return a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Method to return the cost.
     * @return a String.
     */
    public String getCost() {
        return cost;
    }

    /**
     * Method to return the date.
     * @return a String.
     */
    public String getDate() {
        return date;
    }
    
    /**
     * Method to return whether or not a bill is equally split.
     * @return a boolean.
     */
    public boolean isEquallySplit() {
        return equallySplit;
    }

}
