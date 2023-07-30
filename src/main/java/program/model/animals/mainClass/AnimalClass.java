package program.model.animals.mainClass;

import java.util.ArrayList;

public class AnimalClass {
    protected int id;
    protected String typeAnimal;
    protected String animalBreed;
    protected String name;
    protected ArrayList<String> commands;
    protected int age;

    protected AnimalClass(
            int id, String typeAnimal, String animalBreed, String name, int age, ArrayList<String> commands){
        this.id = id;
        this.typeAnimal = typeAnimal;
        this.animalBreed = animalBreed;
        this.name = name;
        this.age = age;
        this.commands = commands;
    }

    public String toString() {
        return id + " " + typeAnimal + " " + animalBreed + " " + name + " " + age + " " + commands;
    }

}
