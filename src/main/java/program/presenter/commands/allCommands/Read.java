package program.presenter.commands.allCommands;

import program.presenter.commands.Command;
import program.view.ConsoleUi;

public class Read extends Command {
    public Read(ConsoleUi console) {
        super(console);
    }

    @Override
    public String description() {
        return "Открыть журнал";
    }

    @Override
    public void execute() {
        getConsole().readDatabase();
    }
}
