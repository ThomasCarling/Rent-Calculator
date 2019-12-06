package control.eventobjects;

import java.util.EventObject;

/***
 * Event that indicates the desire to cancel the current process.
 * @author Thomas
 *
 */
public class CancelEvent extends EventObject {

    private static final long serialVersionUID = -829025646385494764L;

    public CancelEvent(Object source) {
	super(source);
    }

}
