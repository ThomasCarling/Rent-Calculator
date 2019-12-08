package control.logic;

import java.util.List;

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
     * error messages if any input is invalid.
     * @param event the NewBillEvent to check.
     * @return a list of messages, defined as constants in AppLogic.
     */
    public List<Integer> checkIsValid(NewBillEvent event);

    /**
     * Method to add a new bill, which should be created from a NewBillEvent.
     * @param bill the NewBillEvent to turn into a bill.
     * @return Bill, the new Bill that has been added.
     */
    public Bill newBill(NewBillEvent bill);

    /**
     * Method to ammend an old Bill, which should assertain which Bill it is ammending,
     * then change the fields of the said bill.
     * @param bill
     * @return
     */
    public Bill ammendBill(NewBillEvent bill);

}
