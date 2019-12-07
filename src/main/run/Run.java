package run;

import javax.swing.SwingUtilities;

import control.logic.AppLogic;
import data.DataControl;
import gui.GuiControl;

public class Run {
    public static void main(String[] args) {
	SwingUtilities.invokeLater( () -> {
	    new AppLogic(new DataControl(), new GuiControl());
	});
    }
}
