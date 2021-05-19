package view;

import java.awt.Color;

import controlP5.CP;
import controlP5.ColorPicker;
import controlP5.ColorWheel;
import controlP5.ControlEvent;
import controlP5.ControlP5;
import controller.ControllerMain;
import processing.core.PApplet;

public class Main extends PApplet {

	private ControllerMain controllerMain;
	private ControlP5 cp5;
	ColorPicker cp;
	int r = 255, g = 255, b = 255, a;
	int r1 = 255, g1 = 255, b1 = 255, a1;
	int r2 = 255, g2 = 255, b2 = 255, a2;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		cp5 = new ControlP5(this);
		controllerMain = new ControllerMain(this);
		cp = cp5.addColorPicker("picker").setPosition(130, 230).setColorValue(color(20, 20, 20, 255));

		createButtons();
		
	}

	public void draw() {

		background(255);
		ellipseMode(CORNER);
		fill(r1, g1, b1);
		rect(100, 80, 100, 100);
		fill(r2, g2, b2);
		ellipse(300, 80, 100, 100);
	}

	public void mousePressed() {
		if (controllerMain.selectCircle()) {
			
			r2 = r;
			g2 = g;
			b2 = b;
			
		}

		if (controllerMain.selectSquare()) {
			r1 = r;
			g1 = g;
			b1 = b;
		}
	}

	public void controlEvent(ControlEvent c) {
		if (c.isFrom(cp)) {
			r = (int) (c.getArrayValue(0));
			g = (int) (c.getArrayValue(1));
			b = (int) (c.getArrayValue(2));
			a = (int) (c.getArrayValue(3));

		}
	}

	public void compare() {

		System.out.println("comparo");

	}

	public void clear() {
		
			r1 = 255;
			g1 = 255;
			b1 = 255;

			r2 = 255;
			g2 = 255;
			b2 = 255;
		

	}
	
	private void createButtons() {
		cp5.addBang("compare").setPosition(140, 320).setSize(110, 40).setLabel("Comparar").getCaptionLabel()
		.align(ControlP5.CENTER, ControlP5.CENTER);

		cp5.addBang("clear").setPosition(265, 320).setSize(110, 40).setLabel("Limpiar").getCaptionLabel()
				.align(ControlP5.CENTER, ControlP5.CENTER);
	}
	


}
