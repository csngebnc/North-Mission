package Map.Buildings;

import java.awt.Image;

import Visual.ImgType;

/**
 * Az epuleteket meghatarozo Bulding interfesz.
 * @author Csonge Bence
 */
public interface Building {
	public boolean tick();
	public boolean attack();
	public Image getImg(ImgType form);
}
