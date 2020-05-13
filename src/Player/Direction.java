package Player;

/**
 * Ir�nyok enumer�ci�ja, tartalmazza az �sszes olyan ir�nyt, amely fel� interakci�t lehet v�gezni.
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
	 * Az adott enum �rt�khez tartoz� sz�m�rt�k, jelen esetben szomsz�d helyzete.
	 * @author Csonge Bence
	 */
	public final int VALUE;
	
	/**
	 * Direction inicializ�l�sa
	 * @param d enumhoz tartoz� �rt�k
	 * @author Csonge Bence
	 */
	Direction(int d){
		this.VALUE = d;
	}
	
	/**
	 * Visszaadja a sz�mk�nt kapott ir�nyhoz tartoz� enumer�ci�s ir�nyt.
	 * @param n H�nyadik szomsz�d.
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
