package facade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuLayout {

    private JButton practiceButton;
    private JButton examButton;
    private JLabel title;
    private JPanel rootPanel;
    private JButton reviewButton;

    public MenuLayout() {
        practiceButton.addActionListener(e -> SwingUtilities.invokeLater(practiceSelectionLayout::createGUI));
        examButton.addActionListener(e -> SwingUtilities.invokeLater(examSelectionLayout::createGUI));
        reviewButton.addActionListener(e -> SwingUtilities.invokeLater(() -> new ReviewSelectionLayout().createGUI()));
    }

    public static void createGUI() {
        JFrame frame = new JFrame("MenuLayout");
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new MenuLayout().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuLayout::createGUI);
    }
}
