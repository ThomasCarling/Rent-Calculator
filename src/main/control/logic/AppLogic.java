package control.logic;

import java.util.EventObject;
import java.util.List;

import control.constants.InputType;
import control.constants.MyError;
import control.datainterfaces.Bill;
import control.eventobjects.CancelEvent;
import control.eventobjects.EditEvent;
import control.eventobjects.NewBillEvent;
import control.eventobjects.InputFormEvent;

/**
 * Class to control all of the interactions between my gui and the data it handles.
 * @author Thomas
 *
 */
public class AppLogic {
    
    private UserData data;
    private UserInterface gui;
    
    Bill preEditBill;
    
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
	gui.billInputVisible(true, InputType.NEW);
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
	    gui.billInputVisible(false, InputType.NA);
	    
	} else if (event instanceof NewBillEvent) {
	    InputType type = gui.getBillInputType();
	    NewBillEvent bill = (NewBillEvent) event;
	    List<MyError> issues = data.checkIsValid(bill);
	    
	    if (issues.contains(MyError.NA) && issues.size() == 1) {
		if (gui.getBillInputType() == InputType.NEW) {
		    Bill newBill = data.createBill(bill);
		    data.addBill(newBill);
		    gui.addBill(newBill);
		    gui.clearBillInput();
		    gui.billDisplayVisible(true);
		    gui.billInputVisible(false, InputType.NA);
		} else if (gui.getBillInputType() == InputType.EDIT) {
		    issues.clear();
		    issues.add(MyError.OVERWRITE);
		}
		
	    } 
	    if (issues.contains(MyError.OVERWRITE) && issues.size() == 1) {
		boolean result = gui.displayConfirmationBox(MyError.OVERWRITE.message, "Overwrite Warning");
		if (result == true) {
		    Bill newBill = data.createBill(bill);
		    if (preEditBill == null) {
			preEditBill = data.getBill(newBill.getName());
		    }
		    data.amendBill(newBill, preEditBill);
		    gui.amendBill(newBill, preEditBill);
		    gui.clearBillInput();
		    gui.billDisplayVisible(true);
		    gui.billInputVisible(false, InputType.NA);
		}
	    } 
	    issues.remove(MyError.OVERWRITE);
	    issues.remove(MyError.NA);
	    if (issues.size() > 0){
		gui.displayErrorMessage(issues);
	    }
	}
    }
    
    protected void billDisplayEvent(EventObject event) {
   	if (event instanceof InputFormEvent) {
   	    gui.billInputVisible(true, InputType.NEW);
   	    gui.billDisplayVisible(false);
   	} else if (event instanceof EditEvent) {
   	    preEditBill = ((EditEvent) event).getBill();
   	    gui.displayForBillInput(preEditBill);
   	    gui.billInputVisible(true, InputType.EDIT);
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
