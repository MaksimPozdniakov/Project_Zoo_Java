package program.presenter.commands;

import program.presenter.commands.allCommands.Add;
import program.view.ConsoleUi;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    protected List<Command> commandList;

    public MainMenu(ConsoleUi console){
        commandList = new ArrayList<>();
        commandList.add(new Add(console));
    }

    public String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n======== Главное меню ========\n");
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append("\t");
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public int getSize(){
        return commandList.size();
    }

    public void execute(int num){
        Command command = commandList.get(num);
        command.execute();
    }

}
