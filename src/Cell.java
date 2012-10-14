
public abstract class Cell {

	private Position position;

	public Cell(int x, int y) {
		position = new Position(x, y);
	}

	public Position getPosition() {
		return position;
	}

	public int getX() {
		return position.getX();
	}

	public int getY() {
		return position.getY();
	}

	public abstract boolean isPopulated();

	public abstract Cell getNextGeneration(Neighbors neighbors);
}
