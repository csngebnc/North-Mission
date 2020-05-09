package Player;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import Core.Game;
import Map.Field;
import Visual.View;

/**
 * A jegesmedv�t reprezent�l� oszt�ly, ami a Character lesz�rmazottja.
 * @author Zalan
 */
public class PolarBear extends Character{
	/**
	 * A jegesmedve karakter egy random szomsz�dos mez�re l�p a k�r�ben.
	 * @author Zalan
	 */
	@Override
	public void doTurn(Game g) {
		
		ArrayList<Integer> nexts = new ArrayList<Integer>();
		for(int i=0; i< field.getNeighbours().size();i++) {
			if(field.getNeighbours().get(i)!=null) {
				nexts.add(i);
			}
		}
		int max = nexts.size()-1;
		int where = nexts.get((int)(Math.random()*max));
		System.out.println(where);
		field.moveMeTo(this, where);
		g.notifyView();
	}

	/**
	 * Ez a met�dus nem csin�l semmit, a PolarBear-nek nem kell az �let�t �ll�tani.
	 * @author Zalan
	 */
	@Override
	public void alterHealth(int n) {
	}
	
	/**
	 * Ez a met�dus nem csin�l semmit, a PolarBear-nek nem kell a stamin�j�t �ll�tani.
	 * @author Zalan
	 */
	@Override
	public void drainStamina() {		
	}

	/**
	 * Ez a met�dus nem csin�l semmit, a PolarBear-nek be�ll�tani, hogy fuldoklik-e.
	 * @author Zalan
	 */
	@Override
	public void drown() {	
		isDrowning = true;
	}
	
	/**
	 * Ez a met�dus false-szal t�r vissza, hiszen egy Jegesmedv�t nem kell kimenten�nk ha lyukba esett.
	 * @author Zalan
	 */
	@Override
	public boolean save(Field f) {
		return false;
	}

	/**
	 * A jegesmedve a param�terk�nt kapott karaktert �ssze�tk�zteti saj�t mag�val.
	 * @param c a karakter akivel a jegesmedve �ssze�tk�zteti mag�t.
	 * @author Zalan
	 */
	@Override
	public void collideWith(Character c) {
		c.hitBy(this);
	}

	/**
	 * Ha a jegesmedve j�t�kossal �tk�z�tt, akkor a j�t�kot elvesz�tett�k a j�t�kosok.
	 * @param p a j�t�kos, akivel a jegesmedve �ssze�tk�z�tt.
	 * @author Zalan
	 */
	@Override
	public void hitBy(Player p) {
		Game.loseGame();		
	}
	
	/**
	 * Tesztel�shez
	 */
	@Override
	public void Properties()
	{
		System.out.println("Jegesmedve");
	}
	
	/**
	 * A jegesmedve nev�nek lek�rdez�se.
	 * @author Zalan
	 */
	public String getName() {
		return "Jegesmedve";
	}

	@Override
	public void draw(View v) {
		if(isDrowning) {
			v.drawThing(field.GetX()+32, field.GetY()+14, new ImageIcon("./assets/characters/polar_drowning.png").getImage());
		}else {
			if(field.hasBuilding())
				v.drawThing(field.GetX()+25, field.GetY()+10, new ImageIcon("./assets/characters/polar_standing.png").getImage());	
			else
				v.drawThing(field.GetX()+25, field.GetY(), new ImageIcon("./assets/characters/polar_standing.png").getImage());	
		}	
	}

}
