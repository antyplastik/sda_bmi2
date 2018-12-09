package analyzer;
import bmi.*;

import java.util.ArrayList;
import java.util.List;


public class BMIanalyzer implements Analyzer <String> {

    private String bmiAnalyzeResult = "";
    private double bmiValue;
    private Gender gender;
    private List<Object> bmiAnalyzeOptions = new ArrayList<>();

    public BMIanalyzer(double bmi, Gender gender) {
        this.bmiValue = bmi;
        this.gender = gender;
        generateList();
        if (bmiValue != 0 && gender != null)
            analyze();
    }

    public BMIanalyzer(BodyMassIndex bmi, Gender gender) {
        this.bmiValue = bmi.calculate();
        this.gender = gender;
        generateList();
//        if (bmiValue != 0 && gender != null)
        analyze();
    }

    private void generateList() {
        List<Object> tmp = new ArrayList<>();
//        Object (double min, double max, bmi.Gender gender, String interprete)
        tmp.add(new BMIlimit(0, 15, Gender.MALE, "very severely underweight"));
        tmp.add(new BMIlimit(15, 16, Gender.MALE, "severely underweight"));
        tmp.add(new BMIlimit(16, 18.5, Gender.MALE, "underweight"));
        tmp.add(new BMIlimit(18.5, 25, Gender.MALE, "normal (healthy weight)"));
        tmp.add(new BMIlimit(25, 30, Gender.MALE, "overweight"));
        tmp.add(new BMIlimit(30, 35, Gender.MALE, "obese Class I (Moderately obese)"));
        tmp.add(new BMIlimit(35, 40, Gender.MALE, "obese Class II (Severely obese)"));
        tmp.add(new BMIlimit(40, 45, Gender.MALE, "obese Class III (Very severely obese)"));
        tmp.add(new BMIlimit(45, 50, Gender.MALE, "obese Class IV (Morbidly Obese)"));
        tmp.add(new BMIlimit(50, 60, Gender.MALE, "obese Class V (Super Obese)"));
        tmp.add(new BMIlimit(60, 200, Gender.MALE, "obese Class II (Severely obese)"));

        bmiAnalyzeOptions = tmp;

    }

    @Override
    public String analyze() {
        BMIlimit bmIlimit;
        int arrLen = bmiAnalyzeOptions.size();
        double min;
        double max;

        for (int i = 0; i < arrLen; i++) {
            bmIlimit = (BMIlimit) bmiAnalyzeOptions.get(i);
            min = bmIlimit.getMin();
            max = bmIlimit.getMax();
            if ((min <= bmiValue) && (bmiValue < max)) {
                this.bmiAnalyzeResult = bmIlimit.getInterpret();
                return bmiAnalyzeResult;
            }
        }
        return bmiAnalyzeResult;
    }

    public String getAnalyzeResult() {
        return bmiAnalyzeResult;
    }

    public double getBmiValue() {
        return bmiValue;
    }
}

