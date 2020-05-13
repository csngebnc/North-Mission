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
 * A pálya osztalya.
 * @author Csonge Bence
 */
public class Map 
{
	/**
	 * A pálya mezõi.
	 */
	private ArrayList<Field> fields;
	
	/**
	 * Palya konstruktora
	 * @author Csonge Bence
	 */
	public Map() {
		initFields();
	}
	
	/**
	 * Mezok tarolojanak inicializalasa, proto allapotban a mezoket es a mezok kozotti kapcsolatokat
	 * parancsokkal kell beallitani.
	 * @author Csonge Bence
	 */
	private void initFields() 
	{
		fields = new ArrayList<Field>();
	}
	
	/**
	 * Hovihar hivasa a palya osszes mezojen.
	 * @author Csonge Bence
	 */
	public void callBlizzardOnFields()
	{
		for(Field f: fields) {
			f.generateBlizzard();
		}
	}
	
	/**
	 * A palya mezoin talalhato epuletek tick-elese, ertesitese uj kor kezdeterol.
	 * @author Csonge Bence
	 */
	public void tickBuildings() {
		for(Field f: fields) {
			f.tickBuilding();
		}
	}
	
	public ArrayList<Field> getFields(){
		return fields;
	}
	
	/**
	 * A tovabbi metodusok getter/setter, valamint teszteleshez hasznalt metodusok.
	 */
	
	public Field getField(int i) {
		return fields.get(i);
		
	}
	
	public int getFieldNumber(Field f)
	{
		return fields.indexOf(f);
	}
	
	public ArrayList<Item> generateInstances(int count, String klass){
		ArrayList<Item> array = new ArrayList<Item>();
		for(int i = 0; i < count; i++) {
			try {
					Class.forName(klass).newInstance();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return array;
	}
	
	private void generateItems() {
		ArrayList<Item> items = new ArrayList<Item>();
		
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
		
		items.add(new Barrel());
		items.add(new Rocket());
		items.add(new Grip());
		
		for(Item item : items) {
			int fieldIndex = (int)(Math.random()*fields.size());
			while(!fields.get(fieldIndex).addFrozenItem(item))
				fieldIndex = (int)(Math.random()*fields.size());
		}
	}
	
	public void Reset(int playerCount) {

		fields = new ArrayList<Field>();
		
		// EGY FIELD 95 hosszú, 30 mélység/sor, 47 eltolás (CSAK EGYSZER) felsõ és alsó sor között
		
		int offsetX = 95;
		int offsetXRows = 47;
		int offsetY = 30;
		int rows = 16;
		int columns = 11;
		int startX = 88;
		int startY = 110;
		
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
		
		fields.set(0, new IceField(startX, startY, playerCount));
		
		for(Field f : fields)
			f.discoverNeighbours(fields);
		
		generateItems();
	}
}
