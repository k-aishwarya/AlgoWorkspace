package InterviewSet.DesignPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Immutable {

}


//Rule 5
final class Animal {

    //2 Rule
    private final String species;
    private final int age;
    private final List<String> favouriteFoods;

    //3 Rule
    // There are no setters

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    //4 Rule
    public List<String> getFavouriteFoods() {
        return Collections.unmodifiableList(this.favouriteFoods);
    }

    //4 Rule
    public String getFavouriteFoods(int index) {
        return favouriteFoods.get(index);
    }


    //1 Rule
    public Animal(String species, int age, List<String> favouriteFoods)
    {
        this.species = species;
        this.age = age;
        if(favouriteFoods == null) throw new RuntimeException("favouriteFoods is required!");
        this.favouriteFoods  = new ArrayList<String>(favouriteFoods);
        //Note -> it is not "this.favouriteFoods = favouriteFoods" As the caller will have the reference to the mutable object of the class.
    }
}
