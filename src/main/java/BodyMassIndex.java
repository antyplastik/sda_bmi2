import java.util.InputMismatchException;
import java.util.logging.Logger;

import static java.lang.Math.pow;

public class BodyMassIndex implements Calculate {
    //
    private double growth;
    private double weight;
    private double bodyMassIndex;
    private String bmiAnalyzeResult = "";

    public BodyMassIndex(double growth, double weight) {
        Logger logger = null;
        try {
            this.growth = checkGrowth(growth);
        } catch (IllegalArgumentException e) {
            logger.info("[ERROR] Bad argument");
        }
        try {
            this.weight = checkWeight(weight);
        } catch (IllegalArgumentException e) {
            logger.info("[ERROR] Bad argument");
        }
    }

    public double checkGrowth(double growth) {
        if (growth > 10)
            growth = growth / 100;

        if (growth >= 0.1 && growth <= 2.4)
            return growth;
        else
            throw new IllegalArgumentException();
    }

    public double checkWeight(double weight) {
        if (weight >= 0 && weight <= 300)
            return weight;
        else
            throw new IllegalArgumentException();
    }

    @Override
    public double calculate() {
        this.bodyMassIndex = weight / pow(growth, 2);
        return bodyMassIndex;
    }

    @Override
    public String interprer() {
        return null;
    }
}
