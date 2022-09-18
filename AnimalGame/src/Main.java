import java.util.*;

public class Main {
    static Console console = new Console();
    static AnimalOwner player;
    static boolean keepPlaying = true;
    public static void main(String[] args) {
        greetPlayer();
        initPlayer();
        do {
            showMenu();
            action(getMenuChoiceFromPlayer());
        } while (keepPlaying);
    }
    private static void showMenu() {
        System.out.println("---------------------------");
        System.out.println("============MENU===========");
        System.out.println("1: Get a new animal");
        System.out.println("2: Feed animal");
        System.out.println("3: Play with animal");
        System.out.println("4: Show your animals");
        System.out.println("5: Quite");
        System.out.println("---------------------------");
        System.out.println();
    }
    private static int getMenuChoiceFromPlayer() {
        return console.askUserForNumber("Enter the number that correspond to the action",1, 5);
    }

    private static void greetPlayer() {
        System.out.println("Welcome to AnimalGame!");
    }

    private static void initPlayer() {
        String name = console.askUserForString("What is your name?");
        int age = console.askUserForNumber("What is your age?",0,100);
        player = new AnimalOwner(name, age);
    }

    private static void action(int choice) {
        switch (choice){
            case 1:
                addNewAnimal();
                break;
            case 2:
                feedAnimal();
                break;
            case 3:
                playWithAnimal();
                break;
            case 4:
                showInformation();
                break;
            case 5:
                keepPlaying = false;
                goodByeMessage();
                break;
        }
    }

    private static void showInformation() {
        List<Animal> animals = player.getAnimals();

        System.out.println("Your name is: " + player.getName());
        System.out.println("Your age is: " + player.getAge());
        if(animals.size() == 0) {
            System.out.println("You have no animals. \n");
            console.waitForPlayerToPressKey();
            return;
        }
        if(animals.size() == 1) {
            System.out.println("you have one animal. Here is information about your animal: \n");
        }
        else
            System.out.println("you have " + animals.size() + " animals. Here is information about your animals:");

        animals.forEach(System.out::println);
        console.waitForPlayerToPressKey();
    }

    private static void playWithAnimal() {
        List<Animal> animals = player.getAnimals();

        if(animals.size() <= 0) {
            System.out.println("You don't have any animal to play with.");
            console.waitForPlayerToPressKey();
            return;
        }
        for (int i = 1; i <= animals.size(); i++)
            System.out.println(i + " " + animals.get(i - 1));
        int choice = console.askUserForNumber("Which animal do you want to play with?", 1, animals.size());
        player.playWithAnimal(animals.get(choice - 1));
        console.waitForPlayerToPressKey();
    }

    private static void feedAnimal() {
        List<Animal> animals = player.getAnimals();

        if(animals.size() <= 0) {
            System.out.println("You don't have any animal to feed.");
            console.waitForPlayerToPressKey();
            return;
        }
        for (int i = 1; i <= animals.size(); i++)
            System.out.println(i + " " + animals.get(i - 1));
        int choice = console.askUserForNumber("Which animal do you want to feed?", 1, animals.size());
        player.feedAnimal(animals.get(choice - 1));
        console.waitForPlayerToPressKey();
    }

    public static void goodByeMessage() {
        System.out.println("Have a nice day!");
    }

    private static void addNewAnimal() {
        Set<String> domain = new HashSet<>(Arrays.asList("dog", "cat"));
        String name = console.askUserForString("What is the name of the animal?");
        int age = console.askUserForNumber("What is the age of the animal?", 0, 100);
        String animalType;
        do {
            animalType = console.askUserForString("What type of animal is it?", domain).toLowerCase();
        } while (!validAnimalType(animalType));
        String breed = console.askUserForString("What breed is it?");

        player.addNewAnimal(name, (byte)age, animalType, breed);
    }

    private static boolean validAnimalType(String type) {
        return (type.equals("dog") || type.equals("cat"));
    }
}