package control.logic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.eventobjects.CancelEvent;
import control.eventobjects.NewBillEvent;
import control.listeners.MyListener;

public class AppLogicTest {

    AppLogic testLogic;
    MockUserData mockData;
    MockUserInterface mockGui;
    
    @Before
    public void setUp() throws Exception {
	mockData = new MockUserData();
	mockGui = new MockUserInterface();
	testLogic = new AppLogic(mockData, mockGui);
    }

    @After
    public void tearDown() throws Exception {
	testLogic = null;
    }

    @Test
    public void testBillInputEvent_Cancel() {
	testLogic.billInputEvent(new CancelEvent(this));
	assertTrue(mockGui.displayVisible);
	assertFalse(mockGui.formVisible);
    }
    
    @Test
    public void testBillInputEvent_EnterBillValid() {
	mockData.errorList = new ArrayList<>();
	mockData.errorList.add(AppLogic.NO_PROBLEMS);
	testLogic.billInputEvent(new NewBillEvent(this, "one", "two", "three", false));
	
    }

    @Test
    public void testBillDisplayEvent() {
	fail("Not yet implemented"); // TODO
    }

    @Test
    public void testPayeeInputEvent() {
	fail("Not yet implemented"); // TODO
    }

    @Test
    public void testPayeeDisplayEvent() {
	fail("Not yet implemented"); // TODO
    }

    @Test
    public void testMenuEvent() {
	fail("Not yet implemented"); // TODO
    }

    @Test
    public void testResultFrameEvent() {
	fail("Not yet implemented"); // TODO
    }

}

class MockUserData implements UserData {

    public List<Integer> errorList;
    public List<NewBillEvent> bills = new ArrayList<>();
    
    @Override
    public void clear() {
	bills.clear();
	
    }

    @Override
    public List<Integer> checkIsValid(NewBillEvent event) {
	return errorList;
    }

    @Override
    public void newBill(NewBillEvent bill) {
	this.bills.add(bill);
	
    }
    
}

class MockUserInterface implements UserInterface {

    public boolean guiVisible;
    public boolean displayVisible;
    public boolean formVisible;
    public boolean formClear;
    public boolean resultVisible;
    
    @Override
    public void billDisplayVisible(boolean yes) {
	displayVisible = yes;
    }

    @Override
    public void payeeDisplayVisible(boolean yes) {
	displayVisible = yes;
	
    }

    @Override
    public void billInputVisible(boolean yes) {
	formVisible = yes;
	
    }

    @Override
    public void payeeInputVisible(boolean yes) {
	formVisible = yes;
	
    }

    @Override
    public void resultFrameVisible(boolean yes) {
	resultVisible = yes;
    }

    @Override
    public void setVisible(boolean yes) {
	guiVisible = yes;
	
    }

    @Override
    public void addBillInputListener(MyListener listener) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void addBillDisplayListener(MyListener listener) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void addPayeeInputListener(MyListener listener) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void addPayeeDisplayListener(MyListener listener) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void addMenuBarListener(MyListener listener) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void addResultFrameListener(MyListener listener) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void displayErrorMessage(List<Integer> issues) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void clearBillInput() {
	// TODO Auto-generated method stub
	
    }
    
}