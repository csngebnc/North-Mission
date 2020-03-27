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
		//Késõbb az egész 'field' tömbbön
		Field f = new IceField();
		f.generateBlizzard();
	}
}
