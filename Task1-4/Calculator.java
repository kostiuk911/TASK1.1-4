import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть першу число:");
        final double num1 = scanner.nextDouble();

        System.out.println("Введіть друге число:");
        final double num2 = scanner.nextDouble();

        System.out.println("Введіть операцію (+, -, *, /):");
        final String operation = scanner.next();

        double result;

        switch (operation) {
            case "+":
                result = Addition.performOperation(num1, num2);
                break;
            case "-":
                result = Subtraction.performOperation(num1, num2);
                break;
            case "*":
                result = Multiplication.performOperation(num1, num2);
                break;
            case "/":
                result = Division.performOperation(num1, num2);
                break;
            default:
                System.out.println("Невірна операція");
                return;
        }

        System.out.println("Результат: " + result);
    }
}

class Addition {
    public static double performOperation(final double num1, final double num2) {
        return num1 + num2;
    }
}

class Subtraction {
    public static double performOperation(final double num1, final double num2) {
        return num1 - num2;
    }
}

class Multiplication {
    public static double performOperation(final double num1, final double num2) {
        return num1 * num2;
    }
}

class Division {
    public static double performOperation(final double num1, final double num2) {
        if (num2 == 0) {
            System.out.println("Ділення на 0 недопустиме");
            System.exit(0);
        }
        return num1 / num2;
    }
}
