package Map;

import java.util.ArrayList;
import Items.Barrel;
import Items.Grip;
import Items.Item;
import Items.Rocket;
import Items.Shovel;
import Core.Main;

public class Map 
{
	private ArrayList<Field> fields;
	
	public Map() {
		initFields();
	}
	
	// Mezõk létrehozása, szomszédosságok beállítása lesz itt.
	private void initFields() 
	{
		fields = new ArrayList<Field>();
	}
	
	//Hóvihar hívása a mezõkön.
	public void callBlizzardOnFields()
	{
		for(Field f: fields) {
			f.generateBlizzard();
		}
	}
	
	public void tickBuildings() {
		for(Field f: fields) {
			f.tickBuilding();
		}
	}
	
	public Field getField(int i) {
		return fields.get(i-1);
	}
	
	public void Reset() {

		fields = new ArrayList<Field>();
		Field f1 = new UnstableField();
		Field f2 = new IceField();
		Field f3 = new Hole();
		Field f4 = new Hole();
		Field f5 = new IceField();
		Field f6 = new UnstableField();
		Field f7 = new Hole();
		Field f8 = new IceField();
		Field f9 = new IceField();
		Field f10 = new Hole();
		Field f11 = new IceField();
		Field f12 = new Hole();
		Field f13 = new UnstableField();
		
		f1.addNeighbour(f2);
		f1.addNeighbour(f3);
		f1.addNeighbour(f8);
		
		f2.addNeighbour(f3);
		f2.addNeighbour(f5);
		f2.addNeighbour(f4);
		f2.addNeighbour(f1);
		
		f3.addNeighbour(f6);
		f3.addNeighbour(f5);
		f3.addNeighbour(f2);
		
		f4.addNeighbour(f5);
		f4.addNeighbour(f9);
		f4.addNeighbour(f8);
		f4.addNeighbour(f1);
		
		f5.addNeighbour(f3);
		f5.addNeighbour(f6);
		f5.addNeighbour(f10);
		f5.addNeighbour(f9);
		f5.addNeighbour(f4);
		f5.addNeighbour(f2);
		
		f6.addNeighbour(f7);
		f6.addNeighbour(f11);
		f6.addNeighbour(f10);
		f6.addNeighbour(f5);
		f6.addNeighbour(f3);
		
		f7.addNeighbour(f11);
		f7.addNeighbour(f6);
		
		f8.addNeighbour(f4);
		f8.addNeighbour(f9);
		f8.addNeighbour(f12);
		f8.addNeighbour(f1);
		
		f9.addNeighbour(f5);
		f9.addNeighbour(f10);
		f9.addNeighbour(f13);
		f9.addNeighbour(f12);
		f9.addNeighbour(f8);
		f9.addNeighbour(f4);
		
		f10.addNeighbour(f6);
		f10.addNeighbour(f11);
		f10.addNeighbour(f13);
		f10.addNeighbour(f9);
		f10.addNeighbour(f5);
		
		f11.addNeighbour(f7);
		f11.addNeighbour(f13);
		f11.addNeighbour(f10);
		f11.addNeighbour(f6);
		
		f12.addNeighbour(f9);
		f12.addNeighbour(f13);
		f12.addNeighbour(f8);
		
		f13.addNeighbour(f10);
		f13.addNeighbour(f11);
		f13.addNeighbour(f12);
		f13.addNeighbour(f9);
		
		f1.setFrozenItem(new Barrel());
		f5.setFrozenItem(new Grip());
		f8.setFrozenItem(new Rocket());
		f9.setFrozenItem(new Shovel());
		
		f1.setLimit(4);
		f6.setLimit(4);
		f13.setLimit(4);
		
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
