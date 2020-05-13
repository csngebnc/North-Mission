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
 * Segítségével egy lyukba esett játékos kimenthetõ. 
 * Ha a mentés sikeres, a játékos stamináját egy egységgel csökkenti
 * @author Norbi
 */
public class Rope extends Throwable
{
	/**
	 *  Egy lyukba esett játékos kimentése.
	 *  @param p a játékos aki használja a kötelet.
	 *  @author Norbi
	 */
	public void use(Player p) 
	{
		new SaveDialog(p);
	}
	
	/**
	 * Visszaadja az alkatrész azon képét, amelyre szükség van a kirajzoláshoz.
	 * @param form Lehetséges formák: befagyott, földön lévõ.
	 * @author Csonge Bence
	 */
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
	
	/**
	 * Visszaadja a tárgy nevét.
	 * @author Csonge Bence
	 */
	public String getName() {
		return "Rope";
	}
}
