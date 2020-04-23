package Player;

import Map.Field;

public abstract class Character {
	
	protected Field field;

	public abstract void doTurn();
	public abstract void alterHealth(int n);
	public abstract void drainStamina();
	public abstract void drown();
	public abstract boolean save(Field f);
	public abstract void collideWith(Character c);
	public void hitBy(PolarBear pb) {}
	public void hitBy(Player pl) {}
	
	public void setField(Field f) {
		field = f;
	}
	public Field getField() {
		return field;
	}
	
	public void Properties()
	{
		
	}
}
