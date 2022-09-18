public class Dog extends Animal{

    public Dog(String name, int age, String breed) {
        super(name, age, breed);
    }

    @Override
    public void play() {
        if(isHungry())
            System.out.println(getName() + " is to hungry to play.");
        else {
            System.out.println(getName() + " chasing the ball and barking.");
            setHungry(true);
        }
    }

    @Override
    public String toString() {
        String intro = getName() + ": is a " + getAge() + " years old " + getBreed() + " dog,";
        if (isHungry())
            return intro += " and is very hungry.";
        else
            return intro += " and wants to play with you.";

    }
}
