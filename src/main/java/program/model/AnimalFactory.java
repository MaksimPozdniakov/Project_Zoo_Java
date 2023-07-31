package program.model;

import program.model.animals.PackAnimals;
import program.model.animals.Pets;
import program.model.animals.mainClass.AnimalClass;
import java.util.ArrayList;

public class AnimalFactory {

    private static int counterId = 1;
    private static int lastLoadedId = 0;

    public static AnimalClass createAnimal(
            AnimalCounter counter, String typeAnimal, String animalBreed,
            String name, int age, ArrayList<String> commands
    ){
        if (typeAnimal == null || typeAnimal.isEmpty()){
            throw new IllegalArgumentException("Тип животного не может быть пустым.");
        }

        int id;
        if ("Pets".equals(typeAnimal) || "PackAnimals".equals(typeAnimal)){
            id = lastLoadedId + counterId++;
            counter.add();
        } else {
            id = -1;
        }

        if ("Pets".equals(typeAnimal)){
            return new Pets(id, typeAnimal, animalBreed, name, age, commands);
        } else if ("PackAnimals".equals(typeAnimal)){
            return new PackAnimals(id, typeAnimal, animalBreed, name, age, commands);
        }

        return null;
    }

    public static void setLastLoadedId(int id) {
        lastLoadedId = id;
    }

}
