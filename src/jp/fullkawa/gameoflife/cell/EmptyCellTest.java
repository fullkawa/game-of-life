package jp.fullkawa.gameoflife.cell;
import static org.junit.Assert.*;
import jp.fullkawa.gameoflife.Neighbors;

import org.junit.Test;


public class EmptyCellTest {

	@Test
	public void testEmptyCell() {
		Cell cell = new EmptyCell(2, 1);
		assertEquals(2, cell.getX());
		assertEquals(1, cell.getY());
	}

	@Test
	public void testIsPopulated() {
		Cell cell = new EmptyCell(0, 0);
		assertEquals(false, cell.isPopulated());
	}

	@Test
	public void testGetNextGeneration_case0() {
		Neighbors neighbors = new Neighbors();
		for (int j=0; j<8; j++) {
			neighbors.add(new EmptyCell(0, 0));
		}
		assertEquals(0, neighbors.getPopulatedCount());

		Cell nextCell = (new EmptyCell(0, 0)).getNextGeneration(neighbors);
		assertEquals(false, nextCell.isPopulated());
	}

	@Test
	public void testGetNextGeneration_case2() {
		Neighbors neighbors = new Neighbors();
		for (int i=0; i<2; i++) {
			neighbors.add(new PopulatedCell(0, 0));
		}
		for (int j=0; j<6; j++) {
			neighbors.add(new EmptyCell(0, 0));
		}
		assertEquals(2, neighbors.getPopulatedCount());

		Cell nextCell = (new EmptyCell(0, 0)).getNextGeneration(neighbors);
		assertEquals(false, nextCell.isPopulated());
	}

	@Test
	public void testGetNextGeneration_case3() {
		Neighbors neighbors = new Neighbors();
		for (int i=0; i<3; i++) {
			neighbors.add(new PopulatedCell(0, 0));
		}
		for (int j=0; j<5; j++) {
			neighbors.add(new EmptyCell(0, 0));
		}
		assertEquals(3, neighbors.getPopulatedCount());

		Cell nextCell = (new EmptyCell(0, 0)).getNextGeneration(neighbors);
		assertEquals(true, nextCell.isPopulated());
	}

	@Test
	public void testGetNextGeneration_case4() {
		Neighbors neighbors = new Neighbors();
		for (int i=0; i<4; i++) {
			neighbors.add(new PopulatedCell(0, 0));
		}
		for (int j=0; j<4; j++) {
			neighbors.add(new EmptyCell(0, 0));
		}
		assertEquals(4, neighbors.getPopulatedCount());

		Cell nextCell = (new EmptyCell(0, 0)).getNextGeneration(neighbors);
		assertEquals(false, nextCell.isPopulated());
	}

	@Test
	public void testGetNextGeneration_case8() {
		Neighbors neighbors = new Neighbors();
		for (int i=0; i<8; i++) {
			neighbors.add(new PopulatedCell(0, 0));
		}
		assertEquals(8, neighbors.getPopulatedCount());

		Cell nextCell = (new EmptyCell(0, 0)).getNextGeneration(neighbors);
		assertEquals(false, nextCell.isPopulated());
	}

	@Test
	public void testToString() {
		Cell cell = new EmptyCell(0, 0);
		assertEquals("□", cell.toString());
	}

}
