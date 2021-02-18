import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {
    private static int numAC=0;
    public static void exec() {
        ArrayList<Solver> solvers = null;
        boolean storeAvailable;
        try {
            solvers = JsonUtil.readSolvers();
            storeAvailable = true;
            System.out.println("File store.json load correctly!");

        } catch (
                FileNotFoundException e) {
            System.err.println("Could not read store elements. File not found error.\nStore option will not be available");
            storeAvailable = false;
        }
        int option;
        do {
            option = Menu.showMain(storeAvailable);
            switch (option) {
                case 1:
                    //Add AC
                    incrementAC();
                    Menu.solveAC(numAC);
                    break;
                case 2:
                    //Show total AC
                    ArrayList<String[]> solversBoughtInfo = new ArrayList<>();
                    for (Solver solver : solvers) {
                        int timesBought = solver.getTimesBought();
                        if (timesBought>0) {
                            solversBoughtInfo.add(new String[]{solver.getName(), String.valueOf(timesBought)});
                        }
                    }
                    Menu.viewState(numAC, solversBoughtInfo);
                    break;
                case 3:
                    //Buy AC
                    if(storeAvailable){
                        ArrayList<String[]> solversInfo = new ArrayList<>();
                        for (Solver solver:solvers){
                            if (solver.getPrice()<=numAC) {
                                String[] solverInfo = {solver.getName(), String.valueOf(solver.getPrice())};
                                solversInfo.add(solverInfo);
                            }
                        }
                        String buyingSolver = Menu.store(solversInfo);
                        if(!buyingSolver.equals("")){
                            boolean solverNotFound = true;
                            for (Solver solver : solvers) {
                                if (solver.getName().equalsIgnoreCase(buyingSolver)) {
                                    solverNotFound = false;
                                    if (solver.getPrice() <= numAC) {
                                        synchronized (Solver.class) {
                                            numAC = numAC - solver.getPrice();
                                        }
                                        solver.bought();
                                        Menu.storeBoughtOK(buyingSolver, numAC);
                                        new Thread(solver).start();
                                    } else {
                                        Menu.displayErr("You don't have enough ACs to buy this solver");
                                    }
                                    break;
                                }
                            }
                            if (solverNotFound) {
                                Menu.displayErr("Please enter a solver from the list.");
                            }
                        }
                    } else {
                        Menu.displayErr("Store not available.");
                    }

                    break;
                case 4:
                    //Exit
                    Menu.exitText(numAC);
                    System.exit(0);
                    break;
            }
            Menu.display("------------------------------------------------");
        } while (true);
    }

    public static void incrementAC(){
        synchronized (Solver.class) {
            numAC++;
        }
    }
}
