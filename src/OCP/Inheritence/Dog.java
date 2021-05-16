package OCP.Inheritence;

public class Dog extends Animal{
    public Integer legs = 4;
    private String name = "I am Dog";
    public static String MY_TYPE = "Dog";


    @Override
    public void getLegs(){
        System.out.println(legs);
    }

    @Override
    public void walk(){
        System.out.println("dog walk");
    }

    // @Override private methods cannot be overridden
    private void dance(){
        System.out.println("dog dance");
    }

    // @Override static methods cannot be overridden
    public static void sayHi(){
        System.out.println("dog hi");
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        Animal a = new Dog();

        System.out.println(a.legs);
        System.out.println(Animal.MY_TYPE);

        System.out.println();

        System.out.println(d.legs);
        System.out.println(Dog.MY_TYPE);

        System.out.println();

        a.walk();
        Animal.sayHi();
        a.test();
        a.getLegs();

        System.out.println();

        d.walk();
        d.dance();
        d.test();
        Dog.sayHi();
        d.getLegs();
    }
}
