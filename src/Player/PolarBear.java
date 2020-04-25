package Player;

import java.util.Random;

import Core.Game;
import Map.Field;

public class PolarBear extends Character{

	@Override
	public void doTurn() {
		int max = field.getNeighbours().size()-1;
		field.moveMeTo(this, (int)(Math.random()*max));
	}

	@Override
	public void alterHealth(int n) {
		
	}

	@Override
	public void drainStamina() {
		
	}

	@Override
	public void drown() {
		
	}

	
	//Miért van a polar bearnek save metódusa?
	
	@Override
	public boolean save(Field f) {
		return false;
	}

	@Override
	public void collideWith(Character c) {
		c.hitBy(this);
	}

	@Override
	public void hitBy(Player p) {
		Game.loseGame();		
	}
	
	@Override
	public void Properties()
	{
		System.out.println("Jegesmedve");
	}
	
	public String getName() {
		return "Jegesmedve";
	}

}
