package control.datainterfaces;

/**
 * Interface to define the behaviour of a bill.
 * @author Thomas
 *
 */
public interface Bill {

    public boolean isEquallySplit();
    
    public String getName();
    
    public int getDate();

    public String getStringDate();

    public String getStringCost();

    @Override
    int hashCode();

    @Override
    boolean equals(Object obj);
    
}
