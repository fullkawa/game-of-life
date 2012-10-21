package jp.fullkawa.gameoflife.interaction;

import jp.fullkawa.gameoflife.Neighbors;
import jp.fullkawa.gameoflife.cell.Cell;


public abstract class InterAction {

	public abstract boolean match(Cell self, Neighbors neighbors);

	public abstract Cell getResult(Cell self);
}
