package Player;

import Map.Field;

public abstract class Character {
	
	protected Field field;

	public abstract void doTurn();
	public abstract void alterHealth(int n);
	public abstract void drainStamina();
	public abstract void drown();
	public abstract boolean save(Field f);
	public abstract void attack();
}
