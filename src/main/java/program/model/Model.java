package program.model;

import program.model.animals.mainClass.AnimalClass;
import program.model.readandwrite.ReadClass;
import program.model.readandwrite.WriteClass;

import java.util.ArrayList;

public class Model {

    protected ArrayList<AnimalClass> animals = new ArrayList<>();
    protected AnimalCounter counter = new AnimalCounter();

    public void readDatabase(){
        animals = ReadClass.readFromJson("C:\\Users\\PMPav\\OneDrive\\Рабочий стол\\" +
                "Second block of study\\Projects\\Project_Zoo_Java\\src\\main\\java\\program\\" +
                "database\\Database.json");
    }

    public void writeDatabase(){
        WriteClass.writeToJson(animals, "C:\\Users\\PMPav\\OneDrive\\Рабочий стол\\" +
                "Second block of study\\Projects\\Project_Zoo_Java\\src\\main\\java\\program\\" +
                "database\\Database.json");
    }

    public void addNewAnimal(AnimalClass animal) {
        animals.add(animal);
        counter.add();
    }

    public void closeCounter(){
        try {
            counter.close(); // Закрываем счетчик при завершении работы
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void print(){
        for (AnimalClass item: animals) {
            System.out.printf("%s - %s \n", item.getClass().getSimpleName(), item);
        }
    }



}
