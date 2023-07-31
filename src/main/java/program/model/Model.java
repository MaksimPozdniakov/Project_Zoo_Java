package program.model;

import program.model.animals.mainClass.AnimalClass;
import program.model.readandwrite.ReadClass;
import program.model.readandwrite.WriteClass;
import java.util.ArrayList;
import java.util.Arrays;

public class Model {

    protected ArrayList<AnimalClass> animals = new ArrayList<>();
    protected AnimalCounter counter = new AnimalCounter();

    public ArrayList<AnimalClass> readDatabase(){
        ArrayList<AnimalClass> loadedAnimals = ReadClass.readFromJson("C:\\Users\\PMPav\\OneDrive\\Рабочий стол\\" +
                "Second block of study\\Projects\\Project_Zoo_Java\\src\\main\\java\\program\\" +
                "database\\Database.json", counter);
        if (loadedAnimals != null) {
            animals = loadedAnimals;
            AnimalFactory.setLastLoadedId(counter.getCount());
        }
        return animals;
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

    public void addNewCommand(int num, ArrayList<String> listCommand){

        String string = "";
        String commands = "";
        String newCommands = "";

        string = animals.get(num - 1).toString();
        String[] arr = string.split(";");
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(arr));

        commands = arrayList.get(5).replace("[", "").replace("]", "");
        String[] arr2 = commands.split(";");
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList(arr2));

        // Получаем новый список команд
        arrayList2.addAll(listCommand);

        newCommands = arrayList2.toString();

        // Меняем изначальный ArrayList на новый
        arrayList.set(5,newCommands);

        // Меняем базу
        animals.get(num-1).setCommands(arrayList2);
    }

    public void print(){
        for (AnimalClass item: animals) {
            System.out.printf("%s \n", item);
        }
    }



}
