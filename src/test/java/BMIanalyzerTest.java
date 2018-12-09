import analyzer.BMIanalyzer;
import bmi.Gender;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(JUnitParamsRunner.class)
public class BMIanalyzerTest {

    BMIanalyzer bmiAnalyzer;

    @Test
    @Parameters(method = "methodToCheckBmiAnalyze")
    public void testCheckBmiCalculator(double bmi, String expected) {

        bmiAnalyzer = new BMIanalyzer(bmi, Gender.MALE);
        bmiAnalyzer.analyze();
        assertThat(bmiAnalyzer.getAnalyzeResult(), is(expected));
    }

    private Object[] methodToCheckBmiAnalyze() {
        return new Object[]{
                new Object[]{21, "normal (healthy weight)"},
                new Object[]{20.99, "normal (healthy weight)"},
                new Object[]{180, "obese Class II (Severely obese)"},
                new Object[]{15, "severely underweight"},
                new Object[]{15.01, "severely underweight"},

        };
    }
}
