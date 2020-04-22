package Map;

import java.util.ArrayList;

import Core.Main;

public class Map 
{
	private ArrayList<Field> fields;
	
	public Map() {
		initFields();
	}
	
	// Mez�k l�trehoz�sa, szomsz�doss�gok be�ll�t�sa lesz itt.
	private void initFields() 
	{
		fields = new ArrayList<Field>();
	}
	
	//H�vihar h�v�sa a mez�k�n.
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
