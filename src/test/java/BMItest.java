import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(JUnitParamsRunner.class)
public class BMItest {

    BodyMassIndex bmi;

    @Test
    @Parameters(method = "testMethodForCheckTheWeightValue")
    public void checkIfTheWeightIsCorrectlyEntered(double growth, double weight, double expected) {
        bmi = new BodyMassIndex(growth, weight);
        assertEquals(expected, bmi.calcBMI(), 0.01);
    }

    private Object[] testMethodForCheckTheWeightValue() {
        return new Object[]{
                new Object[]{168, 68 ,68}
        };
    }

    @Test
    @Parameters({"6.8", "680", "301"})
    public void checkThrowIfWeightIsIncorrect(double weight) {
        try {
            male = new Person(Gender.MALE, 29, 1.73, weight);
            fail();
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }

    private String testMethodForCheckTheWeightThrow() {
        return "1.73, 173, 1730";
    }

    @Test
    @Parameters(method = "testMethodForCheckTheGrowthValue")
    public void checkIfTheGrowthIsCorrectlyEntered(double growth, double expected) {
        male = new Person(Gender.MALE, 29, growth, 68);
//        male.setBmi(new BodyMassIndex(growth, 68));
        assertEquals(expected, male.getBmi().getGrowth(), 0.01);
    }

    private Object[] testMethodForCheckTheGrowthValue() {
        return new Object[]{
                new Object[]{1.73, 1.73}
        };
    }

    @Test
    @Parameters({"0.1", "4.45",})
    public void checkThrowIfGrowthIsIncorrect(double growth) {
        try {
            male = new Person(Gender.MALE, 29, growth, 68);
            fail();
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }

    private String testMethodForCheckTheGrowthThrow() {
        return "0.1,4,45,100";
    }

    @Test
    @Parameters(method = "testMethodForBMIcalculator")
    public void calcBMIforCustomHeightAndWeight(double growth, double weight, double expected) {
        male = new Person(Gender.MALE, 29, growth, weight);
//        male.setBmi(new BodyMassIndex(growth, weight));
        assertEquals(expected, male.getBmi().calcBMI(), 0.01);
    }

    private Object[] testMethodForBMIcalculator() {
        return new Object[]{
                new Object[]{1.73, 68, 22.72}
        };
    }
}
