package Abstraction;

public class Dog extends Animal{

    @Override
    public void run() {
        System.out.println("I am running");
    }

    @Override
    public void eat() {
        System.out.println("I am eating");
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        System.out.println(d.legs);
        System.out.println(d.name);
        d.run();
        d.eat();

    }
}
