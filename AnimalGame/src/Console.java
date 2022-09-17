import java.util.List;
import java.util.Scanner;

public class Console {
    Scanner scanner = new Scanner(System.in);
    public String askUser(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public byte readNumber(byte min, byte max) {
        byte number = scanner.nextByte();
        while (number < min || number > max) {
            System.out.println("The number most be between " + min + " and " + max + ".");
            number = scanner.nextByte();
        }
        return number;
    }

    public byte chooseAnimal(List<Animal> animals, String question) {
        System.out.println(question);
        for (int i = 1; i <= animals.size(); i++)
            System.out.println(i + " " + animals.get(i - 1));
        byte choice = scanner.nextByte();
        return choice;
    }

    public boolean stopPlaying() {
        System.out.println("Do you want to play again?");
        System.out.println("Enter Y or N");
        String answer = scanner.next();
        return !answer.equals("Y");
    }

}
