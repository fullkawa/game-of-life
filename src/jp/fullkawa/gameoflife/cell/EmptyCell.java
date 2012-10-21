package jp.fullkawa.gameoflife.cell;

public class EmptyCell extends Cell {

	public EmptyCell(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean isPopulated() {
		return false;
	}

	@Override
	public String toString() {
		return "□";
	}
}
