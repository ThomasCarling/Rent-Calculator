package data.checkvalidity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDecimalPlacesTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testTo2DP_ValidDouble() {
	double expected = 21.23;
	double result = TwoDecimalPlaces.to2DP(21.2312);
	assertEquals(expected, result, 0.0001);

	expected = -102.47;
	result = TwoDecimalPlaces.to2DP(-102.465012);
	assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testTo2DP_ValidString() {
	double expected = 21.23;
	double result = TwoDecimalPlaces.to2DP("21.2312");
	assertEquals(expected, result, 0.0001);

	expected = -102.47;
	result = TwoDecimalPlaces.to2DP("-102.465012");
	assertEquals(expected, result, 0.0001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testTo2DP_invalidString() {
	TwoDecimalPlaces.to2DP("hello1.5");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testTo2DP_emptyString() {
	TwoDecimalPlaces.to2DP("");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testTo2DP_null() {
	TwoDecimalPlaces.to2DP(null);
    }

}
