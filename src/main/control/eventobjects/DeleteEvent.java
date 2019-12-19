package control.eventobjects;

import java.util.EventObject;

/**
 * EventObject to indicate an object should be deleted.
 * @author Thomas
 *
 */
public class DeleteEvent extends EventObject {

    private static final long serialVersionUID = -210719145207963332L;

    public DeleteEvent(Object source) {
	super(source);
    }

}
