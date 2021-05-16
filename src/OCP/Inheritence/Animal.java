package OCP.Inheritence;

public class Animal {
    public Integer legs = 8;
    private String name = "I am Animal";
    public static String MY_TYPE = "Animal";

    public void getLegs(){
        System.out.println(legs);
    }

    public void walk(){
        System.out.println("walk");
    }

    public void test(){
        walk();
        sayHi();
    }

    private void dance(){
        System.out.println("dance");
    }

    public static void sayHi(){
        System.out.println("hi");
    }
}

