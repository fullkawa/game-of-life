package jp.fullkawa.gameoflife.cell;

import jp.fullkawa.gameoflife.Neighbors;
import jp.fullkawa.gameoflife.Position;
import jp.fullkawa.gameoflife.interaction.InterActions;

public abstract class Cell {

	private Position position;
	private InterActions interactions;

	public Cell(int x, int y) {
		position = new Position(x, y);
		interactions = this.getInterActions();
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

	protected abstract InterActions getInterActions();

	public Cell getNextGeneration(Neighbors neighbors) {
		Cell nextCell = this;

		if (interactions != null) {
			nextCell = interactions.getResult(this, neighbors);
		}
		return nextCell;
	}

	public abstract boolean isPopulated();
}
