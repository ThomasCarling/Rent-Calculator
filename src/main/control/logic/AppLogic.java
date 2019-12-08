package control.logic;

import java.util.EventObject;
import java.util.List;

import control.datainterfaces.Bill;
import control.eventobjects.CancelEvent;
import control.eventobjects.NewBillEvent;
import control.eventobjects.ShowBillInputEvent;

/**
 * Class to control all of the interactions between my gui and the data it handles.
 * @author Thomas
 *
 */
public class AppLogic {
    public static final int NAME_ERROR = 0;
    public static final int COST_ERROR = 1;
    public static final int DATE_ERROR = 2;
    public static final int EQUAL_SPLIT_ERROR = 3;
    public static final int OVERWRITE_WARNING = 4;
    public static final int NO_PROBLEMS = 5;
    
    private UserData data;
    private UserInterface gui;
    
    private Bill preEditState;
    
    public AppLogic(UserData data, UserInterface gui) {
	this.data = data;
	this.gui = gui;
	setListeners();
	newSession();
	gui.setVisible(true);
    }

    private void newSession() {
	gui.billDisplayVisible(false);
	gui.payeeDisplayVisible(true);
	gui.billInputVisible(true);
	gui.payeeInputVisible(false);
	gui.resultFrameVisible(false);
	data.clear();
    }
    
    private void setListeners() {
	gui.addBillInputListener( event -> billInputEvent(event));
	gui.addBillDisplayListener(event -> billDisplayEvent(event));
	gui.addPayeeInputListener(event -> payeeInputEvent(event));
	gui.addPayeeDisplayListener(event -> payeeDisplayEvent(event));
	gui.addMenuBarListener(event -> menuEvent(event));
	gui.addResultFrameListener(event -> resultFrameEvent(event));
    }

    protected void billInputEvent(EventObject event) {
	if (event instanceof CancelEvent) {
	    gui.billDisplayVisible(true);
	    gui.billInputVisible(false);
	    
	} else if (event instanceof NewBillEvent) {
	    NewBillEvent bill = (NewBillEvent) event;
	    List<Integer> issues = data.checkIsValid(bill);
	    
	    if (issues.contains(NO_PROBLEMS) && issues.size() == 1) {
		Bill newBill = data.newBill(bill);
		gui.clearBillInput();
		gui.addBill(newBill);
		gui.billDisplayVisible(true);
		gui.billInputVisible(false);
	    } else if (issues.contains(OVERWRITE_WARNING) && issues.size() == 1) {
		boolean result = gui.displayConfirmationBox("Are you sure you want to overwrite "
			+ "the old " + bill.getName() + " bill?", "Overwrite Warning");
		if (result == true) {
		    Bill billAmmend = data.ammendBill(bill);
		    gui.clearBillInput();
		    gui.ammendBill(billAmmend);
		    gui.billDisplayVisible(true);
		    gui.billInputVisible(false);
		}
	    } else {
		issues.remove((Object)OVERWRITE_WARNING);
		gui.displayErrorMessage(issues);
	    }
	}
    }
    
    protected void billDisplayEvent(EventObject event) {
   	if (event instanceof ShowBillInputEvent) {
   	    gui.billInputVisible(true);
   	    gui.billDisplayVisible(false);
   	}
   	
    }
    
    protected void payeeInputEvent(EventObject event) {
	
    }
    
    protected void payeeDisplayEvent(EventObject event) {
	
    }
    
    protected void menuEvent(EventObject event) {
	
    }
    
    protected void resultFrameEvent(EventObject event) {
	
    }
}
