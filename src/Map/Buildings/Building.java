package Map.Buildings;

import java.awt.Image;
import Visual.ImgType;

/**
 * Épületekhez tartozó interfész
 * @author Csonge Bence
 */
public interface Building {
	/**
	 * Épület tickelése, ha nem tartós az épület (pl:Sátor), false-al tér vissza
	 * @author Balczer Dominik
	 */
	public boolean tick();
	
	/**
	 * Visszaadja támadható-e az épület
	 * @author Balczer Dominik
	 */
	public boolean attack();
	
	/**
	 * Visszaadja az épülethez tartozó képet
	 * @author Balczer Dominik
	 */
	public Image getImg(ImgType form);
}