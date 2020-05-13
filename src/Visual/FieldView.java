package Visual;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * A mez�k megjelenit�ssel kapcsolatos elemei
 * @author Balczer Dominik
 */
public abstract class FieldView implements Viewable{
	/**
	 * A mez� k�perny�n elfoglalt hely�nek x koordin�t�ja
	 * @author Balczer Dominik
	 */
	protected int x;
	
	/**
	 * A mez� a k�perny�n elfoglalt hely�nek y koordin�t�ja
	 * @author Balczer Dominik
	 */
	protected int y;
	
	/**
	 * A mez�h�z megjelenit�s�hez tartoz� k�pek
	 * @author Balczer Dominik
	 */
	protected Image[] sprites;
	
	/**
	 * Konstruktor, be�llitja a koordin�t�kat �s inicializ�lja a k�peket t�rol� t�mbb�t
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
	 * X koordin�ta gettere
	 * @author Balczer Dominik
	 */
	public int GetX() {return x;}
	
	/**
	 * Y koordin�ta gettere
	 * @author Balczer Dominik
	 */
	public int GetY() {return y;}
	
	/**
	 * Mez� kirajzol�sa
	 * @author Balczer Dominik
	 */
	public abstract void draw(View v);
}