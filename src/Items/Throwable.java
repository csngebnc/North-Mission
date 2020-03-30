package Items;

import Core.Main;
import Map.Field;

public abstract class Throwable extends Item 
{
	// Tárgy eldobása egy mezõre. Eldobható tárgy esete.
	public boolean throwTo(Field f) 
	{
		System.out.println(Main.tabok+"->[Throwable].throwTo(Field f)");
		Main.tabok+="\t";
		f.acceptItem(this);
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Throwable].throwTo(Field f)");
		return true;
	}
	
	// Eldobható, nem alkatrész tárgy felvétele.
	public void pickUp() 
	{
		System.out.println(Main.tabok+"->[Throwable].pickUp()");
		System.out.println(Main.tabok+"<-[Throwable].pickUp()");
	}
}
