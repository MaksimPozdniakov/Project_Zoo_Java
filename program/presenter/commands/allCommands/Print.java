package program.presenter.commands.allCommands;

import program.presenter.commands.Command;
import program.view.ConsoleUi;

public class Print extends Command {
    public Print(ConsoleUi console) {
        super(console);
    }

    @Override
    public String description() {
        return "Показать всех животных";
    }

    @Override
    public void execute() {
        getConsole().print();
    }
}
