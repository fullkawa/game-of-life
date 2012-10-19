
public class LonelinessAction extends InterAction {

	@Override
	public boolean match(Cell self, Neighbors neighbors) {
		boolean result = (neighbors.getPopulatedCount() <= 1);
		return result;
	}

	@Override
	public Cell getResult(Cell self) {
		return new EmptyCell(self.getX(), self.getY());
	}

}
