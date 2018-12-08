public class Main {

    private final static String version = "1.0";

    public static void main(String[] args) {
        SimpleConsole sc = new SimpleConsole();
        BodyMassIndex bmi;
        BMIanalyzer bmiAnalyzer;

        sc.print("BMI calculator V" + version);
        double weight = sc.getDoubleValue("Set your weight");
        double growth = sc.getDoubleValue("Set your growth");
        bmi = new BodyMassIndex(growth, weight);

        bmiAnalyzer = new BMIanalyzer(bmi.calculate(), Gender.MALE);

//        System.out.format("Your BMI: %f\nYou have %s",bmiAnalyzer.getBmiValue(), bmiAnalyzer.getAnalyzeResult());
        sc.formattedPrint("Your BMI: %f\nYou have %s",bmiAnalyzer.getBmiValue(), bmiAnalyzer.getAnalyzeResult());

    }

}
