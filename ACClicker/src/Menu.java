import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    public static int showMain(boolean storeAvailable){
        boolean intOk = false;
        int option=0;
        do {
            String optionStr = mainMenuText(storeAvailable);
            try{
                option=Integer.parseInt(optionStr);
                if (option >= 1 && option <= 4) {
                    intOk = true;
                } else {
                    System.err.println("Input introduced not corresponding to the menu");
                }
            } catch (NumberFormatException e){
                System.err.println("Input introduced not corresponding to the menu");
            }
        } while (!intOk);

        return option;
    }

    private static String mainMenuText(boolean storeAvailable){
        StringBuilder sb = new StringBuilder();
        sb.append("AC Clicker\n");
        sb.append("\t1) Resolve AC\t\uD83D\uDCDD\n");
        sb.append("\t2) View state\t\uD83D\uDDC2\n");
        sb.append("\t3) Buy solver\t\uD83D\uDED2");
        if (!storeAvailable){
            sb.append(" (not available)");
        }
        sb.append("\n\t4) Exit\t\t\t\uD83D\uDC4B\n");
        sb.append("Choose an option: ");
        System.out.print(sb.toString());
        return scanner.nextLine();
    }

    public static void display(String text){
        System.out.println(text);
    }
    public static void displayErr(String text){
        System.err.println(text);
    }

    public static void exitText(int numAC){
        StringBuilder sb = new StringBuilder();
        sb.append("Game Over! Final points: ");
        sb.append(numAC);
        sb.append(" ACs.");
        System.out.println(sb.toString());
    }

    public static String store(ArrayList<String[]> solversInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("This are the available solvers:\n");
        for (String[] solverInfo : solversInfo){
            sb.append("\t");
            sb.append(solverInfo[0]);
            sb.append(": ");
            sb.append(solverInfo[1]);
            sb.append(" ACs.\n");
        }
        sb.append("Enter the name of the solver you want to buy or press Enter to exit: ");
        System.out.print(sb.toString());
        return scanner.nextLine();
    }

    public static void viewState(int numAC) {
        StringBuilder sb = new StringBuilder();
        sb.append("Until now ");
        sb.append(numAC);
        sb.append(" ACs have been solved. Good work!");
        System.out.println(sb.toString());
        //TODO Show bought items
    }

    public static void solveAC(int numAC) {
        StringBuilder sb = new StringBuilder();
        sb.append("AC ");
        sb.append(numAC);
        sb.append(" solved!");
        System.out.println(sb.toString());
    }

    public static void storeBoughtOK(String buyingSolver, int numAC) {
        StringBuilder sb = new StringBuilder();
        sb.append("You have bought the \"");
        sb.append(buyingSolver);
        sb.append("\". You have ");
        sb.append(numAC);
        sb.append("ACs left");
        System.out.println(sb.toString());
    }
}
