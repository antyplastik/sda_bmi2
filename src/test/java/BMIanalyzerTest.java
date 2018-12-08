import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(JUnitParamsRunner.class)
public class BMIanalyzerTest {

    BMIanalyzer bmiAnalyzer;
//    BodyMassIndex bmi;

    @Test
    @Parameters(method = "methodToCheckIfPersonHasMalnuration")
    public void testCheckIfPersonHasMalnutrition(Gender gender, double bmi, String expected) {

        bmiAnalyzer = new BMIanalyzer(bmi, gender);
        bmiAnalyzer.analyze();
        assertThat(bmiAnalyzer.getAnalyzeResult(), is(expected));
    }

    private Object[] methodToCheckIfPersonHasMalnuration() {
        return new Object[]{
                new Object[]{Gender.MALE, 21, "normal (healthy weight)"},
                new Object[]{Gender.MALE, 20.99, "normal (healthy weight)"},
                new Object[]{Gender.MALE, 180, "obese Class II (Severely obese)"},
                new Object[]{Gender.MALE, 15, "severely underweight"},
                new Object[]{Gender.MALE, 15.01, "severely underweight"},

//                new Object[]{Gender.FEMALE, 19, "extremaly emaciation"},
//                new Object[]{Gender.FEMALE, 18.99, "emaciation"},
//                new Object[]{Gender.FEMALE, 160, "underweight"},
//                new Object[]{Gender.FEMALE, 13, "minimum correct body weight"},
//                new Object[]{Gender.FEMALE, 12.99, "slim body"},
//                new Object[]{Gender.FEMALE, 12.99, "average body size"},
//                new Object[]{Gender.FEMALE, 12.99, "massive body structure"},
//                new Object[]{Gender.FEMALE, 12.99, "maximum correct body weight"},
//                new Object[]{Gender.FEMALE, 12.99, "overweight limiting efficiency"},
//                new Object[]{Gender.FEMALE, 12.99, "obesity limiting fitness and threatening health"},
        };
    }
}
