public class BMIanalyzer {

    private String bmiAnalyzeResult = "";
    private String[] bmiAnalyzeOptions = {"extreme malnuration", "malnuration", "minimal correct weight", "correct weight", "maximal correct weight", "overveight", "extreme overweight"};

    public BMIanalyzer() {
    }

    public BMIanalyzer(String[] bmiAnalyzeOptions) {
        this.bmiAnalyzeOptions = bmiAnalyzeOptions;
    }

    public BMIanalyzer(BodyMassIndex bmi, Gender gender){
        double bmiValue = bmi.calcBMI();

    }

    public String getBmiAnalyzeResult() {
        return bmiAnalyzeResult;
    }

    public void setBmiAnalyzeResult(String bmiAnalyzeResult) {
        this.bmiAnalyzeResult = bmiAnalyzeResult;
    }
}