package Player;

import java.awt.Image;
import java.awt.event.KeyEvent;
import Player.Direction;
import java.util.ArrayList;
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
	public PolarBear() {
		super();
		sprites = new Image[2];
		sprites[0]= new ImageIcon("./assets/characters/polar_standing.png").getImage();
		sprites[1] = new ImageIcon("./assets/characters/polar_drowning.png").getImage();
	}
	
	/**
	 * Jegesmedve k�r�nek v�grehajt�sa. L�p, majd �rtes�ti a j�t�kot, hogy j�het a k�vetkez� j�t�kos.
	 * @author Csonge Bence
	 */
	@Override
	public void doTurn(KeyEvent e) {
		move(null);
		Game.getInstance().nextCharacter();
	}
	
	/**
	 * A jegesmedve elkezdi a k�r�t.
	 * @author Csonge Bence
	 */
	public void startTurn() {
		doTurn(null);
	}
	
	/**
	 * V�letlenszer�en l�p a mez�j�nek valamely szomsz�dos mez�j�re.
	 * @author Csonge Bence
	 */
	public void move(KeyEvent e) {
		ArrayList<Integer> nexts = new ArrayList<Integer>();
		for(int i=0; i< field.getNeighbours().size();i++) {
			if(field.getNeighbours().get(i)!=null) {
				nexts.add(i);
			}
		}
		int max = nexts.size()-1;
		int where = nexts.get((int)(Math.random()*max));
		System.out.println(where);
		field.moveMeTo(this, Direction.FromInt(where));
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
		p.alterHealth(-p.getHealth());
		Game.loseGame();		
	}
	
	/**
	 * A jegesmedve nev�nek lek�rdez�se.
	 * @author Zalan
	 */
	public String getName() {
		return "Jegesmedve";
	}
	
	/**
	 * A jegesmedve aktu�lis �llapot�nak megfelel�en visszaadja hozz� tartoz� k�pet.
	 * @author Csonge Bence
	 */
	@Override
	public Image getAvatar() {
		if(isDrowning)
			return sprites[1];
		else return sprites[0];
	}

	/**
	 * �rtes�ti a param�terk�nt kapott megjelen�t�t, hogy a megadott koordin�t�kra rajzolja ki a karakter avat�rj�t.
	 * @author Csonge Bence
	 */
	@Override
	public void draw(View v) {
		if(isDrowning) {
			v.drawThing(field.GetX()+32, field.GetY()+14, getAvatar());
		}else {
			if(field.hasBuilding())
				v.drawThing(field.GetX()+25, field.GetY()+10, getAvatar());	
			else
				v.drawThing(field.GetX()+25, field.GetY(), getAvatar());	
		}	
	}

}
