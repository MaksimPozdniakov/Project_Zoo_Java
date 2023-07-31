package program.presenter.commands.allCommands;

import program.presenter.commands.Command;
import program.view.ConsoleUi;

public class NewCommand extends Command {
    public NewCommand(ConsoleUi console) {
        super(console);
    }

    @Override
    public String description() {
        return "Обучить животное новым командам";
    }

    @Override
    public void execute() {
        getConsole().addNewCommand();
    }
}
