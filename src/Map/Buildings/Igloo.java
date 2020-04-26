package Map.Buildings;

public class Igloo implements Building{

	public Igloo() {}
	
	/*
	 * A tick() metódus jelen esetben false értékkel tér vissza, mivel egy iglu élettartama egy játékra szól.
	 * @author Csonge Bence
	 */
	@Override
	public boolean tick() {
		return false;
	}

	/*
	 * Az attack() metódus jelen esetben false értékkel tér vissza, mivel egy olyan mezõn nem lehet játékosokat megtámadni,
	 * ahol iglu van felépítve.
	 * @author Csonge Bence
	 */
	@Override
	public boolean attack() {
		return false;
	}

}
