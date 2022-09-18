import java.util.ArrayList;
import java.util.List;

public class AnimalOwner {
    private String name;

    private int age;
    private List<Animal> animals;

    public AnimalOwner(String name, int age) {
        this.name = name;
        this.age = age;
        this.animals = new ArrayList<>();
    }

    public void playWithAnimal(Animal animal) {
        if (animalBelongsToOwner(animal))
            animal.play();
        else System.out.println(animal.getName() + " does not belong to this owner, only the owner can play with the animal.");
    }

    public void feedAnimal(Animal animal) {
        if (animalBelongsToOwner(animal))
            animal.eat();
        else System.out.println(animal.getName() + " does not belong to this owner, only the owner can feed with the animal.");
    }

    public void addNewAnimal(String name, byte age, String typeOfAnimal, String breed) {
        switch (typeOfAnimal){
            case "dog":
                animals.add(new Dog(name, age, breed));
                break;
            case "cat":
                animals.add(new Cat(name, age, breed));
        }
    }

    private boolean animalBelongsToOwner(Animal animal) {
        return animals.stream().anyMatch(a -> a == animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
