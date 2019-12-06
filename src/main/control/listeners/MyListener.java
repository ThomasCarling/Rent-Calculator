package control.listeners;

import java.util.EventListener;
import java.util.EventObject;

/**
 * A multi-purpose event listener
 * TODO : find out why nobody else seems to use a single event listener class, 
 * and instead create different ones for each EventObject....
 * @author Thomas
 *
 */
public interface MyListener extends EventListener {
    public void eventOccurred(EventObject e);
}
