package control.eventobjects;

import java.util.EventObject;

import control.datainterfaces.Bill;

public class EditEvent extends EventObject {

    private static final long serialVersionUID = -1452425506220375869L;
    private Bill bill;
    
    public EditEvent(Object source, Bill toEdit) {
	super(source);
	this.bill = toEdit;
    }

    public Bill getBill() {
	return bill;
    }

}
