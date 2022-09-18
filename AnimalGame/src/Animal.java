public abstract class Animal {
    private String name;
    private int age;
    private String breed;
    private boolean isHungry;

    public Animal(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;

    }
    public void eat() {
        if (isHungry){
            System.out.println(name + " eats.");
            isHungry = false;
        }
        else
            System.out.println(name + " is not hungry.");
    }
    public abstract void play();
    public int getAge() {
        return age;
    }
    public boolean isHungry() {
        return isHungry;
    }
    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }
    public String getName() {
        return name;
    }
    public String getBreed() {
        return breed;
    }

}
