package control.eventobjects;

import java.util.EventObject;

/***
 * Event that indicates the gui should display the bill input form.
 * @author Thomas
 *
 */
public class ShowBillInputEvent extends EventObject {

    private static final long serialVersionUID = -8897935940282598814L;

    public ShowBillInputEvent(Object source) {
	super(source);
    }

}
