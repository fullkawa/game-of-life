import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
	FieldTest.class,
	NeighborsTest.class,
	EmptyCellTest.class,
	PopulatedCellTest.class,
	PositionTest.class
})
public class AllTests {

}
