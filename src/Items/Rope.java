package Items;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;

import Core.Main;
import Player.Player;
import Visual.ImgType;
import Visual.SaveDialog;
import Map.Field;

/**
 * Seg�ts�g�vel egy lyukba esett j�t�kos kimenthet�. 
 * Ha a ment�s sikeres, a j�t�kos stamin�j�t egy egys�ggel cs�kkenti
 * @author Norbi
 */
public class Rope extends Throwable
{
	/**
	 *  Egy lyukba esett j�t�kos kiment�se.
	 *  @param p a j�t�kos aki haszn�lja a k�telet.
	 *  @author Norbi
	 */
	public void use(Player p) 
	{
		new SaveDialog(p);
	}
	
	@Override
	public Image getImg(ImgType form) {
		if(form==ImgType.DROPPED) {
			return new ImageIcon("./assets/items_buildings/rope.png").getImage();
		}else if(form==ImgType.FROZEN) {
			return new ImageIcon("./assets/items_buildings/rope_frozen.png").getImage();
		}else{
			return null;
		}
	}
	
	public String getName() {
		return "Rope";
	}
}
