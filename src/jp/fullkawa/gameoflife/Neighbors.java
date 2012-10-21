package jp.fullkawa.gameoflife;
import java.util.ArrayList;

import jp.fullkawa.gameoflife.cell.Cell;


public class Neighbors extends ArrayList<Cell> {

	private static final long serialVersionUID = 2392450160961439929L;

	public int getPopulatedCount() {
		int count = 0;
		for (Cell cell : this) {
			if (cell.isPopulated()) count++;
		}
		return count;
	}
}
