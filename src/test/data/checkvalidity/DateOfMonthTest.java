package data.checkvalidity;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import data.format.DateOfMonth;

public class DateOfMonthTest {

    @Test
    public final void testToString_stResults() {
	String expectedResult = "1st";
	String result = DateOfMonth.toString(1);
	assertEquals(expectedResult, result);

	expectedResult = "31st";
	result = DateOfMonth.toString(31);
	assertEquals(expectedResult, result);
    }

    @Test
    public final void testToString_thResults() {
	String expectedResult = "4th";
	String result = DateOfMonth.toString(4);
	assertEquals(expectedResult, result);

	expectedResult = "10th";
	result = DateOfMonth.toString(10);
	assertEquals(expectedResult, result);

	expectedResult = "12th";
	result = DateOfMonth.toString(12);
	assertEquals(expectedResult, result);

	expectedResult = "25th";
	result = DateOfMonth.toString(25);
	assertEquals(expectedResult, result);
    }

    @Test
    public final void testToString_ndResults() {
	String expectedResult = "2nd";
	String result = DateOfMonth.toString(2);
	assertEquals(expectedResult, result);

	expectedResult = "22nd";
	result = DateOfMonth.toString(22);
	assertEquals(expectedResult, result);
    }
    
    @Test
    public final void testToString_rdResults() {
	String expectedResult = "3rd";
	String result = DateOfMonth.toString(3);
	assertEquals(expectedResult, result);

	expectedResult = "23rd";
	result = DateOfMonth.toString(23);
	assertEquals(expectedResult, result);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testToString_tooHigh() {
	DateOfMonth.toString(32);
    }

    @Test (expected = IllegalArgumentException.class)
    public final void testToString_wayTooHigh() {
	DateOfMonth.toString(132);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testToString_tooLow() {
	DateOfMonth.toString(0);
    }

    @Test (expected = IllegalArgumentException.class)
    public final void testToString_wayTooLow() {
	DateOfMonth.toString(-32);
    }

    @Test
    public final void testToInt_validDate() {
	int expected = 31;
	int result = DateOfMonth.toInt("31st");
	assertEquals(expected, result);
	
	expected = 27;
	result = DateOfMonth.toInt("27th");
	assertEquals(expected, result);
	
	expected = 22;
	result = DateOfMonth.toInt("22nd");
	assertEquals(expected, result);
	
	expected = 3;
	result = DateOfMonth.toInt("3rd");
	assertEquals(expected, result);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testToInt_tooHigh() {
	DateOfMonth.toInt("32nd");
    }

    @Test (expected = IllegalArgumentException.class)
    public final void testToInt_tooLow() {
	DateOfMonth.toInt("0th");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testToInt_stWrongEnding() {
	DateOfMonth.toInt("2st");
    }

    @Test (expected = IllegalArgumentException.class)
    public final void testToInt_ndWrongEnding() {
	DateOfMonth.toInt("12nd");
    }

    @Test (expected = IllegalArgumentException.class)
    public final void testToInt_rdWrongEnding() {
	DateOfMonth.toInt("21rd");
    }

    @Test (expected = IllegalArgumentException.class)
    public final void testToInt_thWrongEnding() {
	DateOfMonth.toInt("1th");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testToInt_notADate() {
	DateOfMonth.toInt("!");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testToInt_notADateTwoDigits() {
	DateOfMonth.toInt("QA");
    }

    @Test (expected = IllegalArgumentException.class)
    public final void testToInt_notADateFourDigits() {
	DateOfMonth.toInt("1234");
    }
}
