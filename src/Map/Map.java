package Map;

import java.util.ArrayList;
import Items.Barrel;
import Items.Grip;
import Items.Item;
import Items.Rocket;
import Items.Shovel;
import Map.Buildings.Igloo;
import Map.Buildings.Tent;
import Core.Game;
import Core.Main;

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
	
	public void ResetNew() {

		fields = new ArrayList<Field>();
		
		// EGY FIELD 95 hosszú, 30 mélység/sor, 47 eltolás (CSAK EGYSZER) felsõ és alsó sor között
		
		int offsetX = 95;
		int offsetXRows = 47;
		int offsetY = 30;
		int rows = 16;
		int columns = 11;
		
		for(int row = 0; row < rows; row++) {
			
			int x = 0;
			int y = 100 + row * offsetY;
			if(row%2 == 1)
				x += offsetXRows;
			
			for(int column = 0; column < columns; column++) {
				
				double fieldSeed = Math.random()*100;
			
				x += offsetX;
				
				if(fieldSeed < 75)
					fields.add(new IceField(x, y));
				else if(fieldSeed < 85) {
					fields.add(new UnstableField(x, y));
				}
				else if(fieldSeed < 101)
					fields.add(new Hole(x, y));
			}
		}
		
		fields.set(0, new IceField(offsetX ,100));
		
		for(Field f : fields)
			f.discoverNeighbours(fields);
	}
	
	public void Reset() 
	{
		fields = new ArrayList<Field>();
		
		Field f1 = new IceField(100,100);
		Field f2 = new IceField(195,100);
		Field f3 = new IceField(290,100);
		Field f4 = new IceField(385,100);
		
		Field f5 = new IceField(147,130);
		Field f6 = new IceField(242,130);
		Field f7 = new IceField(337,130);
		Field f8 = new Hole(432,130);
		
		Field f9 = new IceField(100,160);
		Field f10 = new Hole(290,160);
		Field f11 = new IceField(385,160);
		
		Field f12 = new UnstableField(147,190);
		Field f13 = new IceField(242,190);

		
		f1.addNeighbour(1,f2);
		f1.addNeighbour(2,f5);
		
		f2.addNeighbour(1,f3);
		f2.addNeighbour(2,f6);
		f2.addNeighbour(3,f5);
		f2.addNeighbour(4,f1);
		
		f3.addNeighbour(1,f4);
		f3.addNeighbour(2,f7);
		f3.addNeighbour(3,f6);
		f3.addNeighbour(4,f2);
		
		f4.addNeighbour(2,f8);
		f4.addNeighbour(3,f7);
		f4.addNeighbour(4,f3);
		
		f5.addNeighbour(0,f2);
		f5.addNeighbour(1,f6);
		f5.addNeighbour(3,f9);
		f5.addNeighbour(5,f1);
		
		f6.addNeighbour(0,f3);
		f6.addNeighbour(1,f7);
		f6.addNeighbour(2,f10);
		f6.addNeighbour(4,f5);
		f6.addNeighbour(5,f2);
		
		f7.addNeighbour(0,f4);
		f7.addNeighbour(1,f8);
		f7.addNeighbour(2,f11);
		f7.addNeighbour(3,f10);
		f7.addNeighbour(4,f6);
		f7.addNeighbour(5,f3);
		
		f8.addNeighbour(3,f11);
		f8.addNeighbour(4,f7);
		f8.addNeighbour(5,f4);
		
		f9.addNeighbour(0,f5);
		f9.addNeighbour(2,f12);
		
		f10.addNeighbour(0,f7);
		f10.addNeighbour(1,f11);
		f10.addNeighbour(3,f13);
		f10.addNeighbour(5,f6);
		
		f11.addNeighbour(0,f8);
		f11.addNeighbour(4,f10);
		f11.addNeighbour(5,f7);
		
		f12.addNeighbour(1,f13);
		f12.addNeighbour(5,f9);
		
		f13.addNeighbour(0,f10);
		f13.addNeighbour(4,f12);

		
		f1.setFrozenItem(new Barrel());
		f5.setFrozenItem(new Grip());
		f8.setFrozenItem(new Rocket());
		f9.setFrozenItem(new Shovel());
		f1.addItem(new Shovel());
		f1.addItem(new Tent());

		f12.setLimit(4);
		f1.setSnowLayers(10);
		
		f2.setBuilding(new Igloo());
		
		fields.add(f1);
		fields.add(f2);
		fields.add(f3);
		fields.add(f4);
		fields.add(f5);
		fields.add(f6);
		fields.add(f7);
		fields.add(f8);
		fields.add(f9);
		fields.add(f10);
		fields.add(f11);
		fields.add(f12);
		fields.add(f13);
	}
}
