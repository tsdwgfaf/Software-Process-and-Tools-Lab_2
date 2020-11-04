package facade;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuLayout {

    private JButton practiceButton;
    private JLabel title;
    private JPanel rootPanel;

    public MenuLayout() {
        practiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                practiceSelectionLayout.createGUI();
            }
        });
    }

    public static void createGUI() {
        JFrame frame = new JFrame("MenuLayout");
        frame.setContentPane(new MenuLayout().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }
}
