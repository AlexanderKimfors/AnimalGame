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

    private static byte getMenuChoiceFromPlayer() {
        System.out.println("Enter the number that correspond to the action");
        return console.readNumber((byte)1, (byte)4);
    }

    private static void showMenu() {
        System.out.println("What do you want to do?");
        System.out.println();
        System.out.println("1: Get a new animal");
        System.out.println("2: Feed animal");
        System.out.println("3: Play with animal");
        System.out.println("4: Quite");
        System.out.println();
    }

    private static void greetPlayer() {
        System.out.println("Welcome to AnimalGame!");
    }

    private static void initPlayer() {
        String name = console.askUser("What is your name?");
        String age = console.askUser("What is your age?");
        byte age2 = Byte.parseByte(age);
        player = new AnimalOwner(name, age2);
    }

    private static void action(byte choice) {
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
                keepPlaying = false;
                break;

        }
    }
    private static void playWithAnimal() {
        List<Animal> animals = player.getAnimals();
        System.out.println("Which animal do you want to play with?");
        for (int i = 1; i <= animals.size(); i++)
            System.out.println(i + " " + animals.get(i - 1));
        byte choice = console.readNumber((byte)1, (byte)animals.size());
        player.playWithAnimal(animals.get(choice));
    }

    private static void feedAnimal() {
        List<Animal> animals = player.getAnimals();
        System.out.println("Which animal do you want to feed?");
        for (int i = 1; i <= animals.size(); i++)
            System.out.println(i + " " + animals.get(i - 1));
        byte choice = console.readNumber((byte)1, (byte)animals.size());
        player.feedAnimal(animals.get(choice));
    }

    private static void addNewAnimal() {
        String name = console.askUser("What is the name of the animal?");
        String age = console.askUser("What is the age of the animal?");
        String type = console.askUser("What type of animal is it?");
        String breed = console.askUser("What breed is it?");

        byte age2 = Byte.parseByte(age);
        player.addNewAnimal(name, age2, type, breed);
    }

}