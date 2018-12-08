public class BMIlimit {
    private double min;
    private double max;
    private Gender gender;
    private String interpret;

    public BMIlimit(double min, double max, Gender gender, String interpret) {
        this.min = min;
        this.max = max;
        this.gender = gender;
        this.interpret = interpret;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public Gender getGender() {
        return gender;
    }

    public String getInterpret() {
        return interpret;
    }
}
