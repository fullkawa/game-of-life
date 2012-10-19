
public class OverpopulationAction extends InterAction {

	@Override
	public boolean match(Cell self, Neighbors neighbors) {
		boolean result = (neighbors.getPopulatedCount() >= 4);
		return result;
	}

	@Override
	public Cell getResult(Cell self) {
		return new EmptyCell(self.getX(), self.getY());
	}

}
