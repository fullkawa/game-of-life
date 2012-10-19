
public class SurvivesAction extends InterAction {

	@Override
	public boolean match(Cell self, Neighbors neighbors) {
		int count = neighbors.getPopulatedCount();
		boolean result = (count == 2 || count == 3);
		return result;
	}
	@Override
	public Cell getResult(Cell self) {
		return new PopulatedCell(self.getX(), self.getY());
	}

}
