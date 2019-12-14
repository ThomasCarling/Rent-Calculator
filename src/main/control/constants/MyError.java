package control.constants;

/**
 * Enum to store all of the potential user errors, as well as
 * associated messages to show them.
 * 
 * @author Thomas
 *
 */
public enum MyError {
    /**
     * Indicate no problems.
     */
    NA(""),
    
    /**
     * Indicate an error with a Bill name.
     */
    NAME("Bill must have a name."),
    
    /**
     * Indicate an error with a date.
     */
    DATE("Date must be between 1st and 31st."),
    
    /**
     * Indicate an error with a monetary value.
     */
    COST("Price must be a valid GBP value."),
    
    /**
     * Indicate that a new Bill will overwrite an old one.
     */
    OVERWRITE("Are you sure you want to overwrite the old version of this bill?");
    
    /**
     * The message to display to the user when such an error occurs.
     */
    public final String message;
    
    private MyError(String message) {
	this.message = message;
    }
}
