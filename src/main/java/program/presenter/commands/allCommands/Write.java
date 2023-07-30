package program.presenter.commands.allCommands;

import program.presenter.commands.Command;
import program.view.ConsoleUi;

public class Write extends Command {
    public Write(ConsoleUi console) {
        super(console);
    }

    @Override
    public String description() {
        return "Внести изменения в журнал";
    }

    @Override
    public void execute() {
        getConsole().writeDatabase();
    }
}
