package program.presenter.commands.allCommands;

import program.presenter.commands.Command;
import program.view.ConsoleUi;

public class Add extends Command {
    public Add(ConsoleUi console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавить новое животное";
    }

    @Override
    public void execute() {
        getConsole().addNewAnimal();
    }
}
