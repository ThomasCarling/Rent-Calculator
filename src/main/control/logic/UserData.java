package control.logic;

import java.util.List;

import control.constants.MyError;
import control.datainterfaces.Bill;
import control.eventobjects.NewBillEvent;

/** 
 * An interface that must be implemented by any class handling the data and user
 * input for AppLogic.
 * @author Thomas
 *
 */
public interface UserData {

    /**
     * Method to reset the value of each field in UserData. Should not effect
     * long term memory, however that is implemented, but will clear all of the
     * data in the current session that hasn't been explicitly saved.
     */
    public void clear();

    /**
     * Method to check a new bill, and validate each field, returning 
     * errors if anything is invalid.
     * @param event the NewBillEvent to check.
     * @return a list of MyError's.
     */
    public List<MyError> checkIsValid(NewBillEvent event);

    /**
     * Method to create a new bill, which should be created from a NewBillEvent.
     * @param bill the NewBillEvent to turn into a bill.
     * @return Bill, the new Bill from the Event.
     */
    public Bill createBill(NewBillEvent bill);

    /**
     * Method to add a new Bill to the list of stored bills.
     * @param toAdd the bill to add.
     */
    public void addBill(Bill toAdd);
    /**
     * Method to edit an existing bill.
     * @param changedBill the new version to add.
     * @param oldBill the old version to remove.
     */
    public void amendBill(Bill changedBill, Bill oldBill);
    
    /**
     * Method to return an existing bill.
     * @param name the name of the bill to return.
     * @return the specified bill.
     */
    public Bill getBill(String name);

}
