package Visual;

/**
 * Adott t�rgyhoz tartoz� k�p tipusa
 * @author Balczer Dominik
 */
public enum ImgType {
	FROZEN(0),
	DROPPED(1),
	BUILT(2);
	
	/**
	 * Az adott enum �rt�khez tartoz� sz�m�rt�k
	 * @author Balczer Dominik
	 */
	public final int VALUE;
	
	/**
	 * Inicializ�l�sa
	 * @param d : enumhoz tartoz� �rt�k
	 * @author Balczer Dominik
	 */
	ImgType(int d){
		this.VALUE = d;
	}
	
	/**
	 * Visszaadja a sz�mk�nt kapott �llapothoz tartoz� enumer�ci�t
	 * @param n : Enumer�ci�t meghat�roz� sz�m
	 * @author Balczer Domoinik
	 */
	public static ImgType FromInt(int n) {
		switch(n) {
		case 0:
			return ImgType.FROZEN;
		case 1:
			return ImgType.DROPPED;
		case 2:
			return ImgType.BUILT;
		default:
			return null;
		}
	}
}