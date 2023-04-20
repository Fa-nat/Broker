package app;

import app.controllers.AppController;
import app.utils.Constants;

import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runOption(getOption());
    }

    private static int getOption() {
        System.out.println("""
                Choose an option:
                1 - Get Broker A bonus.
                2 - Get Broker B bonus.
                """);
        return scanner.nextInt();
    }

    private static void runOption(int option) {
        switch (option) {
            case 1 -> {
                AppController controller = new AppController();
                controller.getBonusA();
            }
            case 2 -> {
                AppController controller = new AppController();
                controller.getBonusB(Constants.BROKER_B_NAME);
            }
            default -> System.out.println("No such option :(");
        }
    }
}