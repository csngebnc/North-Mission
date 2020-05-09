package Visual;

public abstract class FieldView implements Viewable{
	protected int x;
	protected int y;
	
	public FieldView(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int GetX() {return x;}
	public int GetY() {return y;}
	
	public abstract void draw(View v);
}
