package Map;

import java.util.ArrayList;

public class Map 
{
	private ArrayList<Field> fields;
	
	private void initFields() 
	{
		
	}
	
	//Dominik
	public void callBlizzardOnFields()
	{
		//K�s�bb az eg�sz 'field' t�mbb�n
		Field f = new IceField();
		f.generateBlizzard();
	}
}
