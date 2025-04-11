import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({MultiplierTest.class, DivisorTest.class})
public class TestSuite {
}
