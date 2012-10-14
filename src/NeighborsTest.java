import static org.junit.Assert.*;

import org.junit.Test;


public class NeighborsTest {

	@Test
	public void testGetPopulatedCount_case0() {
		Neighbors neighbors = new Neighbors();
		neighbors.add(new EmptyCell(0, 0));
		neighbors.add(new EmptyCell(0, 1));
		neighbors.add(new EmptyCell(1, 0));
		neighbors.add(new EmptyCell(1, 1));

		assertEquals(0, neighbors.getPopulatedCount());
	}

	@Test
	public void testGetPopulatedCount_case2() {
		Neighbors neighbors = new Neighbors();
		neighbors.add(new EmptyCell(0, 0));
		neighbors.add(new PopulatedCell(0, 1));
		neighbors.add(new EmptyCell(1, 0));
		neighbors.add(new PopulatedCell(1, 1));

		assertEquals(2, neighbors.getPopulatedCount());
	}

}
