import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {
    private int numAC;

    public Controller(){
        numAC=0;
    }

    public void exec() {
        ArrayList<StoreElement> storeElements = null;
        boolean storeAvailable;
        try {
            storeElements = JsonUtil.readStoreElements();
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
            StringBuilder sb = new StringBuilder();
            switch (option) {
                case 1:
                    //Add AC
                    //TODO Implement option 1
                    System.out.println("Option 1");
                    break;
                case 2:
                    //Show total AC
                    sb.append("Until now ");
                    sb.append(numAC);
                    sb.append(" ACs have been solved. Good work!");
                    Menu.display(sb.toString());
                    //TODO Show bought items
                    break;
                case 3:
                    //Buy AC
                    if(storeAvailable){
                        //TODO implement store
                        System.out.println("Implement store");
                    } else {
                        System.err.println("Store not available.");
                    }
                    break;
                case 4:
                    //Exit
                    sb.append("Game Over! Final points: ");
                    sb.append(numAC);
                    sb.append(" ACs.");
                    System.exit(0);
                    break;
            }
        } while (option!=4);
    }
}
