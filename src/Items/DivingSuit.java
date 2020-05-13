package Items;
import java.awt.Image;
import javax.swing.ImageIcon;
import Player.Player;
import Visual.ImgType;

/**
 * Búvárruhát reprezentáló osztály.
 * @author Norbi
 */
public class DivingSuit extends Throwable
{
	/**
	 *Ennek a függvénynek a segítségével tudjuk felvenni a búvárruhát magunkra.
	 *Ha már van rajtunk egy, akkor nem történik semmi, ha még nincs akkor eltávolítja magát a Player leltárából, 
	 *beállítja a dSuitOn attribútumát true-ra és levon egyet a staminájából.
	 * @param p a játékos aki használja a búvárruhát.
	 * @author Norbi
	 */
	public void use(Player p) 
	{
		if(!p.getdSuitOn())
		{
			p.changeSuit(this);
			p.setdSuitOn(true);
			p.drainStamina();
		}
	}
	
	/**
	 * Visszaadja a tárgy nevét.
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Snorkel Sett";
	}
	
	/**
	 * Visszaadja az alkatrész azon képét, amelyre szükség van a kirajzoláshoz.
	 * @param form Lehetséges formák: befagyott, földön lévõ.
	 * @author Csonge Bence
	 */
	@Override
	public Image getImg(ImgType form) {
		if(form==ImgType.DROPPED) {
			return new ImageIcon("./assets/items_buildings/dsuit.png").getImage();
		}else if(form==ImgType.FROZEN) {
			return new ImageIcon("./assets/items_buildings/dsuit_frozen.png").getImage();
		}else{
			return null;
		}
	}
}
