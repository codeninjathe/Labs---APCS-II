/*
  Don't Steal This
*/

import java.awt.*;
import java.applet.*;
import java.util.Random;
public class GraphicsLab009 extends Applet{
	public void init(){
		this.setSize(1200,800);
	}
	public void paint(Graphics g){
		Cube c = new Cube(g);
		c.setCorners(100,100);
		c.setSize(100);
		c.draw();
		Dice d = new Dice(g);
		d.setCorners(350, 100);
		d.setSize(120);
		d.draw();
		d.addNums();
		ColoredDice cd = new ColoredDice(g);
		cd.setCorners(700, 100);
		cd.setSize(150);
		cd.draw();
		cd.setRandColors();
		cd.addNums();
	}
}
class Cube{
	protected Graphics g;
	private int cornerX, cornerY, size;
	protected int tempx1, tempy1;
	public Cube(Graphics g){
		this.g = g;
	}
	public void setCorners(int a, int b){
		cornerX = a;
		cornerY = b;
	}
	public void draw(){
		g.drawRect(cornerX, cornerY, size, size);
		int x1 = cornerX + 3 * size / 10;
		int y1 = cornerY - 4 * size / 10;
		g.drawLine(cornerX, cornerY, x1, y1);
		g.drawLine(cornerX + size, cornerY, x1 + size, y1);
		g.drawLine(x1, y1, x1 + size, y1);
		g.drawLine(cornerX + size, cornerY + size, x1 + size, y1 + size);
		g.drawLine(x1 + size, y1 + size, x1 + size, y1);
		tempx1 = x1;
		tempy1 = y1;
	}
	public void setSize(int s){
		size = s;
	}
	public int getCornerX(){
		return cornerX;
	}
	public int getCornerY(){
		return cornerY;
	}
	public int getSize(){
		return size;
	}
}
class Dice extends Cube{

	public Dice(Graphics g) {
		super(g);
	}
	public void addNums(){
		g.setColor(Color.black);
		g.fillOval(getCornerX() + getSize() / 4, getCornerY() + getSize() / 4,(int)( getSize() / 2),(int) (getSize()/ 2)); // One
		g.fillOval(tempx1 + getSize() / 100, tempy1 + getSize() / 10, getSize() / 2, (int) (getSize() / 2) / 5);// Two - I
		g.fillOval(tempx1 + getSize() / 100 + getSize() / 4, tempy1 + getSize() / 4, getSize() / 2, (int) (getSize() / 2) / 5); // Two - II
		g.fillOval(getCornerX() + getSize(), getCornerY(), getSize() / 6 * 2 / 3, getSize() / 4 * 2 / 3);
		g.fillOval(getCornerX() + getSize() + getSize() / 10, getCornerY() + getSize() / 5, getSize() / 6 * 2 / 3, getSize() / 4 * 2 / 3);
		g.fillOval(getCornerX() + getSize() + getSize() / 6, getCornerY() + 2 * getSize() / 5, getSize() / 6 * 2 / 3, getSize() / 4 * 2 / 3);
	}
}
class ColoredDice extends Dice{
	private static Random r = new Random();
	public ColoredDice(Graphics g) {
		super(g);
	}
	public void setRandColors(){
		Color c1 = randColor();
		g.setColor(c1);
		g.fillRect(getCornerX(),getCornerY(), getSize(), getSize());
		Color c2 = randColor();
		Polygon p = new Polygon();
		p.addPoint(getCornerX(), getCornerY());
		p.addPoint(tempx1, tempy1);
		p.addPoint(tempx1 + getSize(), tempy1);
		p.addPoint(getCornerX() + getSize(), getCornerY());
		g.setColor(c2);
		g.fillPolygon(p);
		Color c3 = randColor();
		g.setColor(c3);
		Polygon p1 = new Polygon();
		p1.addPoint(getCornerX() + getSize(), getCornerY());
		p1.addPoint(tempx1 + getSize(), tempy1);
		p1.addPoint(tempx1 + getSize(), tempy1 + getSize());
		p1.addPoint(getCornerX() + getSize(), getCornerY() + getSize());
		g.fillPolygon(p1);
	}
	private static Color randColor(){
		return new Color(r.nextInt(255) * r.nextInt(255) / r.nextInt(255) % 256,r.nextInt(255) * r.nextInt(255) / r.nextInt(255) % 256,r.nextInt(255) * r.nextInt(255) / r.nextInt(255) % 256);
	}
}
