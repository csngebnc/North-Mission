package Player;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;

import Core.Game;
import Core.GameState;
import Core.Main;
import Items.Barrel;
import Items.DivingSuit;
import Items.Food;
import Items.Item;
import Items.Rope;
import Items.Shovel;
import Map.Field;
import Map.IceField;
import Map.Map;
import Visual.View;

/**
 * A j�t�kosokat reprezent�l� absztrakt oszt�ly.
 * Lesz�rmazottai az Eskimo �s a Scientist.
 * @author Zalan
 */
public abstract class Player extends Character
{
	protected String name;
	protected int health;
	protected boolean dSuitOn;
	protected ArrayList<Item> inventory;
	public abstract void doSkill();
	protected Image currentPlayerImage;
	
	/**
	 * A Player konstruktora.
	 * Inicializ�ljuk az inventory, isDrowning, dSuitOn, health tulajdons�gokat.
	 * @author Zalan
	 */
	public Player() {
		inventory = new ArrayList<Item>();
		isDrowning = false;
		dSuitOn = false;
		health = 3;
		currentPlayerImage = new ImageIcon("./assets/characters/current_player.png").getImage();
	}

	/**
	 * J�t�kos inventory-j�nak megjelen�t�se.
	 * @author Zalan
	 */
	protected void openInventory() 
	{
		for(Item i : inventory) {
			System.out.println(i.getClass());
		}
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		
		try {
			bemenet = reader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!inventory.isEmpty()) {
			inventory.get(Integer.parseInt(bemenet)).use(this);
		}
	}
	
	/**
	 * A j�t�kos k�re.
	 * A j�t�kos 3 stamin�val kezdi a k�r�t. Ha fuldoklik, �s nincs rajta b�v�rruha akkor meghalt, �s a j�t�kosok elvesztett�k a j�t�kot.
	 * Ezut�n, ha van m�g stamin�ja, akkor sz�nd�kainak megfelel�en cselekedhet.
	 * @author Zalan
	 */
	public boolean doTurn(Game g, KeyEvent e) 
	{		
		if(isDrowning && !dSuitOn) {
			Game.loseGame();
			return false;
		}
		
			move(e);
			g.notifyView();
			
			if(isDrowning)
				return true;
			
		return stamina == 0;
	}
	
	public void startTurn(Game g) {
		stamina = 3;
	}
	
	public void move(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_Q:
				if(field.getNeighbour(Direction.UPPER_LEFT)!=null) {
					field.moveMeTo(this, Direction.UPPER_LEFT);
				}
				break;
			case KeyEvent.VK_E:
				if(field.getNeighbour(Direction.UPPER_RIGHT)!=null) {
					field.moveMeTo(this, Direction.UPPER_RIGHT);
				}
				break;
			case KeyEvent.VK_A:
				if(field.getNeighbour(Direction.LEFT)!=null) {
					field.moveMeTo(this, Direction.LEFT);
				}
				break;
			case KeyEvent.VK_D:
				if(field.getNeighbour(Direction.RIGHT)!=null) {
					field.moveMeTo(this, Direction.RIGHT);
				}
				break;
			case KeyEvent.VK_Y:
				if(field.getNeighbour(Direction.BOTTOM_LEFT)!=null) {
					field.moveMeTo(this, Direction.BOTTOM_LEFT);
				}
				break;
			case KeyEvent.VK_X:
				if(field.getNeighbour(Direction.BOTTOM_RIGHT)!=null) {
					field.moveMeTo(this, Direction.BOTTOM_RIGHT);
				}
				break;
			case KeyEvent.VK_S:
				//skill haszn�lat
				doSkill();
				break;
			case KeyEvent.VK_H:
				//k�zzel �s�s
				field.digSnow(1);
				break;
			case KeyEvent.VK_I:
				//Itt j�n felugr� ablakkal az inventory
				break;
			case KeyEvent.VK_P:
				return;
		}
	}
	
	/**
	 * B�v�rruha haszn�lat.
	 * Ha a j�t�koson volt m�r b�v�rruha, akkor azt leveszi �s az inventory-j�ba teszi, ha nem volt m�g rajta akkor felveszi.
	 * @author Zalan
	 * @param dsuit a a b�v�rruha amit felvesz�nk. Null �rt�k�, ha le kell venn�nk magunkr�l a b�v�rruh�t.
	 */
	public boolean changeSuit(DivingSuit dsuit) 
	{
		if (dsuit == null) {
			if(dSuitOn) {
				dSuitOn = false;
				inventory.add(new DivingSuit());
				return true;
			}
			else
				return false;
		}
		else if (!dSuitOn) {
			dSuitOn = true;
			inventory.remove(dsuit);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * J�t�kos �let�nek v�ltoztat�sa 'n' egys�ggel
	 * @author Zalan
	 * @param n ennyivel v�ltozik a j�t�kos �lete
	 */
	public void alterHealth(int n) 
	{
		health += n;
		
		if(health <= 0)
			Game.loseGame();
	}
	
	/**
	 * J�t�kos stamin�j�nak cs�kkent�se 1-gyel.
	 * @author Zalan
	 */
	public void drainStamina() 
	{
		stamina -= 1;
	}
	
	/**
	 * A j�t�kos megment�sre ker�l fuldokl� helyzetb�l.
	 * A j�t�kos a param�terk�nt kapott field-re helyez�dik, �s az isDrowning �rt�ke false lesz.
	 * @author Zalan
	 * @param safeField a biztons�gos mez�, amire a j�t�kos ker�l.
	 */
	public boolean save(Field safeField) {
		field.moveMeTo(this, Direction.FromInt(field.getNeighbours().indexOf(safeField)));
		return true;
	}
	
	/**
	 * Egy t�rgy elt�vol�t�sa a j�t�kos inventory-j�b�l.
	 * @param i ezen a sorsz�m� Item-et t�vol�tjuk el az inventory-b�l
	 * @author Zalan
	 */
	public void removeItem(Item i) {
		inventory.remove(i);
	}
	
	@Override
	public void draw(View v) {
		int charPos = (52/field.getCharacters().size()) * 
				(int)Math.pow(-1, field.getCharacters().indexOf(this)) *
				(int)(Math.ceil(((double)field.getCharacters().indexOf(this))/2));
		if(!field.hasBuilding()) {
			if(isDrowning) {
				v.drawThing(field.GetX()+40+charPos, field.GetY()+8, img[1]);
			}else {
				v.drawThing(field.GetX()+36+charPos, field.GetY(), img[0]);
			}
		}
		if(stamina > 0) {
			if(field.hasBuilding())
				v.drawThing(field.GetX()+45, field.GetY()-30, currentPlayerImage);
			else
				v.drawThing(field.GetX()+39+charPos, field.GetY()-15, currentPlayerImage);
		}
	}
		
	/**
	 * J�t�kos mez�j�nek be�ll�t�sa.
	 * @param f a field �j �rt�ke
	 * @author Zalan
	 */
	public void setField(Field f) 
	{
		field = f;
	}
	
	/**
	 * J�t�kos mez�j�nek lek�rdez�se.
	 * @author Zalan
	 */
	public Field getField() 
	{
		return field;
	}
	
	/**
	 * J�t�kos nev�nek lek�rdez�se.
	 * @author Zalan
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * J�t�kos nev�nek be�ll�t�sa.
	 * @param n az �j n�v
	 * @author Zalan
	 */
	public void setName(String n) {
		name = n;
	}
	
	/**
	 * A met�dus visszaadja, hogy van-e a j�t�koson b�v�rruha.
	 * @author Zalan
	 */
	public boolean getdSuitOn()
	{
		return dSuitOn;
	}
	
	/**
	 * A met�dus be�ll�tja, hogy van-e a j�t�koson b�v�rruha.
	 * @param b a dSuitOn �j �rt�ke
	 * @author Zalan
	 */
	public void setdSuitOn(boolean b)
	{
		dSuitOn=b;
	}

	/**
	 * A met�dus visszaadja a j�t�kos inventory-j�nak i-edik elem�t.
	 * @param i ezen sorsz�m� elemet adjuk vissza
	 * @author Zalan
	 */
	public Item getItem(int i) {
		if(inventory.size() == 0 || i >= inventory.size())
			return null;
		return inventory.get(i);
	}
	
	/**
	 * A j�t�kos stamin�j�nak be�ll�t�sa.
	 * @param s stamina �j �rt�ke
	 * @author Zalan
	 */
	public void setStamina(int s)
	{
		stamina = s;
	}
	
	/**
	 * A j�t�kos �let�nek be�ll�t�sa be�ll�t�sa.
	 * @param h health �j �rt�ke
	 * @author Zalan
	 */
	public void setHealth(int h)
	{
		health = h;
	}
	
	/**
	 * A met�dus �j, �res inventory-t hoz l�tre a j�t�kosnak.
	 * @author Zalan
	 */
	public void resetInventory()
	{
		inventory=new ArrayList<Item>();
	}
	
	/**
	 * A met�dus visszat�r a j�t�kos inventory-j�val.
	 * @author Zalan
	 */
	public ArrayList<Item> getInventory()
	{
		return inventory;
	}
	
	/**
	 * A met�dus visszat�r a j�t�kos stamin�j�val.
	 * @author Zalan
	 */
	public int getStamina()
	{
		return stamina;
	}
	
	/**
	 * A j�t�kos a param�terk�nt kapott karaktert �ssze�tk�zteti saj�t mag�val.
	 * @param c a karakter akivel �ssze�tk�ztetj�k magunkat
	 * @author Zalan
	 */
	public void collideWith(Character c) {
		c.hitBy(this);
	}

	/**
	 * Ha a j�t�kos jegesmedv�vel �tk�z�tt, akkor a j�t�kot elvesz�tett�k a j�t�kosok.
	 * @param pb a jegesmedve amivel a j�t�kos �ssze�tk�z�tt
	 * @author Zalan
	 */
	@Override
	public void hitBy(PolarBear pb) {
		Game.loseGame();
	}
	
	/**
	 * Tesztel�shez
	 */
	@Override
	public void Properties()
	{
		System.out.println(this.getClass());
		System.out.println("Name: " + getName());
		System.out.println("Health: " + health);
		System.out.println("Stamina: " + stamina);
		System.out.println("Is drowning: " + isDrowning);
		System.out.println("Diving suit: " + dSuitOn);
		System.out.println("Inventory:");
		for(Item i : inventory) {
			i.Properties();
		}
	}
}
