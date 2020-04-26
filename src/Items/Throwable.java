package Items;

import Map.Field;

/**
 * 
 * @author Norbi
 * Egy absztrakt osztály, az eldobható tárgyak õse. 
 * Mivel a játék során a tárgyak átadás céljából felvétel után ismét eldobhatóak, 
 * így ennek az osztálynak a bevezetése szükséges. 
 */
public abstract class Throwable implements Item 
{
	/**
	 * Tárgy eldobása egy mezõre. Eldobható tárgy esete.
	 * 
	 * @param f az a mezõ akire dobjuk a tárgyat.
	 */
	public boolean throwTo(Field f) 
	{
		f.acceptItem(this);
		return true;
	}
	
	/**
	 * Eldobható, nem alkatrész tárgy felvétele.
	 * 
	 * 
	 */
	public void pickUp() 
	{
		
	}
	
	public void Properties() 
	{
		System.out.println(this.getClass());
	}
}
