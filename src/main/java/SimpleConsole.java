import java.util.Scanner;

public class SimpleConsole {

    private Scanner scanner;

    public SimpleConsole() {
        scanner = new Scanner(System.in);
    }

    public double getDoubleValue(String message){
        double value = 0;
        System.out.print(message + "\n>> ");
        value = scanner.nextDouble();
        return value;
    }

    public void print(String message){
        System.out.println(message);
    }

    public void formattedPrint(String message, Object... args){
        System.out.format(message,args);
    }

}
