package program;

import program.view.ConsoleUi;

public class Program {
    public static void main(String[] args) {
        ConsoleUi console = new ConsoleUi();
        try {
            console.start();
        } finally {
            console.closeCounter();
        }

    }
}