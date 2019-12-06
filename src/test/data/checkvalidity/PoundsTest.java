package data.checkvalidity;

import static org.junit.Assert.*;

import org.junit.Test;

public class PoundsTest {

    @Test
    public void testToGBP_0() {
	String expected = "£0.00";
	String actual = Pounds.toGBP(0);
	assertEquals(expected, actual);
    }
    @Test
    public void testToGBP_Valid() {
	String expected = "£14.26";
	String actual = Pounds.toGBP(14.2573);
	assertEquals(expected, actual);

	expected = "£2.30";
	actual = Pounds.toGBP(2.3);
	assertEquals(expected, actual);

	expected = "£20.00";
	actual = Pounds.toGBP(20);
	assertEquals(expected, actual);
    }

    @Test
    public void testToGBP_Negative() {
	String expected = "-£15.38";
	String actual = Pounds.toGBP(-15.376);
	assertEquals(expected, actual);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testToDouble_Null() {
	Pounds.toDouble(null);
    }
    
    @Test
    public void testToDouble_0() {
	double expected = 0.0;
	double actual = Pounds.toDouble("0.00");
	assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testToDouble_LotsOfDecimalPoints() {
	double expected = 15.25;
	double actual = Pounds.toDouble("15.24671473");
	assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testToDouble_poundSign() {
	double expected = 12.37;
	double actual = Pounds.toDouble("£12.37");
	assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testToDouble_negativepoundSign() {
	double expected = -2.3;
	double actual = Pounds.toDouble("-£2.30");
	assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testToDouble_wrongPlaceNegativeSign() {
	double expected = -27.0;
	double actual = Pounds.toDouble("£-27.00");
	assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testToDouble_NoDecimal() {
	double expected = 15.0;
	double actual = Pounds.toDouble("15");
	assertEquals(expected, actual, 0.001);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testToDouble_WrongSign() {
	Pounds.toDouble("$27.6");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testToDouble_NotANumber() {
	Pounds.toDouble("TE3g1.t4h");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testToDouble_TwoDecimalPoints() {
	Pounds.toDouble("15.235.1");
    }
    @Test (expected = IllegalArgumentException.class)
    public void testToDouble_onlySpace() {
	Pounds.toDouble("     ");
    }
}
