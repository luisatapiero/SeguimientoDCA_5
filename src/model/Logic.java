package model;

import exception.NoColorException;
import exception.ValidationColorException;
import processing.core.PApplet;

public class Logic {

	PApplet app;

	public Logic(PApplet app) {
		this.app = app;

		try {
			createdException();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Sigo ejecutando :)");
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

	private void createdException() throws Exception {
		String nonExisted = null;
		Integer.parseInt(nonExisted);

	}

	public void checkColor(int r1, int g1, int b1, int r2, int g2, int b2) throws ValidationColorException {
		if (!(r1 == r2 && g1 == g2 && b1 == b2)
				&& !(r1 == 255 && g1 == 255 && b1 == 255 || r2 == 255 && g2 == 255 && b2 == 255)) {
			throw new ValidationColorException("ERROR: Las figuras no tienen el mismo color\n" + "Cuadrado r " + r1
					+ " g " + g1 + " b " + b1 + "\nC?rculo r " + r2 + " g " + g2 + " b " + b2);
		}
	}

	public void noColor(int r1, int g1, int b1, int r2, int g2, int b2) throws NoColorException {
		if ((r1 == 255 && g1 == 255 && b1 == 255 || r2 == 255 && g2 == 255 && b2 == 255)) {
			throw new NoColorException("ERROR: No has escogido el color de la(s) figura(s)\n" + "Cuadrado r " + r1
					+ " g " + g1 + " b " + b1 + "\nC?rculo r " + r2 + " g " + g2 + " b " + b2);
		}
	}

}
