package Map.Buildings;

import java.awt.Image;
import Visual.ImgType;

/**
 * �p�letekhez tartoz� interf�sz
 * @author Csonge Bence
 */
public interface Building {
	/**
	 * �p�let tickel�se, ha nem tart�s az �p�let (pl:S�tor), false-al t�r vissza
	 * @author Balczer Dominik
	 */
	public boolean tick();
	
	/**
	 * Visszaadja t�madhat�-e az �p�let
	 * @author Balczer Dominik
	 */
	public boolean attack();
	
	/**
	 * Visszaadja az �p�lethez tartoz� k�pet
	 * @author Balczer Dominik
	 */
	public Image getImg(ImgType form);
}