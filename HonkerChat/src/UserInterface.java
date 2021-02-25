import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {
    private JPanel chatContent;
    private JScrollPane centerPanel;
    private BoxLayout chatLayout;

    public UserInterface() {
        setTitle("Honker Chat");
        setSize(250, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        centerPanel = new JScrollPane();
        chatContent = new JPanel();
        chatLayout = new BoxLayout(chatContent, BoxLayout.Y_AXIS);
        chatContent.setLayout(chatLayout);
        centerPanel.add(chatContent);
        add(centerPanel);
        JButton honkButton = new JButton("HONK");
        add(honkButton, BorderLayout.SOUTH);
        //setVisible(true);
    }

    public void addHonk(){
        chatContent.add(new JLabel("HONK"));
        centerPanel.add(chatContent);
    }
    public void addHonk(String name){
        chatContent.add(new JLabel(name));
        chatContent.add(new JLabel("HONK"));
        centerPanel.add(chatContent);
    }
}
