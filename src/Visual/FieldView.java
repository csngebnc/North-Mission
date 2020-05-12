package Visual;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class FieldView implements Viewable{
	protected int x;
	protected int y;
	
	protected Image[] sprites;
	
	public FieldView(int x, int y) {
		this.x = x;
		this.y = y;
		sprites = new Image[3];
		sprites[1] = new ImageIcon("./assets/fields/snow1.png").getImage();
		sprites[2] = new ImageIcon("./assets/fields/snow2.png").getImage();
	}
	
	public int GetX() {return x;}
	public int GetY() {return y;}
	
	public abstract void draw(View v);
}
