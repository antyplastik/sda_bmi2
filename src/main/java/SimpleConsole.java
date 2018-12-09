import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleConsole {

    private Scanner scanner;

    public SimpleConsole() {
        scanner = new Scanner(System.in);
    }

    public double getDoubleValue(String message) {
        double value;
        String tmp;
        System.out.print(message + "\n>> ");
        do {
            tmp = scanner.nextLine();
            if (isDigit(tmp)) {
                value = Double.parseDouble(tmp);
                break;
            } else
                print("Try again");
        } while (true);

        return value;
    }

    public double getAbsolute(double value) {
        return Math.abs(value);
    }

    public void print(String message) {
        System.out.println(">>" + message);
    }

    public void formattedPrint(String message, Object... args) {
        System.out.format(message, args);
    }

    private static boolean isDigit(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}