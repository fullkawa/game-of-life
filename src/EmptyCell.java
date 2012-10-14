
public class EmptyCell extends Cell {

	public EmptyCell(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean isPopulated() {
		return false;
	}

	@Override
	public Cell getNextGeneration(Neighbors neighbors) {
		Cell nextCell = this;
		int livCount = neighbors.getPopulatedCount();

		// Rule: birth
		if (livCount == 3) {
			nextCell = new PopulatedCell(this.getX(), this.getY());
		}
		return nextCell;
	}

	@Override
	public String toString() {
		return "□";
	}
}
