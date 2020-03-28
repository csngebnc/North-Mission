package Map;

import java.util.ArrayList;

import Core.Main;

public class Map 
{
	private ArrayList<Field> fields;
	
	private void initFields() 
	{
		
	}
	
	//Dominik
	public void callBlizzardOnFields()
	{
		System.out.println(Main.tabok+"->[Map].callBlizzardOnFields()");
		Main.tabok+="\t";
		//Késõbb az egész 'field' tömbbön
		Field f = new IceField();
		f.generateBlizzard();
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Map].callBlizzardOnFields()");
	}
}
