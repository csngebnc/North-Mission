package Map;

import java.util.ArrayList;

import Core.Main;

public class Map 
{
	private ArrayList<Field> fields;
	
	// Mez�k l�trehoz�sa, szomsz�doss�gok be�ll�t�sa lesz itt.
	private void initFields() 
	{
		
	}
	
	//H�vihar h�v�sa a mez�k�n.
	public void callBlizzardOnFields()
	{
		System.out.println(Main.tabok+"->[Map].callBlizzardOnFields()");
		Main.tabok+="\t";
		//K�s�bb az eg�sz 'field' t�mbb�n, jelenleg a forgat�k�nyv egy mez�re �rv�nyes.
		Field f = new IceField();
		f.generateBlizzard();
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Map].callBlizzardOnFields()");
	}
}
