package view;

import java.awt.Color;

import controlP5.ColorPicker;
import controlP5.ColorWheel;
import controlP5.ControlEvent;
import controlP5.ControlP5;
import controller.ControllerMain;
import processing.core.PApplet;

public class Main extends PApplet{
	
	private ControllerMain controllerMain;
	private ControlP5 cp5;
	ColorPicker cp;
	int r, g, b, a;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}
	
	public void settings() {
		size(500,500);
	}

	public void setup() {
		cp5 = new ControlP5(this);
		
		controllerMain = new ControllerMain(this);
		
		
		/*cp5.addColorWheel("wheel", 200, 465, 120).setRGB(color(255,255,255))
		//.setHue(255)
		
		.setPosition(200,200)
	
		//.setLabel(ColorWheel.getRGB())*/
		
		 cp5.addColorPicker("picker")
		          .setPosition(130, 230)
		          .setColorValue(color(255, 128, 22, 255))
		          ;
		
		cp5.addBang("compare")
	     .setPosition(140,320)
	     .setSize(110,40)
	     .setLabel("Comparar")
	     .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER)
	     ;
		
		cp5.addBang("clear")
	     .setPosition(265,320)
	     .setSize(110,40)
	     .setLabel("Limpiar")
	     .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER)
	     ;
	}
	
	 
	public void draw() {
		/*background(255);
		fill(0);
		text(cp5.get(ColorWheel.class,"wheel").getRGB(),50,60);*/
		
		//background(cp.getColorValue());
		background(255);
		  fill(r,g,b);
		  rect(50, 90, 275, 80);
	}
	
	public void controlEvent(ControlEvent c) {
		//System.out.println("sirvoooo");
		  //if(c.isFrom(cp)) {
			  
		    r = (int) (c.getArrayValue(0));
		    g = (int)(c.getArrayValue(1));
		    b = (int)(c.getArrayValue(2));
		    a = (int)(c.getArrayValue(3));
		    
		    //col = color(r,g,b,a);
		    //System.out.println("event\talpha:"+a+"\tred:"+r+"\tgreen:"+g+"\tblue:"+b+"\tcol"+col);
		  //}
		}

		// color information from ColorPicker 'picker' are forwarded to the picker(int) function
		void picker(int col) {
		 //System.out.println("picker\talpha:"+alpha(col)+"\tred:"+red(col)+"\tgreen:"+green(col)+"\tblue:"+blue(col)+"\tcol"+col);
		}
	
	public void compare() {

		System.out.println("comparo");
	
		}
	
	public void clear() {

		System.out.println("limpio");
		  
	}
	
}
