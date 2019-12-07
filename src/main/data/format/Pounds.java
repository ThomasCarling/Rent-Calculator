package data.format;

/**
 * Class to handle conversions between doubles and String 
 * representations of GBP values.
 * 
 * @author Thomas
 *
 */
public class Pounds {

    public static String toGBP(double value) {
	String result;
	if (value < 0) {
	    value *= -1;
	    result = "-£";
	} else {
	    result = "£";
	}
	value = TwoDecimalPlaces.to2DP(value);
	result += value;
	int length = result.length();
	int decimalPoint = result.indexOf(".");
	if (decimalPoint == -1) {
	    return result + ".00";
	} else if (length - decimalPoint == 2) {
	    return result + "0";
	} else {
	    return result;
	}
    }

    /**
     * Method to convert a value in GBP to a double.
     * @param GBP the String to convert.
     * @return the String converted to a double.
     * @throws IllegalArgumentException If the String isn't a valid value.
     */
    public static double toDouble(String GBP) throws IllegalArgumentException {
	if (GBP == null) {
	    throw new IllegalArgumentException();
	}
	GBP.trim();
	if (GBP.contains(" ")) {
	    throw new IllegalArgumentException();
	}
	int poundIndex = GBP.indexOf("£");
	int negativeIndex = GBP.indexOf("-");
	if (poundIndex > 1 || negativeIndex > 1) {
	    throw new IllegalArgumentException();
	}
	if (poundIndex > -1) {
	    GBP = GBP.substring(0, poundIndex) + GBP.substring(poundIndex + 1);
	}
	try {
	    double result = Double.parseDouble(GBP);
	    result = TwoDecimalPlaces.to2DP(result);
	    return result;
	} catch(Exception e) {
	    throw new IllegalArgumentException();
	}
    }

}
