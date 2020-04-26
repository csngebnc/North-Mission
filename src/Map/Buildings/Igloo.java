package Map.Buildings;

public class Igloo implements Building{

	public Igloo() {}
	
	/*
	 * A tick() met�dus jelen esetben false �rt�kkel t�r vissza, mivel egy iglu �lettartama egy j�t�kra sz�l.
	 * @author Csonge Bence
	 */
	@Override
	public boolean tick() {
		return false;
	}

	/*
	 * Az attack() met�dus jelen esetben false �rt�kkel t�r vissza, mivel egy olyan mez�n nem lehet j�t�kosokat megt�madni,
	 * ahol iglu van fel�p�tve.
	 * @author Csonge Bence
	 */
	@Override
	public boolean attack() {
		return false;
	}

}
