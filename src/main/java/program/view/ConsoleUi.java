package program.view;

import program.model.AnimalCounter;
import program.model.AnimalFactory;
import program.model.animals.mainClass.AnimalClass;
import program.presenter.Presenter;
import program.presenter.commands.MainMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUi {

    protected Presenter presenter = new Presenter();
    protected Scanner sc = new Scanner(System.in);
    protected AnimalCounter counter;
    protected MainMenu menu;
    private boolean workBase;

    public void start(){
        counter = new AnimalCounter(); // Создаем новый объект AnimalCounter перед началом цикла
        menu = new MainMenu(this);
        do{
            printMenu();
            System.out.print("Выберите пункт меню: ");
            int choice = sc.nextInt();
            if (choice >= 1 && choice <= menu.getSize()) {
                menu.execute(choice - 1);
            } else {
                System.out.printf("Введите число от 1 до %d", menu.getSize());
            }
            sc.nextLine();
        } while (workBase);

    }

    public void printMenu(){
        System.out.println(menu.printMenu());
    }

    public void readDatabase(){
        ArrayList<AnimalClass> animals = presenter.readDatabase();
        if (animals.isEmpty()){
            System.out.println("\tЖурнал пуст");
        }
        start();
    }

    public void writeDatabase(){
        presenter.writeDatabase();
        start();
    }

    public void addNewAnimal(){
        System.out.print("Введите тип животного: ");
        String typeAnimal = sc.next();

        System.out.print("Введите пароду животного: ");
        String animalBreed = sc.next();

        System.out.print("Введите имя животного: ");
        String name = sc.next();

        System.out.print("Введите возраст животного: ");
        int age = sc.nextInt();

        System.out.println("Каким командам обучен?");
        System.out.println("После внесения всех комманд напишите 'end' или 'все' и нажмите 'Enter'");
        ArrayList<String> commands = new ArrayList<>();
        while (true){
            String command = sc.next();
            if (command.equals("end") || command.equals("все")){
                break;
            }
            commands.add(command);
        }

        presenter.addNewAnimal(AnimalFactory.createAnimal(counter,typeAnimal,animalBreed,name,age,commands));
        start();
    }

    public void addNewCommand(){
        presenter.print();
        System.out.print("Какое животное прошло дресировку? ");
        int num = sc.nextInt();

        System.out.println("Какими командами был обучен?");
        System.out.println("После внесения всех изменений напишите 'end' или 'все' и нажмите 'Enter'");
        ArrayList<String> listCommand = new ArrayList<>();
        while (true){
            String newCommand = sc.next();
            if (newCommand.equals("end") || newCommand.equals("все")){
                break;
            }
            listCommand.add(newCommand);
        }

        presenter.addNewCommand(num,listCommand);
        start();
    }

    public void closeCounter(){
        presenter.closeCounter();
    }

    public void print(){
        presenter.print();
        start();
    }

    public void end(){
        System.exit(0);
    }

}
