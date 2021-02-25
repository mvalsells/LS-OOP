import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class UserInterface extends JFrame {
    private JPanel chatContent;
    private JScrollPane centerPanel;
    private BoxLayout chatLayout;

    public UserInterface() {
        //Frame config
        setTitle("Honker Chat");
        setSize(250, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Containers organization
        chatContent = new JPanel();
        chatLayout = new BoxLayout(chatContent, BoxLayout.Y_AXIS);
        chatContent.setLayout(chatLayout);
        chatContent.setBackground(Color.WHITE);
        centerPanel = new JScrollPane(chatContent);
        add(centerPanel, BorderLayout.CENTER);
        JButton honkButton = new JButton("HONK");
        add(honkButton, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void addHonk(){
        JLabel msg = new JLabel("HONK");
        msg.setForeground(Color.WHITE);
        msg.setOpaque(true);
        msg.setBackground(Color.decode("#3782F6"));
        msg.setBorder(new EmptyBorder(5,5,5,5));
        chatContent.add(msg);
    }

    public void addHonk(String name){
        chatContent.add(new JLabel(name));
        JLabel msg = new JLabel("HONK");
        msg.setForeground(Color.BLACK);
        msg.setOpaque(true);
        msg.setBackground(Color.decode("#E9E9EB"));
        msg.setBorder(new EmptyBorder(5,5,5,5));
        chatContent.add(msg);
    }
}
