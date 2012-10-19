

public abstract class InterAction {

	public abstract boolean match(Cell self, Neighbors neighbors);

	public abstract Cell getResult(Cell self);
}
