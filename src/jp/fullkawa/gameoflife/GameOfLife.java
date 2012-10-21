package jp.fullkawa.gameoflife;

public class GameOfLife {

	/*
	 * Game Condition
	 */
	protected static int generation;
	protected static int maxGeneration;
	protected static Field field;

	protected static void setInitialCondition() {
		generation = 1;
		maxGeneration = 100;

		field  = new Field(10, 10);
		field.randomSetup();

		System.out.println("* Initial Condition *");
		field.print();
	}

	protected static int nextGeneration() {
		field = field.getNextGeneration();
		generation++;

		System.out.println(">> Generation " + generation);
		field.print();

		return generation;
	}

	protected static void play() {
		while (generation < maxGeneration) {
			nextGeneration();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		setInitialCondition();
		play();
	}
}
