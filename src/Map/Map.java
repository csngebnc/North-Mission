package Map;

import java.util.ArrayList;
import Items.Barrel;
import Items.DivingSuit;
import Items.Food;
import Items.Grip;
import Items.Item;
import Items.LimitedShovel;
import Items.Rocket;
import Items.Rope;
import Items.Shovel;
import Map.Buildings.Tent;

/**
 * A j�t�k modellj�t �sszefog� P�lya oszt�ly
 * @author Csonge Bence
 */
public class Map {
	
	/**
	 * P�lya mez�i
	 * @author Csonge Bence
	 */
	private ArrayList<Field> fields;
	
	/**
	 * Konstruktor, inicializ�lja a mez�ketet t�rol� list�t
	 * @author Csonge Bence
	 */
	public Map() {
		fields = new ArrayList<Field>();
	}
	
	/**
	 * T�rgyak gener�l�sa p�ly�n a j�gbe
	 * @author Balczer Dominik
	 */
	private void generateItems() {
		//Gener�land� t�rgyak
		ArrayList<Item> items = new ArrayList<Item>();
		
		//Lek�r�nk bizonyos mennyis�get v�letlenszer�en minden eldobhat� t�rgyab�l
		try {
			items.addAll(new Food().generateInstances((int)(Math.random()*10)+15));
			items.addAll(new Rope().generateInstances((int)(Math.random()*3)+3));
			items.addAll(new DivingSuit().generateInstances((int)(Math.random()*3)+1));
			items.addAll(new Tent().generateInstances((int)(Math.random()*2)+2));
			items.addAll(new Shovel().generateInstances((int)(Math.random()*2)+1));
			items.addAll(new LimitedShovel().generateInstances((int)(Math.random()*5)+2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//L�trehozzuk a jelz�pisztoly alkatr�szeit
		items.add(new Barrel());
		items.add(new Rocket());
		items.add(new Grip());
		
		//Elhelyezz�k a gener�land� t�rgyakat a mez�kben
		for(Item item : items) {
			int fieldIndex = (int)(Math.random()*fields.size());
			while(!fields.get(fieldIndex).addFrozenItem(item))
				fieldIndex = (int)(Math.random()*fields.size());
		}
	}
	
	/**
	 * P�lya alaphelyzetbe �llit�sa
	 * @param playerCount : H�nyan fogj�k j�tszani a j�t�kot
	 * @author Balczer Dominik
	 */
	public void Reset(int playerCount) {

		fields = new ArrayList<Field>();
		
		//Megjelenit�shez sz�ks�ges konstansok
		int offsetX = 95;
		int offsetXRows = 47;
		int offsetY = 30;
		int rows = 16;
		int columns = 11;
		int startX = 88;
		int startY = 110;
		
		//Mez�k l�trehoz�sa
		for(int row = 0; row < rows; row++) {
			
			int x = startX;
			int y = startY + row * offsetY;
			if(row%2 == 1)
				x += offsetXRows;
			
			for(int column = 0; column < columns; column++) {
				
				double fieldSeed = Math.random()*100;
				
				if(fieldSeed < 75)
					fields.add(new IceField(x, y, playerCount));
				else if(fieldSeed < 92) {
					fields.add(new UnstableField(x, y, playerCount));
				}
				else if(fieldSeed < 97)
					fields.add(new Hole(x, y));
				
				x += offsetX;
			}
		}
		
		//Kezd�mez� stabill� t�tele
		fields.set(0, new IceField(startX, startY, playerCount));
		fields.set(1, new IceField(startX+95, startY, playerCount));
		fields.set(2, new IceField(startX+190, startY, playerCount));
		
		//Szomsz�d kapcsolatok kialakit�sa
		for(Field f : fields)
			f.discoverNeighbours(fields);
		
		generateItems();
	}
	
	/**
	 * H�vihar esem�ny�l �rtesit�s k�ld�se az �sszes mez�nek
	 * @author Csonge Bence
	 */
	public void callBlizzardOnFields(){
		for(Field f: fields) 
			f.generateBlizzard();
	}
	
	/**
	 * �p�letek tick-el�se az �sszes mez�n
	 * @author Csonge Bence
	 */
	public void tickBuildings() {
		for(Field f: fields) 
			f.tickBuilding();
	}
	
	/**
	 * Visszaadja a mez�ket t�rol� t�mbb�t
	 * @author Csonge Bence
	 */
	public ArrayList<Field> getFields(){
		return fields;
	}
	
	/**
	 * Visszaadja a p�lya adott sorsz�m� mez�j�t
	 * @author Balczer Dominik
	 */
	public Field getField(int i) {
		return fields.get(i);
	}
}