package Map;

import java.util.ArrayList;

import Core.Main;

public class Map 
{
	private ArrayList<Field> fields;
	
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
}
