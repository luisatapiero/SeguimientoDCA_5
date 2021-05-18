package view;

import controlP5.ColorWheel;
import controlP5.ControlP5;
import controller.ControllerMain;
import processing.core.PApplet;

public class Main extends PApplet{
	
	private ControllerMain controllerMain;
	private ControlP5 cp5;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}
	
	public void settings() {
		size(500,500);
	}

	public void setup() {
		cp5 = new ControlP5(this);
		
		controllerMain = new ControllerMain(this);
		
		
		cp5.addColorWheel("wheel", 200, 465, 120).setRGB(color(255,255,255))
		//.setHue(255)
		
		.setPosition(200,200)
	
		//.setLabel(ColorWheel.getRGB())
		
		;
		
		cp5.addBang("compare")
	     .setPosition(140,400)
	     .setSize(110,40)
	     .setLabel("Comparar")
	     .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER)
	     ;
		
		cp5.addBang("clear")
	     .setPosition(280,400)
	     .setSize(110,40)
	     .setLabel("Limpiar")
	     .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER)
	     ;
	}
	
	
	public void draw() {
		background(255);
		fill(0);
		text(cp5.get(ColorWheel.class,"wheel").getRGB(),50,60);
	}
	
	public void compare() {

		System.out.println("comparo");
	
		}
	
	public void clear() {

		System.out.println("limpio");
		  
	}
	
}
