package Items;

import java.util.ArrayList;

import Map.Field;

/**
 * Egy absztrakt osztály, az eldobható tárgyak õse. 
 * Mivel a játék során a tárgyak átadás céljából felvétel után ismét eldobhatóak, 
 * így ennek az osztálynak a bevezetése szükséges.
 * @author Norbi 
 */
public abstract class Throwable implements Item 
{
	/**
	 * Tárgy eldobása egy mezõre. Eldobható tárgy esete.
	 * @param f az a mezõ akire dobjuk a tárgyat.
	 */
	public boolean throwTo(Field f) 
	{
		f.acceptItem(this);
		return true;
	}
	
	/**
	 * Eldobható, nem alkatrész tárgy felvétele.
	 */
	public void pickUp() 
	{
		return;
	}
	
	public ArrayList<Item> generateInstances(int count) throws IllegalAccessException, InstantiationException {
        ArrayList<Item> array = new ArrayList<Item>();
        for (int i = 0; i < count; i++) {
            array.add(this.getClass().newInstance());
        }
        return array;
    }
}