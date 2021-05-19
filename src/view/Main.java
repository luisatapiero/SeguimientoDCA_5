package view;

import java.awt.Color;

import controlP5.CP;
import controlP5.ColorPicker;
import controlP5.ControlEvent;
import controlP5.ControlP5;
import controller.ControllerMain;
import exception.NoColorException;
import exception.ValidationColorException;
import processing.core.PApplet;

public class Main extends PApplet {

	private ControllerMain controllerMain;
	private ControlP5 cp5;
	ColorPicker cp;
	int r = 255, g = 255, b = 255, a;
	int r1 = 255, g1 = 255, b1 = 255, a1;
	int r2 = 255, g2 = 255, b2 = 255, a2;
	private int numException = 0;
	private String messageExc;

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
		drawShapes();
		showMessages();

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
			numException = 0;
		}
	}

	public void compare() throws NoColorException, ValidationColorException{
		
		
		try {

			controllerMain.checkColor(r1, g1, b1, r2, g2, b2);
			messageExc = ("CORRECTO: Las figuras tienen el mismo color\n" + "Cuadrado r " + r1
					+ " g " + g1 + " b " + b1 + "\nCírculo r " + r2 + " g " + g2 + " b " + b2);
			numException = 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			messageExc = e.getMessage();
			numException = 2;

		}
		
		try {
			checkNoColor();
		} catch (NoColorException e1) {
			messageExc = e1.getMessage();
			numException = 3;
		}

	}
	

	public void clear() {

		r1 = 255;
		g1 = 255;
		b1 = 255;

		r2 = 255;
		g2 = 255;
		b2 = 255;

	}
	
	private void checkNoColor() throws NoColorException{

			controllerMain.noColor(r1, g1, b1, r2, g2, b2);

		}


	private void createButtons() {
		cp5.addBang("compare").setPosition(140, 320).setSize(110, 40).setLabel("Comparar").getCaptionLabel()
				.align(ControlP5.CENTER, ControlP5.CENTER);

		cp5.addBang("clear").setPosition(265, 320).setSize(110, 40).setLabel("Limpiar").getCaptionLabel()
				.align(ControlP5.CENTER, ControlP5.CENTER);
	}

	private void drawShapes() {
		ellipseMode(CORNER);
		fill(r1, g1, b1);
		rect(100, 80, 100, 100);
		fill(r2, g2, b2);
		ellipse(300, 80, 100, 100);
	}

	private void showMessages() {
		textSize(12);
		fill(255, 0, 0);
		switch (numException) {
		case 0:

			break;
		case 1:
			fill(27, 153, 139);
			text(messageExc, 130, 400);
			break;
		case 2:
			text(messageExc, 130, 400);
			break;
		case 3:
			fill(255, 0, 0);
			text(messageExc, 130, 400);
			break;

		default:
			break;
		}

	}

}
