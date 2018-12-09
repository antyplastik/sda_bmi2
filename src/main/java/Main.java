public class Main {

    private final static String version = "1.1";

    public static void main(String[] args) {
        SimpleConsole sc = new SimpleConsole();
        BodyMassIndex bmi;
        BMIanalyzer bmiAnalyzer;

        double weight;
        double growth;

        sc.print("BMI calculator V" + version);

        weight = sc.getDoublePossitiveValue("Set your weight",DigitSign.POSSITIVE);

        growth = sc.getDoublePossitiveValue("Set your growth",DigitSign.POSSITIVE);

        bmi = new BodyMassIndex(growth, weight);

        bmiAnalyzer = new BMIanalyzer(bmi.calculate(), Gender.MALE);

        sc.formattedPrint("Your BMI: %f\nYou have %s", bmiAnalyzer.getBmiValue(), bmiAnalyzer.getAnalyzeResult());

    }

}
