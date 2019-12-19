package data;

import java.util.ArrayList;
import java.util.List;

import control.constants.MyError;
import control.datainterfaces.Bill;
import control.eventobjects.NewBillEvent;
import control.logic.UserData;
import data.format.DateOfMonth;
import data.format.NameCapitalisation;
import data.format.Pounds;

public class DataControl implements UserData{

    List<Bill> bills;
    
    public DataControl() {
	bills = new ArrayList<>();
    }
    
    @Override
    public void clear() {
	bills.clear();
    }

    @Override
    public List<MyError> checkIsValid(NewBillEvent event) {
	List<MyError> result = new ArrayList<>();
	try {
	    Pounds.toDouble(event.getCost());
	} catch (Exception e) {
	    result.add(MyError.COST);
	}
	if (!DateOfMonth.isValid(event.getDate())) {
	    result.add(MyError.DATE);
	};
	String nameToCheck;
	try {
	    nameToCheck = NameCapitalisation.correct(event.getName()); 
	} catch (Exception e) {
	    result.add(MyError.NAME); 
	    nameToCheck = "";
	};
	for (Bill myBill : bills) { 
	    if (myBill.getName().equals(nameToCheck)) {
		result.add(MyError.OVERWRITE);
	    }
	}
	if (result.size() == 0) {
	    result.add(MyError.NA);
	}
	return result;
    }

    @Override
    public Bill createBill(NewBillEvent bill) {
	String name = NameCapitalisation.correct(bill.getName());
	double cost = Pounds.toDouble(bill.getCost());
	int date = DateOfMonth.toInt(bill.getDate());
	boolean split = bill.isEquallySplit();
	Bill toReturn = new HouseholdBill(name, cost, date, split);
	return toReturn;
    }

    @Override
    public void amendBill(Bill changedBill, Bill oldBill) {
	bills.remove(oldBill);
	bills.add(changedBill);
    }

    @Override
    public Bill getBill(String name) {
	for (Bill myBill : bills) {
	    if (myBill.getName().equals(name)) {return myBill; }
	}
	return null;
    }

    @Override
    public void addBill(Bill toAdd) {
	bills.add(toAdd);
    }

}
