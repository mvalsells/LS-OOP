import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.addHonk();
        userInterface.addHonk("Pep");
        userInterface.setVisible(true);
    }
}
