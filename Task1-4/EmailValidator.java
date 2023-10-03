import java.util.Scanner;

public class EmailValidator {

    public static boolean validateEmail(final String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');

        if (atIndex <= 0 || dotIndex <= atIndex || dotIndex == email.length() - 1) {
            return false;
        }

        // Перевірка на наявність спеціальних символів
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '@' && c != '.' && c != '_') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть електронну адресу: ");
        String inputEmail = scanner.nextLine();

        if (validateEmail(inputEmail)) {
            System.out.println("Введена адреса є валідною.");
        } else {
            System.out.println("Введена адреса не є валідною.");
        }

        // Закриваємо Scanner після використання
        scanner.close();
    }
}

