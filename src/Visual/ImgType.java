package Visual;

/**
 * Adott tárgyhoz tartozó kép tipusa
 * @author Balczer Dominik
 */
public enum ImgType {
	FROZEN(0),
	DROPPED(1),
	BUILT(2);
	
	/**
	 * Az adott enum értékhez tartozó számérték
	 * @author Balczer Dominik
	 */
	public final int VALUE;
	
	/**
	 * Inicializálása
	 * @param d : enumhoz tartozó érték
	 * @author Balczer Dominik
	 */
	ImgType(int d){
		this.VALUE = d;
	}
	
	/**
	 * Visszaadja a számként kapott állapothoz tartozó enumerációt
	 * @param n : Enumerációt meghatározó szám
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