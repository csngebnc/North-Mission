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
		for(Field f : fields)
			f.generateBlizzard();
	}
}
