import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleConsole {

    private Scanner scanner;

    public SimpleConsole() {
        scanner = new Scanner(System.in);
    }

    public double getDoublePossitiveValue(String message, DigitSign digit) {
        double value = 0;
        String tmp = "";
        System.out.print(message + "\n>> ");
        do {
            tmp = scanner.nextLine();
            if (isDigit(tmp)) {
                value = Double.parseDouble(tmp);
                if (digit.equals(DigitSign.POSSITIVE))
                    value = Math.abs(value);
                break;
            } else
                print("Try again");
        } while (true);

        return value;
    }

    public void print(String message) {
        System.out.println(">>" + message);
    }

    public void formattedPrint(String message, Object... args) {
        System.out.format(message, args);
    }

    public static boolean isDigit(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}

enum DigitSign{
     ALL, POSSITIVE, NEGATIVE
}