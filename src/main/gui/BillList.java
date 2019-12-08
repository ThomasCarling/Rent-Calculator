package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import control.datainterfaces.Bill;
import control.eventobjects.ShowBillInputEvent;
import control.listeners.MyListener;

public class BillList extends JPanel{
    private MyListener listener;
    private JTextArea text;
    private JButton newBillButton;
    private DefaultListModel<String> nameListModel;
    private JList<String> nameList;
    private HashMap<String, Bill> bills;

    private static final long serialVersionUID = -2851676421942420560L;


    public BillList() {
	super();
	setLayout(new BorderLayout());

	/* initialise variables */
	text = new JTextArea();
	newBillButton = new JButton("Add new bill");
	nameListModel = new DefaultListModel<>();
	nameList = new JList<>(nameListModel);
	bills = new HashMap<>();

	/* figure each components settings */
	text.setEditable(false);
	nameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	/* set sizes */
	Dimension dim = text.getPreferredSize();
	dim.width = 250;
	text.setPreferredSize(dim);

	dim = nameList.getPreferredSize();
	dim.width = 100;
	nameList.setPreferredSize(dim);

	/*sort listeners */
	nameList.addListSelectionListener(e -> {
	    String name = nameList.getSelectedValue();
	    Bill myBill = bills.get(name);
	    String equal = myBill.isEquallySplit() ? "equally" : "unequally";
	    text.setText(myBill.getName() + " Bill,\n total cost "+ myBill.getStringCost() 
	    + ",\n due on the " + myBill.getStringDate() + " of each month,\n split " + 
	    equal + " between tenants.");
	});
	
	newBillButton.addActionListener(e -> {
	    listener.eventOccurred(new ShowBillInputEvent(newBillButton));
	});

	/* and add each component */
	add(new JScrollPane(text), BorderLayout.EAST);
	add(nameList, BorderLayout.WEST);
	add(newBillButton, BorderLayout.SOUTH);
	

    }


    public void addListener(MyListener listener) {
	this.listener = listener;
    }


    public void addBill(Bill newBill) {
	nameListModel.addElement(newBill.getName());
	bills.put(newBill.getName(), newBill);
    }

}
