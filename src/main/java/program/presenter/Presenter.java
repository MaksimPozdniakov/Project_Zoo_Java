package program.presenter;

import program.model.Model;
import program.model.animals.mainClass.AnimalClass;

import java.util.ArrayList;

public class Presenter {

    Model model = new Model();

    public ArrayList<AnimalClass> readDatabase(){
        return model.readDatabase();
    }

    public void writeDatabase(){
        model.writeDatabase();
    }

    public void addNewAnimal(AnimalClass animal){
        model.addNewAnimal(animal);
    }

    public void addNewCommand(int num, ArrayList<String> listCommand){
        model.addNewCommand(num,listCommand);
    }

    public void print(){
        model.print();
    }

    public void closeCounter(){
        model.closeCounter();
    }

}
