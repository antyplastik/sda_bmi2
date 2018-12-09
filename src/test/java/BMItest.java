import bmi.BodyMassIndex;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.InputMismatchException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(JUnitParamsRunner.class)
public class BMItest {

    BodyMassIndex bmi;

    @Rule
        public final ExpectedException exception = ExpectedException.none();
    @Test
    @Parameters(method = "throwTestMethod")
    public void checkThrowIfGrowthOrWeightIsIncorrect(double growth, double weight, String expectedMessage) {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(expectedMessage);
        bmi = new BodyMassIndex(growth, weight);
//        try {
//            bmi = new BodyMassIndex(growth, weight);
//            fail();
//        } catch (IllegalArgumentException e) {
//            e.getMessage();
//        }
    }

    private Object[] throwTestMethod() {
        return new Object[]{
                new Object[]{0,100,"Wrong growth value"},
                new Object[]{168,0, "Wrong wieght value"}
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
                new Object[]{2, 2, 0.5},
        };
    }
}
