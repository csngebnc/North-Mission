package Visual;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Map.Map;
import Map.Field;

public class View extends JFrame{
	
	private Graphics g;
	private Canvas cv;
	
	
	public View() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(1280,720));
		this.setVisible(true);
		cv = new Canvas();
		cv.setSize(1280,720);
		cv.setPreferredSize(cv.getSize());
		this.add(cv);
		cv.createBufferStrategy(2);
	}
	
	public void revalidate(Map map) {
		g = cv.getBufferStrategy().getDrawGraphics();
		g.drawImage(new ImageIcon("./assets/fields/backg.png").getImage(),0,0, null);
		for(Field f : map.getFields()) {
			f.draw(this);
		}
		cv.getBufferStrategy().show();
	}
	
	
	public void drawThing(int x, int y, Image img) {
		g.drawImage(img, x, y, null);
	}

}
