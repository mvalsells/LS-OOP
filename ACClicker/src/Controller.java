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
                    Menu.viewState(numAC);
                    break;
                case 3:
                    //Buy AC
                    if(storeAvailable){
                        ArrayList<String[]> solversInfo = new ArrayList<>();
                        for (Solver solver:solvers){
                            String[] solverInfo = {solver.getName(), String.valueOf(solver.getPrice())};
                            solversInfo.add(solverInfo);
                        }
                        String buyingSolver = Menu.store(solversInfo);
                        if(!buyingSolver.equals("")){
                            boolean solverNotFound = true;
                            for (Solver solver:solvers){
                                if (solver.getName().equalsIgnoreCase(buyingSolver)){
                                    solverNotFound = false;
                                    if(solver.getPrice()<=numAC) {
                                        synchronized (Solver.class){
                                            numAC=numAC-solver.getPrice();
                                        }
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
        } while (option!=4);
    }

    public static void incrementAC(){
        synchronized (Solver.class) {
            numAC++;
        }
    }
}
