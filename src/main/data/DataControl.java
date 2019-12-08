package data;

import java.util.ArrayList;
import java.util.List;

import control.datainterfaces.Bill;
import control.eventobjects.NewBillEvent;
import control.logic.AppLogic;
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
    public List<Integer> checkIsValid(NewBillEvent event) {
	List<Integer> result = new ArrayList<>();
	try {
	    Pounds.toDouble(event.getCost());
	} catch (Exception e) {
	    result.add(AppLogic.COST_ERROR);
	}
	if (!DateOfMonth.isValid(event.getDate())) {
	    result.add(AppLogic.DATE_ERROR);
	};
	try {
	    NameCapitalisation.correct(event.getName()); 
	} catch (Exception e) {
	    result.add(AppLogic.NAME_ERROR); 
	};
	for (Bill myBill : bills) { 
	    if (myBill.getName().equals(event.getName())) {
		result.add(AppLogic.OVERWRITE_WARNING);
	    }
	}
	if (result.size() == 0) {
	    result.add(AppLogic.NO_PROBLEMS);
	}
	return result;
    }

    @Override
    public Bill newBill(NewBillEvent bill) {
	String name = NameCapitalisation.correct(bill.getName());
	double cost = Pounds.toDouble(bill.getCost());
	int date = DateOfMonth.toInt(bill.getDate());
	boolean split = bill.isEquallySplit();
	Bill toReturn = new HouseholdBill(name, cost, date, split);
	
	bills.add(toReturn);
	return toReturn;
    }

    @Override
    public Bill ammendBill(NewBillEvent bill) {
	// TODO Auto-generated method stub
	return null;
    }

}
