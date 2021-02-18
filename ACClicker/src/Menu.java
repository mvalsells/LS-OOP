import java.util.Scanner;

public class Menu {
    public static int showMain(boolean storeAvailable){
        boolean intOk = false;
        int option=0;
        do {
            String optionStr = text(storeAvailable);
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

    private static String text(boolean storeAvailable){
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
        System.out.println(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void display(String text){
        System.out.println(text);
    }
}
