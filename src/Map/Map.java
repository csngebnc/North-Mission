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
		//K�s�bb az eg�sz 'field' t�mbb�n
		Field f = new IceField();
		f.generateBlizzard();
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Map].callBlizzardOnFields()");
	}
}
