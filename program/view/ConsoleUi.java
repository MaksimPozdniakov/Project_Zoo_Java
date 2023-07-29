package program.view;

import program.model.AnimalCounter;
import program.model.AnimalFactory;
import program.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUi {

    Presenter presenter = new Presenter();
    Scanner sc = new Scanner(System.in);

    AnimalCounter counter = new AnimalCounter();

    public void addNewAnimal(){
        System.out.print("Введите тип животного: ");
        String typeAnimal = sc.nextLine();

        System.out.print("Введите пароду животного: ");
        String animalBreed = sc.nextLine();

        System.out.print("Введите имя животного: ");
        String name = sc.nextLine();

        System.out.print("Введите возраст животного: ");
        int age = sc.nextInt();

        presenter.addNewAnimal(AnimalFactory.createAnimal(counter,typeAnimal,animalBreed,name,age));
    }

    public void closeCounter(){
        presenter.closeCounter();
    }

    public void print(){
        presenter.print();
    }

}
