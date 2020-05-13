package Visual;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * A mezõk megjelenitéssel kapcsolatos elemei
 * @author Balczer Dominik
 */
public abstract class FieldView implements Viewable{
	/**
	 * A mezõ képernyõn elfoglalt helyének x koordinátája
	 * @author Balczer Dominik
	 */
	protected int x;
	
	/**
	 * A mezõ a képernyõn elfoglalt helyének y koordinátája
	 * @author Balczer Dominik
	 */
	protected int y;
	
	/**
	 * A mezõhöz megjelenitéséhez tartozó képek
	 * @author Balczer Dominik
	 */
	protected Image[] sprites;
	
	/**
	 * Konstruktor, beállitja a koordinátákat és inicializálja a képeket tároló tömbböt
	 * @author Balczer Dominik
	 */
	public FieldView(int x, int y) {
		this.x = x;
		this.y = y;
		sprites = new Image[3];
		sprites[1] = new ImageIcon("./assets/fields/snow1.png").getImage();
		sprites[2] = new ImageIcon("./assets/fields/snow2.png").getImage();
	}
	
	/**
	 * X koordináta gettere
	 * @author Balczer Dominik
	 */
	public int GetX() {return x;}
	
	/**
	 * Y koordináta gettere
	 * @author Balczer Dominik
	 */
	public int GetY() {return y;}
	
	/**
	 * Mezõ kirajzolása
	 * @author Balczer Dominik
	 */
	public abstract void draw(View v);
}