
public class BirthAction extends InterAction {

	@Override
	public boolean match(Cell self, Neighbors neighbors) {
		boolean result = (neighbors.getPopulatedCount() == 3);
		return result;
	}

	@Override
	public Cell getResult(Cell self) {
		return new PopulatedCell(self.getX(), self.getY());
	}

}
