
public class PopulatedCell extends Cell {

	public PopulatedCell(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean isPopulated() {
		return true;
	}

	@Override
	public Cell getNextGeneration(Neighbors neighbors) {
		Cell nextCell = this;
		int livCount = neighbors.getPopulatedCount();

		// Rule: survives
		if (livCount == 2 || livCount == 3) {
			// nothing to do
		}
		// Rule: loneliness
		if (livCount <= 1) {
			nextCell = new EmptyCell(this.getX(), this.getY());
		}
		// Rule: overpopulation
		if (livCount >= 4) {
			nextCell = new EmptyCell(this.getX(), this.getY());
		}
		return nextCell;
	}

	@Override
	public String toString() {
		return "■";
	}
}
