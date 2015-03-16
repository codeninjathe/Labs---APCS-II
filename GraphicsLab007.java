package Ch19;

import java.applet.*; 
import java.awt.*;
import java.util.*;

public class Graphics007 extends Applet{
	public void init(){
		setSize(1200,800);
	}
	public void paint(Graphics gr){
		drawSquare(gr, 250, 4, 0, 350, true);
		drawSquare(gr, 4, 250, 0, 400, false);
	}
	public static void drawSquare(Graphics gr, int size, int stop, int x, int y, boolean small){
		if(small){
			if(!(size <= stop)){
				System.out.println(size + " " + stop + " " + x + " " + y + " " + small);
				gr.fillRect(x, y - size, size, size);
				drawSquare(gr, size * 3/4, stop, x + size + 10, y, small);
			}
		}
		else{
			System.out.println("Starting the smaller one");
			if(!(size >= stop)){
				System.out.println(size + " " + stop + " " + x + " " + y + " " + small);
				gr.fillRect(x, y, size, size);
				drawSquare(gr, size * 4/3, stop, x + size + 10, y, small);
			}
		}
	}
}
