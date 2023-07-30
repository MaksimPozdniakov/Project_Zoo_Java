package program.model.animals;

import program.model.animals.mainClass.AnimalClass;

import java.util.ArrayList;

public class PackAnimals extends AnimalClass {
    public PackAnimals(int id, String typeAnimal, String animalBreed, String name, int age, ArrayList<String> commands) {
        super(id, typeAnimal, animalBreed, name, age, commands);
    }
}
