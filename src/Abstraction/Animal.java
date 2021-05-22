package Abstraction;

public abstract class Animal {
    public int legs=8;
    private String species = "any";
    public static String name= "I am an Animal";
    private void mySpecies(){
        System.out.println(species);
    }
    public abstract void run();
    public abstract void eat();
}
