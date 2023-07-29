package program.view;

import program.model.AnimalCounter;
import program.model.AnimalFactory;
import program.presenter.Presenter;
import program.presenter.commands.MainMenu;
import java.util.Scanner;

public class ConsoleUi {

    protected Presenter presenter = new Presenter();
    protected Scanner sc = new Scanner(System.in);
    protected AnimalCounter counter = new AnimalCounter();
    protected MainMenu menu;
    private boolean workBase = true;



    public void start(){
        menu = new MainMenu(this);
        do{
            printMenu();
            System.out.print("Выберите пункт меню: ");
            int choice = sc.nextInt();
            if (choice != 1) {
                menu.execute(choice - 1);
            } else {
                System.out.printf("Введите число от 1 до %d", menu.getSize());
            }
        } while (workBase);
    }

    public void printMenu(){
        System.out.println(menu.printMenu());
    }

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
