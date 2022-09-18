import java.util.Scanner;

public class Console {
    private Scanner scanner = new Scanner(System.in);
    public String askUserForString(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }


    public int askUserForNumber(String question, int min, int max) {
        System.out.println(question);
        String number;
        do {
            number = scanner.nextLine();
            if(isNumeric(number)) {
                if(isBetweenLimits(number, min, max))
                    break;
                else
                    System.out.println("The number most be between " + min + " and " + max + ".");
            }
            else
                System.out.println("Please enter a number.");
        } while(true);
        return Integer.parseInt(number);
    }

    public void waitForPlayerToPressKey() {
        scanner.nextLine();
    }

    private boolean isBetweenLimits(String number, int min, int max) {
        int value = Integer.parseInt(number);
        return value >= min && value <= max;
    }

    private boolean isNumeric(String string) {
        if(string == null || string.equals("")) return false;
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input can not be parsed to integer.");
        }
        return false;
    }


}
