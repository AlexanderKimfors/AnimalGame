import java.lang.management.PlatformLoggingMXBean;
import java.util.List;

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
            //player.getAnimals().forEach(System.out::println);
        } while (keepPlaying);
    }

    private static int getMenuChoiceFromPlayer() {
        return console.askUserForNumber("Enter the number that correspond to the action",1, 4);
    }

    private static void showMenu() {
        System.out.println("What do you want to do?");
        System.out.println();
        System.out.println("1: Get a new animal");
        System.out.println("2: Feed animal");
        System.out.println("3: Play with animal");
        System.out.println("4: Show your animals");
        System.out.println("5: Quite");
        System.out.println();
    }

    private static void greetPlayer() {
        System.out.println("Welcome to AnimalGame!");
    }

    private static void initPlayer() {
        String name = console.askUserForString("What is your name?");
        String age = console.askUserForString("What is your age?");
        byte age2 = Byte.parseByte(age);
        player = new AnimalOwner(name, age2);
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
                showPlayersInformation();
                break;
            case 5:
                keepPlaying = false;
                break;
        }
    }

    private static void showPlayersInformation() {
        System.out.println("Your name is: " + player.getName());
        System.out.println("Your age is: " + player.getAge());
        if(player.getAnimals().size() == 0) {
            System.out.println("You have no animals.");
            return;
        }
        if(player.getAnimals().size() == 1) {
            System.out.println("you have one animal. Here is information about your animal: \n");
        }
        else
            System.out.println("you have " + player.getAnimals().size() + " animals. Here is information about your animals:");

        player.getAnimals().forEach(System.out::println);

        System.out.println("\nPress any key to continue to the menu.");
        console.waitForPlayerToPressKey();
    }

    private static void playWithAnimal() {
        List<Animal> animals = player.getAnimals();
        for (int i = 1; i <= animals.size(); i++)
            System.out.println(i + " " + animals.get(i - 1));
        int choice = console.askUserForNumber("Which animal do you want to play with?", 1, animals.size());
        player.playWithAnimal(animals.get(choice));
    }

    private static void feedAnimal() {
        List<Animal> animals = player.getAnimals();
        if(animals.size() <= 0) {
            System.out.println("You don't have any animal to feed.");
            return;
        }
        for (int i = 1; i <= animals.size(); i++)
            System.out.println(i + " " + animals.get(i - 1));
        int choice = console.askUserForNumber("Which animal do you want to feed?", 1, animals.size());
        player.feedAnimal(animals.get(choice));
    }

    private static void addNewAnimal() {
        String name = console.askUserForString("What is the name of the animal?");
        int age = console.askUserForNumber("What is the age of the animal?", 0, 100);
        String animalType;
        do {
            animalType = console.askUserForString("What type of animal is it?").toLowerCase();
        } while (!validAnimalType(animalType));
        String breed = console.askUserForString("What breed is it?");

        player.addNewAnimal(name, (byte)age, animalType, breed);
    }

    private static boolean validAnimalType(String type) {
        return (type.equals("dog") || type.equals("cat"));
    }

}