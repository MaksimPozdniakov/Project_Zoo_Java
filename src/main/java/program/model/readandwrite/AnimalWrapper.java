package program.model.readandwrite;

import program.model.animals.mainClass.AnimalClass;
import java.util.ArrayList;

public class AnimalWrapper {
    private ArrayList<AnimalClass> animals;

    public AnimalWrapper(ArrayList<AnimalClass> animals){
        this.animals = animals;
    }

    public ArrayList<AnimalClass> getAnimals(){
        return animals;
    }

}
