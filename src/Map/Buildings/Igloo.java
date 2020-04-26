package Map.Buildings;

public class Igloo implements Building{

	public Igloo() {}
	
	/*
	 * A tick() metodus jelen esetben false ertekkel ter vissza, mivel egy iglu elettartama egy jatekra szol.
	 * @author Csonge Bence
	 */
	@Override
	public boolean tick() {
		return false;
	}

	/*
	 * Az attack() metodus jelen esetben false ertekkel ter vissza, mivel egy olyan mezon nem lehet jatekosokat megtamadni,
	 * ahol iglu van felepitve.
	 * @author Csonge Bence
	 */
	@Override
	public boolean attack() {
		return false;
	}

}
