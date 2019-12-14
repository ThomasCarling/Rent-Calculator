package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.util.stream.IntStream;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import control.eventobjects.NewBillEvent;
import control.listeners.MyListener;
import data.format.DateOfMonth;

public class BillForm extends JPanel{

    private static final long serialVersionUID = 1424959384333732666L;

    private MyListener billListener;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel costLabel;
    private JTextField costField;
    private JLabel dateLabel;
    private JComboBox<String> dateList;
    private JLabel equalSplitLabel;
    private JCheckBox equalSplitBox;
    private JButton enterButton;

    /**
     * Creates a new instance of a BillForm.
     */
    public BillForm() {
	
	/* setup datelist*/
	String[] dates = IntStream.rangeClosed(1, 31).boxed().map(DateOfMonth::toString).toArray(String[]::new);
	ComboBoxModel<String> comboModel = new DefaultComboBoxModel<>(dates);
	
	///////////////* initialising all of the fields *////////////////
	nameLabel = new JLabel("Bill type :");
	nameField = new JTextField();
	costLabel = new JLabel("Total cost :");
	costField = new JTextField();
	dateLabel = new JLabel("Date to pay :");
	dateList = new JComboBox<>(comboModel);
	dateList.setSelectedIndex(0);
	equalSplitLabel = new JLabel("Split equally? : ");
	equalSplitBox = new JCheckBox();
	enterButton = new JButton("Enter");

	//////* adding an ActionListener to the enterButton *//////////////
	enterButton.addActionListener( al -> {
	    String name = nameField.getText();
	    String cost = costField.getText();
	    String date = (String)dateList.getSelectedItem();
	    boolean equalSplit = equalSplitBox.isSelected();

	    NewBillEvent event = new NewBillEvent(al, name, cost, date, equalSplit);
	    if (billListener != null) {
		billListener.eventOccurred(event);
	    }
	});

	////////////////////////* setting sizes *//////////////////////////////////
	Dimension dim = nameField.getPreferredSize();
	dim.width = 10;
	nameField.setMinimumSize(dim);
	costField.setMinimumSize(dim);
	dateList.setMinimumSize(dim);


	//////////////////* Sorting out the border *///////////////////////////////
	Border innerBorder = BorderFactory.createTitledBorder("New Bill");
	Border outerBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
	setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

	///////////////////* Prepping GridBagLayout *//////////////////////////////
	setLayout(new GridBagLayout());
	GridBagConstraints gc = new GridBagConstraints();
	gc.fill = GridBagConstraints.NONE;
	gc.insets = new Insets(5, 5, 5, 5);
	gc.weightx = 1;
	gc.weighty = 1;

	///////////////////////////* First row *///////////////////////////////////
	gc.gridy = 0;

	gc.gridx = 0;
	gc.anchor = GridBagConstraints.FIRST_LINE_END;
	add(nameLabel, gc);

	gc.gridx = 1;
	gc.anchor = GridBagConstraints.FIRST_LINE_START;
	gc.fill = GridBagConstraints.HORIZONTAL;
	add(nameField, gc);

	///////////////////////////* Next row *////////////////////////////////////
	gc.gridy++;

	gc.gridx = 0;
	gc.anchor = GridBagConstraints.FIRST_LINE_END;
	gc.fill = GridBagConstraints.NONE;
	add(costLabel, gc);

	gc.gridx = 1;
	gc.anchor = GridBagConstraints.FIRST_LINE_START;
	gc.fill = GridBagConstraints.HORIZONTAL;
	add(costField, gc);

	///////////////////////////* Next row *////////////////////////////////////
	gc.gridy++;

	gc.gridx = 0;
	gc.anchor = GridBagConstraints.FIRST_LINE_END;
	gc.fill = GridBagConstraints.NONE;
	add(dateLabel, gc);

	gc.gridx = 1;
	gc.anchor = GridBagConstraints.FIRST_LINE_START;
	gc.fill = GridBagConstraints.HORIZONTAL;
	add(dateList, gc);

	///////////////////////////* Next row *////////////////////////////////////
	gc.gridy++;

	gc.gridx = 0;
	gc.anchor = GridBagConstraints.FIRST_LINE_END;
	gc.fill = GridBagConstraints.NONE;
	add(equalSplitLabel, gc);

	gc.gridx = 1;
	gc.anchor = GridBagConstraints.FIRST_LINE_START;
	gc.fill = GridBagConstraints.HORIZONTAL;
	add(equalSplitBox, gc);

	///////////////////////////* Next row *////////////////////////////////////
	gc.weighty = 10;
	gc.gridy++;

	gc.gridx = 1;
	gc.anchor = GridBagConstraints.FIRST_LINE_START;
	gc.fill = GridBagConstraints.NONE;
	add(enterButton, gc);
    }

    public void addListener(MyListener listener) {
	this.billListener = listener;
    }

    public void clear() {
	nameField.setText("");
	costField.setText("");
	dateList.setSelectedIndex(0);
	equalSplitBox.setSelected(false);
    }
}
