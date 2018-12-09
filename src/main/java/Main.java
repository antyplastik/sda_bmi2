import analyzer.BMIanalyzer;
import bmi.BodyMassIndex;
import bmi.Gender;

public class Main {

    private final static String version = "1.1";

    public static void main(String[] args) {
        SimpleConsole sc = new SimpleConsole();
        BodyMassIndex bmi;

        double weight;
        double growth;

        sc.print("BMI calculator V" + version);

        weight = sc.getAbsolute(sc.getDoubleValue("Set your weight"));

        growth = sc.getAbsolute(sc.getDoubleValue("Set your growth"));

        bmi = new BodyMassIndex(growth, weight);

        BMIanalyzer bmiAnalyzer = new BMIanalyzer(bmi.calculate(), Gender.MALE);

        sc.formattedPrint("Your BMI: %f\nYou have %s", bmiAnalyzer.getBmiValue(), bmiAnalyzer.getAnalyzeResult());

    }

}
