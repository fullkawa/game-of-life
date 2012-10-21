package jp.fullkawa.gameoflife.interaction;

import jp.fullkawa.gameoflife.Neighbors;
import jp.fullkawa.gameoflife.cell.Cell;
import jp.fullkawa.gameoflife.cell.EmptyCell;

public class OverpopulationAction extends InterAction {

	@Override
	public boolean match(Cell self, Neighbors neighbors) {
		return (self.isPopulated() && neighbors.getPopulatedCount() >= 4);
	}

	@Override
	public Cell getResult(Cell self) {
		return new EmptyCell(self.getX(), self.getY());
	}

}
