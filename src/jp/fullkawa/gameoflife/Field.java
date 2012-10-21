package jp.fullkawa.gameoflife;
import java.util.HashMap;

import jp.fullkawa.gameoflife.cell.Cell;
import jp.fullkawa.gameoflife.cell.EmptyCell;
import jp.fullkawa.gameoflife.cell.PopulatedCell;


public class Field {

	class Cells extends HashMap<Position, Cell> {

		private static final long serialVersionUID = -4289829287837123391L;

		Cell get(int x, int y) {
			Position position = new Position(x, y);
			return this.get(position);
		}

		void set(Cell cell) {
			this.put(cell.getPosition(), cell);
		}
	}

	private int width;
	private int height;
	private Cells cells = new Cells();

	public Field(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setCell(Cell cell) {
		this.cells.set(cell);
	}

	public Cell getCell(int x, int y) {
		return this.cells.get(x, y);
	}

	public Cell[] getAllCell() {
		return this.cells.values().toArray(new Cell[0]);
	}

	public void randomSetup() {
		for (int x=0; x<width; x++) {
			for (int y=0; y<height; y++) {
				Cell cell = (Math.random() < 0.5) ? new PopulatedCell(x, y) : new EmptyCell(x, y);
				this.setCell(cell);
			}
		}
	}

	public Field getNextGeneration() {
		Field nextField = new Field(this.width, this.height);

		for (Cell cell : this.getAllCell()) {
			Neighbors neighbors = this.getNeighbors(cell);
			Cell nextCell = cell.getNextGeneration(neighbors);
			nextField.setCell(nextCell);
		}

		return nextField;
	}

	Neighbors getNeighbors(Cell cell) {
		Neighbors neighbors = new Neighbors();

		int x = cell.getX();
		int y = cell.getY();
		for (int angle=0; angle<360; angle+=45) {
			int dx = (int)Math.round(Math.cos(Math.toRadians(angle)));
			int dy = (int)Math.round(Math.sin(Math.toRadians(angle))) * -1;
			Cell neighborCell = this.getCell(loop(x + dx, this.width), loop(y + dy, this.height));
			neighbors.add(neighborCell);
		}

		return neighbors;
	}

	/**
	 * Left of left edge column is right edge.
	 * Above first row is last row.
	 * @see testLoop !
	 *
	 * @param value
	 * @param length is width or height of field
	 *
	 * @return looped value
	 */
	int loop(int value, int length) {
		int looped = (length + value) % length;
		return looped;
	}

	public String getRowString(int y) {
		StringBuilder sb = new StringBuilder();
		for (int x=0; x<width; x++) {
			sb.append(this.getCell(x, y));
		}
		return sb.toString();
	}

	public void print() {
		for (int y=0; y<height; y++) {
			String row = this.getRowString(y);
			System.out.println(row);
		}
		System.out.println();
	}
}
