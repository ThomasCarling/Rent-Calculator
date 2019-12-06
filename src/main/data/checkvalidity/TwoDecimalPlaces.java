package data.checkvalidity;

/**
 * Class to convert a number to two decimal places.
 * 
 * @author Thomas
 *
 */
public class TwoDecimalPlaces {
    
    /**
     * Method to convert a value to two decimal places.
     * 
     * @param value the double to convert.
     * @return a double, to two decimal places.
     */
    public static double to2DP(double value) {
	value *= 100;
	value = Math.round(value);
	value /= 100;
	return value;
    }
    
    /**
     * Method to convert a value to two decimal places.
     * 
     * @param value the String to convert.
     * @return a double, to two decimal places.
     * @throws IllegalArgumentException if value is null, or not a number.
     */
    public static double to2DP (String value) throws IllegalArgumentException {
	try {
	    return to2DP(Double.parseDouble(value));
	} catch(Exception e) {
	    throw new IllegalArgumentException();
	}
	
    }
}
