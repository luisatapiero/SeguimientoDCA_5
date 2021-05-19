package model;

import processing.core.PApplet;

public class Logic {

	PApplet app;

	public Logic(PApplet app) {
		this.app = app;

	}

	public boolean selectSquare() {
		if (app.mouseX < 200 && app.mouseX > 100 && app.mouseY < 180 && app.mouseY > 80) {
			return true;
		}
		return false;

	}
	
	public boolean selectCircle() {
		if (app.mouseX < 400 && app.mouseX > 300 && app.mouseY < 180 && app.mouseY > 80) {
			return true;
		}
		return false;

	}



}
