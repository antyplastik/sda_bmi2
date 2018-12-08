import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(JUnitParamsRunner.class)
public class BMItest {

    BodyMassIndex bmi;

    @Test
    @Parameters(method = "throwTestMethod")
    public void checkThrowIfGrowthOrWeightIsIncorrect(double growth, double weight) {
        try {
            bmi = new BodyMassIndex(growth, weight);
//            male = new Person(Gender.MALE, 29, 1.73, weight);
            fail();
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }

    private Object[] throwTestMethod() {
        return new Object[]{
                new Object[]{0,100},
                new Object[]{168,0}
        };
    }

    @Test
    @Parameters(method = "testMethodForBMIcalculator")
    public void calcBMIforCustomHeightAndWeight(double growth, double weight, double expected) {
        bmi = new BodyMassIndex(growth,weight);
        assertEquals(expected, bmi.calculate(), 0.01);
    }

    private Object[] testMethodForBMIcalculator() {
        return new Object[]{
                new Object[]{1.73, 68, 22.72},
                new Object[]{1.62, 45, 17.147},
        };
    }
}
