
public class EmptyCell extends Cell {

	public EmptyCell(int x, int y) {
		super(x, y);
	}

	@Override
	protected InterActions getInterActions() {
		InterActions actions = new InterActions();

		actions.add(new BirthAction());

		return actions;
	}

	@Override
	public boolean isPopulated() {
		return false;
	}

	@Override
	public String toString() {
		return "□";
	}
}
