import static org.junit.Assert.*;

import org.junit.Test;


public class PositionTest {

	@Test
	public void testEqualsObject_caseEqual() {
		Position pos1 = new Position(1, 2);
		Position pos2 = new Position(1, 2);

		assertEquals(true, pos1.equals(pos2));
	}

	@Test
	public void testEqualsObject_caseNotEqual() {
		Position pos1 = new Position(1, 2);
		Position pos2 = new Position(2, 1);

		assertEquals(false, pos1.equals(pos2));
	}

}
