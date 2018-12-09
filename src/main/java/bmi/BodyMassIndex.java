package bmi;

import static java.lang.Math.pow;

public class BodyMassIndex implements Calculator<Double> {
    //
    private double growth;
    private double weight;
    private double bodyMassIndex;

    public BodyMassIndex(double growth, double weight) {
//        Logger logger = .getLogger(BodyMassIndex.class);

            this.growth = checkGrowth(growth);
            this.weight = checkWeight(weight);
    }

    public double checkGrowth(double growth) {
        if (growth > 10)
            growth = growth / 100;

        if (growth >= 0.1 && growth <= 2.4)
            return growth;
        else
            throw new IllegalArgumentException("Wrong growth value");
    }

    public double checkWeight(double weight) {
        if (weight > 0 && weight <= 300)
            return weight;
        else
            throw new IllegalArgumentException("Wrong weight value");
    }

    @Override
    public Double calculate() {
        this.bodyMassIndex = weight / pow(growth, 2);
        return bodyMassIndex;
    }
}

