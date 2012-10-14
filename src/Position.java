
public class Position {

	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		return x * 1000 + y;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Position) {
			Position another = (Position)obj;
			if (this.getX() == another.getX() && this.getY() == another.getY()) {
				result = true;
			}
		}
		return result;
	}
}
