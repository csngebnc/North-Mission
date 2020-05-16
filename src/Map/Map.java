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
 * A játék modelljét összefogó Pálya osztály
 * @author Csonge Bence
 */
public class Map {
	
	/**
	 * Pálya mezõi
	 * @author Csonge Bence
	 */
	private ArrayList<Field> fields;
	
	/**
	 * Konstruktor, inicializálja a mezõketet tároló listát
	 * @author Csonge Bence
	 */
	public Map() {
		fields = new ArrayList<Field>();
	}
	
	/**
	 * Tárgyak generálása pályán a jégbe
	 * @author Balczer Dominik
	 */
	private void generateItems() {
		//Generálandó tárgyak
		ArrayList<Item> items = new ArrayList<Item>();
		
		//Lekérünk bizonyos mennyiséget véletlenszerûen minden eldobható tárgyaból
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
		
		//Létrehozzuk a jelzõpisztoly alkatrészeit
		items.add(new Barrel());
		items.add(new Rocket());
		items.add(new Grip());
		
		//Elhelyezzük a generálandó tárgyakat a mezõkben
		for(Item item : items) {
			int fieldIndex = (int)(Math.random()*fields.size());
			while(!fields.get(fieldIndex).addFrozenItem(item))
				fieldIndex = (int)(Math.random()*fields.size());
		}
	}
	
	/**
	 * Pálya alaphelyzetbe állitása
	 * @param playerCount : Hányan fogják játszani a játékot
	 * @author Balczer Dominik
	 */
	public void Reset(int playerCount) {

		fields = new ArrayList<Field>();
		
		//Megjelenitéshez szükséges konstansok
		int offsetX = 95;
		int offsetXRows = 47;
		int offsetY = 30;
		int rows = 16;
		int columns = 11;
		int startX = 88;
		int startY = 110;
		
		//Mezõk létrehozása
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
		
		//Kezdõmezõ stabillá tétele
		fields.set(0, new IceField(startX, startY, playerCount));
		fields.set(1, new IceField(startX+95, startY, playerCount));
		fields.set(2, new IceField(startX+190, startY, playerCount));
		
		//Szomszéd kapcsolatok kialakitása
		for(Field f : fields)
			f.discoverNeighbours(fields);
		
		generateItems();
	}
	
	/**
	 * Hóvihar eseményõl értesités küldése az összes mezõnek
	 * @author Csonge Bence
	 */
	public void callBlizzardOnFields(){
		for(Field f: fields) 
			f.generateBlizzard();
	}
	
	/**
	 * Épületek tick-elése az összes mezõn
	 * @author Csonge Bence
	 */
	public void tickBuildings() {
		for(Field f: fields) 
			f.tickBuilding();
	}
	
	/**
	 * Visszaadja a mezõket tároló tömbböt
	 * @author Csonge Bence
	 */
	public ArrayList<Field> getFields(){
		return fields;
	}
	
	/**
	 * Visszaadja a pálya adott sorszámú mezõjét
	 * @author Balczer Dominik
	 */
	public Field getField(int i) {
		return fields.get(i);
	}
}