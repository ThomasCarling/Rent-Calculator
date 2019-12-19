package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import control.constants.InputType;
import control.constants.MyError;
import control.datainterfaces.Bill;
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
	
	/* setting sizes */
	Dimension dim = billForm.getPreferredSize();
	dim.width = 350;
	billForm.setPreferredSize(dim);
	
	dim = billList.getPreferredSize();
	dim.width = 350;
	billList.setPreferredSize(dim);
	
	/* add menu to frame*/
	mainFrame.add(menu);
    }
    
    @Override
    public void billDisplayVisible(boolean yes) {
	if (yes) {
	    mainFrame.add(billList, BorderLayout.WEST);
	    } else {
		mainFrame.remove(billList);
	    }
	billList.setVisible(yes);
    }
    
    @Override
    public void payeeDisplayVisible(boolean yes) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void billInputVisible(boolean yes, InputType type) {
	if (yes) {
	    billForm.setInputType(type);
	    mainFrame.add(billForm, BorderLayout.WEST);
	    } else {
		mainFrame.remove(billForm);
	    }
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
	//menu.addListener(listener);
	
    }

    @Override
    public void addResultFrameListener(MyListener listener) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void displayErrorMessage(List<MyError> issues) {
	String message = "";
	for (MyError error : issues) {
	    message = message.concat(error.message + "\n");
	}
	JOptionPane.showMessageDialog(mainFrame, message, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void clearBillInput() {
	billForm.clear();
    }

    @Override
    public boolean displayConfirmationBox(String message, String title) {
	if (JOptionPane.showConfirmDialog(mainFrame, message, title, 
		JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)
		== JOptionPane.YES_OPTION) {
	    return true;
	} else {
	    return false;
	}
    }

    @Override
    public void addBill(Bill newBill) {
	billList.addBill(newBill);
	
    }

    @Override
    public void amendBill(Bill billAmend, Bill preAmendBill) {
	billList.amendBill(billAmend, preAmendBill);
    }

    @Override
    public InputType getBillInputType() {
	return billForm.getInputType();
    }

    @Override
    public void displayForBillInput(Bill toDisplay) {
	billForm.setText(toDisplay);
	
    }

}
