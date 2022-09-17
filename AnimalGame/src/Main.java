public class Main {
    static Console console = new Console();
    static AnimalOwner player;
    public static void main(String[] args) {

        console.greetPlayer();

        initPlayer();

        while(true){
            byte choice = console.menu();
            action(choice);
            player.getAnimals().stream().forEach(System.out::println);
            if(console.stopPlaying()) break;
        }

    }

    private static void initPlayer() {
        String name = console.takePlayerName();
        byte age = console.takePlayerAge();
        player = new AnimalOwner(name, age);
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

        }
    }

    private static void playWithAnimal() {
        System.out.println("Which animal do you want to play with?");
        for(int i = 1; i <= player.getAnimals().size(); i++) {
            System.out.println(i + " " + player.getAnimals().get(i - 1));
        }
        byte choice = console.scanner.nextByte();
        player.playWithAnimal(player.getAnimals().get(choice - 1));
    }

    private static void addNewAnimal() {
        String name = console.takeAnimalName();
        byte age = console.takeAnimalAge();
        String type = console.takeTypeOfAnimal();
        String breed = console.takeBreed();
        player.addNewAnimal(name, age, type, breed);
    }

    // Denna funktionen ska förbättras. Console klassen kan göra mycket av detta.
    private static void feedAnimal() {
        System.out.println("Which animal do you want to feed?");
        for(int i = 1; i <= player.getAnimals().size(); i++) {
            System.out.println(i + " " + player.getAnimals().get(i - 1));
        }
        byte choice = console.scanner.nextByte();
        player.feedAnimal(player.getAnimals().get(choice - 1));
    }

}