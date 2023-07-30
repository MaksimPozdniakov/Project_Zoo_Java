package program.presenter.commands.allCommands;

import program.presenter.commands.Command;
import program.view.ConsoleUi;

public class End extends Command {
    public End(ConsoleUi console) {
        super(console);
    }

    @Override
    public String description() {
        return "Завершить работу программы";
    }

    @Override
    public void execute() {
        getConsole().end();
    }
}
