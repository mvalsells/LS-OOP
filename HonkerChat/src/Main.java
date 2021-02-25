public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        for (int i = 0; i < 5; i++) {
            userInterface.addHonk();
            userInterface.addHonk("Pep");
            userInterface.addHonk("Claudia");
        }
    }
}
