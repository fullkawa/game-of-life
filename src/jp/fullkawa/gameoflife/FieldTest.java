package jp.fullkawa.gameoflife;
import static org.junit.Assert.*;
import jp.fullkawa.gameoflife.cell.Cell;
import jp.fullkawa.gameoflife.cell.EmptyCell;
import jp.fullkawa.gameoflife.cell.PopulatedCell;

import org.junit.Before;
import org.junit.Test;


public class FieldTest {

	private Field field;

	@Before
	public void setUp() throws Exception {
		field = new Field(4, 3);
		for (int x=0; x<field.getWidth(); x++) {
			Cell cell = new EmptyCell(x, 0);
			field.setCell(cell);
		}
		for (int x=0; x<field.getWidth(); x++) {
			Cell cell = new PopulatedCell(x, 1);
			field.setCell(cell);
		}
		for (int x=0; x<field.getWidth(); x++) {
			Cell cell = new EmptyCell(x, 2);
			field.setCell(cell);
		}
	}

	@Test
	public void testField() {
		assertEquals(4, field.getWidth());
		assertEquals(3, field.getHeight());
	}

	@Test
	public void testRandomSetup() {
		Field field = new Field(3, 3);
		field.randomSetup();

		assertEquals(9, field.getAllCell().length);
	}

	@Test
	public void testGetCell() {
		Cell cell = field.getCell(1, 2);
		assertEquals(false, cell.isPopulated());
	}

	@Test
	public void testGetNextGeneration() {
		Field generation2 = field.getNextGeneration();
		String gen2_row0 = generation2.getRowString(0);

		assertEquals("■■■■", gen2_row0);

		Field generation3 = generation2.getNextGeneration();
		String gen3_row0 = generation3.getRowString(0);

		assertEquals("□□□□", gen3_row0);
	}

	@Test
	public void testGetNeighbors() {
		Cell center = field.getCell(0, 0);
		Neighbors neighbors = field.getNeighbors(center);

		assertEquals(8, neighbors.size());

		//   0 degree means right
		assertEquals(false, neighbors.get(0).isPopulated());

		//  45 degree means up, right
		assertEquals(false, neighbors.get(1).isPopulated());

		//  90 degree means up
		assertEquals(false, neighbors.get(2).isPopulated());

		// 135 degree means up, left
		assertEquals(false, neighbors.get(3).isPopulated());

		// 180 degree means left
		assertEquals(false, neighbors.get(4).isPopulated());

		// 225 degree means down, left
		assertEquals(true, neighbors.get(5).isPopulated());

		// 270 degree means down
		assertEquals(true, neighbors.get(6).isPopulated());

		// 315 degree means down right
		assertEquals(true, neighbors.get(7).isPopulated());
	}

	@Test
	public void testLoop() {
		assertEquals(3, field.loop(-1, field.getWidth()));
		assertEquals(0, field.loop( 0, field.getWidth()));
		assertEquals(3, field.loop( 3, field.getWidth()));
		assertEquals(0, field.loop( 4, field.getWidth()));

		assertEquals(2, field.loop(-1, field.getHeight()));
		assertEquals(0, field.loop( 0, field.getHeight()));
		assertEquals(2, field.loop( 2, field.getHeight()));
		assertEquals(0, field.loop( 3, field.getHeight()));
	}

	@Test
	public void testGetRow() {
		String row = field.getRowString(0);
		assertEquals("□□□□", row);
	}

}
