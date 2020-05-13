package Items;
import java.awt.Image;
import javax.swing.ImageIcon;
import Player.Player;
import Visual.ImgType;

/**
 * B�v�rruh�t reprezent�l� oszt�ly.
 * @author Norbi
 */
public class DivingSuit extends Throwable{
	
	/**
	 * Konstruktor, be�llitja a k�peket
	 * @author Balczer Dominik
	 */
	public DivingSuit() {
		sprites = new Image[3];
		sprites[ImgType.DROPPED.VALUE] = new ImageIcon("./assets/items_buildings/dsuit.png").getImage();
		sprites[ImgType.FROZEN.VALUE] = new ImageIcon("./assets/items_buildings/dsuit_frozen.png").getImage();
		sprites[ImgType.BUILT.VALUE] = new ImageIcon("./assets/items_buildings/dsuit.png").getImage();
	}
	
	/**
	 *Ennek a f�ggv�nynek a seg�ts�g�vel tudjuk felvenni a b�v�rruh�t magunkra.
	 *Ha m�r van rajtunk egy, akkor nem t�rt�nik semmi, ha m�g nincs akkor elt�vol�tja mag�t a Player lelt�r�b�l, 
	 *be�ll�tja a dSuitOn attrib�tum�t true-ra �s levon egyet a stamin�j�b�l.
	 * @param p a j�t�kos aki haszn�lja a b�v�rruh�t.
	 * @author Norbi
	 */
	public void use(Player p) {
		if(!p.getdSuitOn()){
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
}