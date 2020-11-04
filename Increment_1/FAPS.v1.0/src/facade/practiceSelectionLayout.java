package facade;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class practiceSelectionLayout {

    private JPanel rootPanel;
    private JRadioButton addButton;
    private JRadioButton multiButton;
    private JRadioButton divButton;
    private JRadioButton mixButton;
    private JLabel title;
    private JTextField numField;
    private JButton submitButton;
    private JRadioButton minusButton;
    private String pattern = "null";

    public practiceSelectionLayout() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pattern = "add";
            }
        });
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pattern = "minus";
            }
        });
        multiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pattern = "multiply";
            }
        });
        divButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pattern = "divide";
            }
        });
        mixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pattern = "mix";
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int problem_num = 0;
                try {
                    problem_num = Integer.parseInt(numField.getText());
                    if (problem_num < 1 || problem_num > 100) {
                        JOptionPane.showMessageDialog(null, "输入的题目数不在范围内",
                                "题目数输入错误", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (!pattern.equals("add") && !pattern.equals("minus")
                            && !pattern.equals("multiply") && !pattern.equals("divide") && !pattern.equals("mix")) {
                        JOptionPane.showMessageDialog(null, "请在五种题目类型中选择一个",
                                "未选择题目类型", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    AnswerLayout answerLayout = new AnswerLayout();
                    answerLayout.createGUI(problem_num, pattern);             //将题目数量与模式作为参数交给answerLayOut
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "输入的题目数不是整数",
                            "题目数输入错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        numField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                numField.setText("");
            }
        });
    }

    public static void createGUI() {
        JFrame frame = new JFrame("practiceSelectionLayout");
        frame.setContentPane(new practiceSelectionLayout().rootPanel);
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
