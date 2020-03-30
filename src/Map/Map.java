package Map;

import java.util.ArrayList;

import Core.Main;

public class Map 
{
	private ArrayList<Field> fields;
	
	// Mezõk létrehozása, szomszédosságok beállítása lesz itt.
	private void initFields() 
	{
		
	}
	
	//Hóvihar hívása a mezõkön.
	public void callBlizzardOnFields()
	{
		System.out.println(Main.tabok+"->[Map].callBlizzardOnFields()");
		Main.tabok+="\t";
		//Késõbb az egész 'field' tömbbön, jelenleg a forgatókönyv egy mezõre érvényes.
		Field f = new IceField();
		f.generateBlizzard();
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Map].callBlizzardOnFields()");
	}
}
