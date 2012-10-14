import java.util.ArrayList;


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
