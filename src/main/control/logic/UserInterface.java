package control.logic;

import java.util.List;

import control.constants.MyError;
import control.datainterfaces.Bill;
import control.listeners.MyListener;

/***
 * Interface that must be implemented by any graphical user interface passed into AppLogic
 * @author Thomas
 *
 */
public interface UserInterface {

    /**
     * Method to set whether a display of existing Bills is visible.
     * @param yes true if it is, false if it isn't.
     */
    public void billDisplayVisible(boolean yes);

    /**
     * Method to set whether a display of existing Payees is visible.
     * @param yes true if it is, false if it isn't.
     */
    public void payeeDisplayVisible(boolean yes);

    /**
     * Method to set whether a Bill input form is visible.
     * @param yes true if it is, false if it isn't.
     */
    public void billInputVisible(boolean yes);

    /**
     * Method to set whether a Payee input form is visible.
     * @param yes true if it is, false if it isn't.
     */
    public void payeeInputVisible(boolean yes);

    /**
     * Method to set whether a result frame is visible.
     * @param yes true if it is, false if it isn't.
     */
    public void resultFrameVisible(boolean yes);

    /**
     * Method to set whether this UserInterface is visible.
     * @param yes true if it is, false if it isn't
     */
    public void setVisible(boolean yes);

    /**
     * Method to set a listener for the Bill input form.
     * @param listener the listener to set.
     */
    public void addBillInputListener(MyListener listener);

    /**
     * Method to set a listener for the Bill display.
     * @param listener the listener to set.
     */
    public void addBillDisplayListener(MyListener listener);

    /**
     * Method to set a listener for the Payee input form.
     * @param listener the listener to set.
     */
    public void addPayeeInputListener(MyListener listener);

    /**
     * Method to set a listener for the Payee display.
     * @param listener the listener to set.
     */
    public void addPayeeDisplayListener(MyListener listener);

    /**
     * Method to set a listener for the MenuBar.
     * @param listener the listener to set.
     */
    public void addMenuBarListener(MyListener listener);

    /**
     * Method to set a listener for the result frame.
     * @param listener the listener to set.
     */
    public void addResultFrameListener(MyListener listener);

    /**
     * Method to prompt the gui to display an error message.
     * @param a list of each type of error, defined as a MyError.
     */
    public void displayErrorMessage(List<MyError> issues);

    /**
     * Method to prompt the gui to get confirmation from the user before
     * making a change.
     * @param message the message to display, as a String.
     * @param title the title of the dialogue box.
     * @return a boolean, true if the user confirms, false if not.
     */
    public boolean displayConfirmationBox(String message, String title);
    
    /**
     * Method to clear the contents of the Bill input form.
     */
    public void clearBillInput();

    /**
     * Method to indicate a new Bill which the gui should display in the bill list.
     * @param newBill the new Bill to display.
     */
    public void addBill(Bill newBill);

    public void ammendBill(Bill billAmmend);
}
