abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void makeSound();

    public void sleep() {
        System.out.println("Спит");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Гав");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Мяу");
    }
}

public class task1 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[4];
        animals[0] = new Dog("Бобик");
        animals[1] = new Cat("Мурка");
        animals[2] = new Dog("Шарик");
        animals[3] = new Cat("Барсик");

        for (Animal a : animals) {
            System.out.println("Имя: " + a.getName());
            a.makeSound();
            a.sleep();
            System.out.println();
        }
    }
}