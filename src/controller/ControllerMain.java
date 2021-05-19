package controller;

import exception.NoColorException;
import exception.ValidationColorException;
import model.Logic;
import processing.core.PApplet;

public class ControllerMain {

	private Logic logic;
	
	public ControllerMain(PApplet app) {
		logic = new Logic(app);
	}
	
	public boolean selectSquare() {
		if (logic.selectSquare()) {
			return true;
		}
		return false;
	}
	
	public boolean selectCircle() {
		if (logic.selectCircle()) {
			return true;
		}
		return false;
	}
	
	public void checkColor(int r1, int g1, int b1, int r2, int g2, int b2) throws ValidationColorException {
		logic.checkColor(r1, g1, b1, r2, g2, b2);
	}
	
	public void noColor(int r1, int g1, int b1, int r2, int g2, int b2) throws NoColorException {
		logic.noColor(r1, g1, b1, r2, g2, b2);
	}

}
