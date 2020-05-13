package Player;

/**
 * Irányok enumerációja, tartalmazza az összes olyan irányt, amely felé interakciót lehet végezni.
 * @author Csonge Bence
 */
public enum Direction {
	UPPER_RIGHT (0),
	RIGHT (1),
	BOTTOM_RIGHT (2),
	BOTTOM_LEFT (3),
	LEFT (4),
	UPPER_LEFT (5);
	
	/**
	 * Az adott enum értékhez tartozó számérték, jelen esetben szomszéd helyzete.
	 * @author Csonge Bence
	 */
	public final int VALUE;
	
	/**
	 * Direction inicializálása
	 * @param d enumhoz tartozó érték
	 * @author Csonge Bence
	 */
	Direction(int d){
		this.VALUE = d;
	}
	
	/**
	 * Visszaadja a számként kapott irányhoz tartozó enumerációs irányt.
	 * @param n Hányadik szomszéd.
	 * @author Csonge Bence
	 */
	public static Direction FromInt(int n) {
		switch(n) {
		case 0:
			return Direction.UPPER_RIGHT;
		case 1:
			return Direction.RIGHT;
		case 2:
			return Direction.BOTTOM_RIGHT;
		case 3:
			return Direction.BOTTOM_LEFT;
		case 4:
			return Direction.LEFT;
		case 5:
			return Direction.UPPER_LEFT;
		default:
			return null;
		}
	}
}
