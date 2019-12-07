package data.checkvalidity;

import static org.junit.Assert.*;

import org.junit.Test;

import data.format.NameCapitalisation;

public class NameCapitalisationTest {

    @Test
    public void testAlreadyValid() {
	String expected = "Thomas";
	String actual = NameCapitalisation.correct("Thomas");
	assertEquals(expected, actual);
    }
    
    @Test
    public void testLowerCase() {
	String expected = "Thomas";
	String actual = NameCapitalisation.correct("thomas");
	assertEquals(expected, actual);
    }
    
    @Test
    public void testUpperCase() {
	String expected = "Thomas";
	String actual = NameCapitalisation.correct("THOMAS");
	assertEquals(expected, actual);
    }
    
    @Test
    public void testTwoWords() {
	String expected = "Thomas Carling";
	String actual = NameCapitalisation.correct("tHoMaS cArLing");
	assertEquals(expected, actual);
    }
    
    @Test
    public void testTwoWords_weirdGaps() {
	String expected = "Thomas Carling";
	String actual = NameCapitalisation.correct("    tHoMaS     cArLing     ");
	assertEquals(expected, actual);
    }
    
    @Test
    public void testNumbers() {
	String expected = "1234thomas Carling";
	String actual = NameCapitalisation.correct("1234tHoMaS     cArLing");
	assertEquals(expected, actual);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testEmpty() {
	NameCapitalisation.correct("    ");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testNull() {
	NameCapitalisation.correct(null);
    }
}
