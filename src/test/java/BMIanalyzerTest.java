import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(JUnitParamsRunner.class)
public class BMIanalyzerTest {

    BMIanalyzer bmiAnalyzer;

    @Before
    public void setUp() {
        bmiAnalyzer = new BMIanalyzer();
    }

    @Test
    @Parameters(method = "methodToCheckIfPersonHasMalnuration")
    public void testCheckIfPersonHasMalnutrition(Gender gender, double bmi, boolean expected) {
        assertThat(bmiAnalyzer.checkIfMalnuration(gender, bmi), is(expected));
    }

    private Object[] methodToCheckIfPersonHasMalnuration() {
        return new Object[]{
                new Object[]{Gender.MALE, 21, false},
                new Object[]{Gender.MALE, 20.99, true},
                new Object[]{Gender.MALE, 180, false},
                new Object[]{Gender.MALE, 15, true},
                new Object[]{Gender.MALE, 15.01, true},

                new Object[]{Gender.FEMALE, 19, false},
                new Object[]{Gender.FEMALE, 18.99, true},
                new Object[]{Gender.FEMALE, 160, false},
                new Object[]{Gender.FEMALE, 13, true},
                new Object[]{Gender.FEMALE, 12.99, true},
        };
    }

    @Test
    @Parameters(method = "methodToCheckIfPersonHasTheCorrectWeight")
    public void testCheckIfPersonHasTheCorrectWeight(Gender gender, double bmi, boolean expected) {
        assertThat(bmiAnalyzer.checkIfCorrectWeight(gender, bmi), is(expected));
    }

    private Object[] methodToCheckIfPersonHasTheCorrectWeight() {
        return new Object[]{
                new Object[]{Gender.MALE, 20.99, false},
                new Object[]{Gender.MALE, 21, true},
                new Object[]{Gender.MALE, 230, false},
                new Object[]{Gender.MALE, 25, true},
                new Object[]{Gender.MALE, 25.01, false},

                new Object[]{Gender.FEMALE, 18.99, false},
                new Object[]{Gender.FEMALE, 19, true},
                new Object[]{Gender.FEMALE, 210, false},
                new Object[]{Gender.FEMALE, 23, true},
                new Object[]{Gender.FEMALE, 23.01, false},
        };
    }

    @Test
    @Parameters(method = "testMethodToCheckIfPersonIsOverweight")
    public void checkIfPersonIsOverweight(Gender gender, double bmi, boolean expected) { // < =========================== Napisac
        assertThat(bmiAnalyzer.checkIfOverweight(gender,bmi),is(expected));
    }

    private Object[] testMethodToCheckIfPersonIsOverweight() {
        return new Object[]{
                new Object[]{Gender.MALE, 25, false},
                new Object[]{Gender.MALE, 25.01, true},
                new Object[]{Gender.MALE, 230, true},
                new Object[]{Gender.MALE, 31, true},
                new Object[]{Gender.MALE, 31.01, true},

                new Object[]{Gender.FEMALE, 23, false},
                new Object[]{Gender.FEMALE, 23.01, true},
                new Object[]{Gender.FEMALE, 210, true},
                new Object[]{Gender.FEMALE, 29, true},
                new Object[]{Gender.FEMALE, 24, true},
        };
    }
}
