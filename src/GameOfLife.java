
public class GameOfLife {

	/*
	 * Game Condition
	 */
	private static int width = 10;
	private static int height = 10;

	private static int maxGeneration = 100;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Field field = new Field(width, height);
		field.randomSetup();

		for (int generation = 1; generation <= maxGeneration; generation++) {
			Field nextField = field.getNextGeneration();

			System.out.println("Generation " + generation + ":");
			nextField.print();

			field = nextField;
		}
	}
}
