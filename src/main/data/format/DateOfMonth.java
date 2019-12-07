package data.format;

/**
 * Class to convert a number to a date of the month, and vice versa,
 * as well as check that an int or String is a valid date of the month.
 * @author Thomas
 *
 */
public class DateOfMonth {

    /**
     * Method to convert a number to a String representation of a date.
     * @param date the int to convert, must be between 1 and 31.
     * @return a String in the format 00LL or 0LL, where 0 represents a number and L a letter.
     */
    public static String toString(int date) {
	
	/* Check is valid */
	if (date > 31 || date < 1) {
	    throw new IllegalArgumentException("date must be between 1 and 31");
	}

	/* then return a String with correct ending added*/
	if (date == 1 || date == 21 || date == 31) {
	    return date + "st";
	} else if (date == 2 || date == 22) {
	    return date + "nd";
	} else if (date == 3 || date == 23) {
	    return date + "rd";
	} else {
	    return date + "th";
	}
    }

    /**
     * Method to convert a String representation of a date to a number.
     * @param date the String to convert, must be a date in the format 00LL or 0LL, 
     * where 0 represents a number and L a letter.
     * @return the date as a number.
     */
    public static int toInt(String date) {
	try {
	    
	    int digits = Integer.parseInt(date.substring(0, date.length() - 2));
	    if (digits > 31 || digits < 1) {
		throw new IllegalArgumentException("date must be between 1st and 31st");
	    }
	    
	    /*checks that the date is correct by passing the value of digits into toString, and 
	     * comparing the result with the date argument*/
	    String checkEnding = toString(digits);
	    if (!checkEnding.equals(date)) {
		throw new IllegalArgumentException("date ending is incorrect, should be " + checkEnding + ".");
	    }
	    return digits;
	} catch (StringIndexOutOfBoundsException e) {
	    throw new IllegalArgumentException("date must be a valid date between 1st and 31st");
	}
    }

    /**
     * Method to check that a String is a valid date of the month.
     * @param date the String to check.
     * @return true if it is a date, false if it isn't.
     */
    public static boolean isValid(String date) {
	try {
	    toInt(date);
	    return true;
	} catch (IllegalArgumentException e) {
	    return false;
	}
    }
    
    /**
     * Method to check that a number is a valid date of the month.
     * @param date the int to check.
     * @return true if it is a date, false if it isn't.
     */
    public static boolean isValid(int date) {
	try {
	    toString(date);
	    return true;
	} catch (IllegalArgumentException e) {
	    return false;
	}
    }
}
