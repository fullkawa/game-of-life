package jp.fullkawa.gameoflife.interaction;

import jp.fullkawa.gameoflife.Neighbors;
import jp.fullkawa.gameoflife.cell.Cell;

public class SurvivesAction extends InterAction {

	@Override
	public boolean match(Cell self, Neighbors neighbors) {
		int count = neighbors.getPopulatedCount();
		return (self.isPopulated() && (count == 2 || count == 3));
	}
	@Override
	public Cell getResult(Cell self) {
		return self;
	}

}
