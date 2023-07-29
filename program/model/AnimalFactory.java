package program.model;

import program.model.animals.PackAnimals;
import program.model.animals.Pets;
import program.model.animals.mainClass.AnimalClass;

public class AnimalFactory {
    private static int counterId = 1;

    public static AnimalClass createAnimal(
            AnimalCounter counter, String typeAnimal, String animalBreed, String name, int age
    ){
        if (typeAnimal == null || typeAnimal.isEmpty()){
            throw new IllegalArgumentException("Тип животного не может быть пустым.");
        }

        int id;
        if ("Pets".equals(typeAnimal) || "PackAnimal".equals(typeAnimal)){
            id = counterId++;
            counter.add();
        } else {
            id = -1;
        }

        if ("Pets".equals(typeAnimal)){
            return new Pets(id, typeAnimal, animalBreed, name, age);
        } else if ("PackAnimals".equals(typeAnimal)){
            return new PackAnimals(id, typeAnimal, animalBreed, name, age);
        }

        return null;
    }

}
