package jp.fullkawa.gameoflife.cell;

public class PopulatedCell extends Cell {

	public PopulatedCell(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean isPopulated() {
		return true;
	}

	@Override
	public String toString() {
		return "■";
	}
}
