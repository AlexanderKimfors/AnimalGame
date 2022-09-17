import java.util.Scanner;

public class Console {
    Scanner scanner = new Scanner(System.in);

    public void greetPlayer() {
        System.out.println("Welcome to AnimalGame!");
    }

    public String takePlayerName() {
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        return name;
    }

    public byte takePlayerAge() {
        System.out.println("What is your age?");
        byte age = scanner.nextByte();
        return age;
    }

    public byte takeAnimalAge() {
        System.out.println("What is the age of the animal?");
        byte age = scanner.nextByte();
        scanner.nextLine(); // cleaning
        return age;
    }

    public String takeAnimalName() {
        System.out.println("What is the name of the animal?");
        String name = scanner.nextLine();
        return name;
    }

    public String takeTypeOfAnimal() {
        System.out.println("What type of animal is it?");
        String name = scanner.nextLine();
        return name;
    }

    public String takeBreed() {
        System.out.println("What breed is it?");
        String breed = scanner.nextLine();
        return breed;
    }

    public byte menu() {
        System.out.println("What do you want to do?");
        System.out.println();
        System.out.println("1: Get a new animal");
        System.out.println("2: Feed animal");
        System.out.println("3: Play with animal");
        System.out.println();
        byte choice = scanner.nextByte();
        scanner.nextLine(); // cleaning
        return choice;
    }

    public boolean stopPlaying() {
        System.out.println("Do you want to play again?");
        System.out.println("Enter Y or N");
        String answer = scanner.next();
        return !answer.equals("Y");
    }
}
