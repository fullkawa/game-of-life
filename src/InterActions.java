
import java.util.ArrayList;

public class InterActions extends ArrayList<InterAction> {

	private static final long serialVersionUID = -8887852360876471923L;

	public Cell getResult(Cell self, Neighbors neighbors) {
		Cell resultCell = self;
		for (InterAction action : this) {
			if (action.match(self, neighbors)) {
				resultCell = action.getResult(self);
			}
		}
		return resultCell;
	}
}
