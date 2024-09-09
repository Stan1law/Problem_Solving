import java.util.Scanner;

public class Program {

    public static double dollarToPesos(double dollars) {
        double exchangeRate = 58.50;
        return dollars * exchangeRate;
    }

    public static double inch_to_cm(double inches) {
        return inches * 2.54;
    }

    public static double Fahren_to_Cel(double Fahrenheit) {
        return ((Fahrenheit - 32) * 5 / 9);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the amount in dollars: ");
        double amountInDollars = scanner.nextDouble();
        double amountInPesos = dollarToPesos(amountInDollars);
        System.out.printf("%.2f dollars is equal to %.2f pesos.", amountInDollars, amountInPesos);

        System.out.println("Please enter the amount in inches: ");
        double amountInInches = scanner.nextDouble();
        double amountInCm = inch_to_cm(amountInInches);
        System.out.printf("%.2f inches is equal to %.2f cm.", amountInInches, amountInCm);

        System.out.println("Please enter the temperature in Fahrenheit: ");
        double temperatureInFahrenheit = scanner.nextDouble();
        double temperatureInCelsius = Fahren_to_Cel(temperatureInFahrenheit);
        System.out.printf("%.2f degrees Fahrenheit is equal to %.2f degrees Celsius.", temperatureInFahrenheit,
                temperatureInCelsius);

    }

}
