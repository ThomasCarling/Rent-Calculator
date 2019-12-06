package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;

import control.listeners.MyListener;
import control.logic.UserInterface;

/**
 * Class to contain and control all of the elements of my gui.
 */
public class GuiControl implements UserInterface {

    JFrame mainFrame;
    Menu menu;
    BillForm billForm;
    BillList billList;
    
    public GuiControl() {
	/* prep mainFrame */
	mainFrame = new JFrame("Rent Calculator");
	mainFrame.setLayout(new BorderLayout());
	mainFrame.setSize(500, 400);
	mainFrame.setMinimumSize(new Dimension(400, 300));
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	/* initialise components */
	menu = new Menu();
	billForm = new BillForm();
	billList = new BillList();
	
	/* add components to frame*/
	mainFrame.add(menu);
	mainFrame.add(billForm);
	mainFrame.add(billList);
    }
    
    @Override
    public void billDisplayVisible(boolean yes) {
	billList.setVisible(yes);
    }

    @Override
    public void payeeDisplayVisible(boolean yes) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void billInputVisible(boolean yes) {
	billForm.setVisible(yes);
	
    }

    @Override
    public void payeeInputVisible(boolean yes) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void resultFrameVisible(boolean yes) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void setVisible(boolean yes) {
	mainFrame.setVisible(yes);
    }

    @Override
    public void addBillInputListener(MyListener listener) {
	billForm.addListener(listener);
    }

    @Override
    public void addBillDisplayListener(MyListener listener) {
	billList.addListener(listener);
	
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
	menu.addListener(listener);
	
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
