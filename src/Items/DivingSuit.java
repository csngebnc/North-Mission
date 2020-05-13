package Items;
import java.awt.Image;
import javax.swing.ImageIcon;
import Player.Player;
import Visual.ImgType;

/**
 * B�v�rruh�t reprezent�l� oszt�ly.
 * @author Norbi
 */
public class DivingSuit extends Throwable
{
	/**
	 *Ennek a f�ggv�nynek a seg�ts�g�vel tudjuk felvenni a b�v�rruh�t magunkra.
	 *Ha m�r van rajtunk egy, akkor nem t�rt�nik semmi, ha m�g nincs akkor elt�vol�tja mag�t a Player lelt�r�b�l, 
	 *be�ll�tja a dSuitOn attrib�tum�t true-ra �s levon egyet a stamin�j�b�l.
	 * @param p a j�t�kos aki haszn�lja a b�v�rruh�t.
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
	 * Visszaadja a t�rgy nev�t.
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Snorkel Sett";
	}
	
	/**
	 * Visszaadja az alkatr�sz azon k�p�t, amelyre sz�ks�g van a kirajzol�shoz.
	 * @param form Lehets�ges form�k: befagyott, f�ld�n l�v�.
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
