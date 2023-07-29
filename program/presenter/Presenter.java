package program.presenter;

import program.model.Model;
import program.model.animals.mainClass.AnimalClass;

public class Presenter {

    Model model = new Model();

    public void addNewAnimal(AnimalClass animal){
        model.addNewAnimal(animal);
    }

    public void print(){
        model.print();
    }

    public void closeCounter(){
        model.closeCounter();
    }

}
