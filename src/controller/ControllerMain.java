package controller;

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
	


}
