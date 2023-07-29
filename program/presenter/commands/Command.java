package program.presenter.commands;

import program.view.ConsoleUi;

public abstract class Command {

    protected ConsoleUi console;

    public Command(ConsoleUi console){
        this.console = console;
    }

    public abstract String description();

    public ConsoleUi getConsole(){
        return console;
    }

    public abstract void execute();

}
