package facade;

import count.Calculate;
import fileExport.FileExport;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class AnswerLayout {
    private JPanel rootPanel;
    private JTextField questionField;
    private JButton nextButton;
    private JButton a4Button;
    private JButton a7Button;
    private JButton a1Button;
    private JButton a0Button;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton a9Button;
    private JButton a6Button;
    private JButton a3Button;
    private JProgressBar progressBar1;
    private JTextField answerField;
    private JButton delButton;
    private JButton nextButton1;
    private JButton minusButton;
    private static int remainingProblemNum; //未答完的题目数量
    private static String pattern;  //答题模式
    private static int correctAnswer;  //当前题目正确答案
    private static int right_num = 0;
    private static int wrong_num = 0;

    public AnswerLayout() {
        //提交按钮监听器
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (answerField.getText().length() != 0 && !answerField.getText().equals("-")) {  //判断答案提交文本框是否为空
                    if (Integer.parseInt(answerField.getText()) == correctAnswer) {    //答案正确
                        questionField.setText("Right!");
                        questionField.paintImmediately(questionField.getBounds());
                        right_num++;
                    } else {                                                       //答案不正确
                        questionField.setText("Wrong!");
                        questionField.paintImmediately(questionField.getBounds());
                        wrong_num++;
                    }
                }
            }
        });
        //下一题按钮监听器
        nextButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerField.setText("");
                if (remainingProblemNum == 0) {                                         //判断答题是否结束
                    questionField.setText("the end");
                    questionField.paintImmediately(questionField.getBounds());
                    NumberFormat numberFormat = NumberFormat.getPercentInstance();
                    numberFormat.setMaximumFractionDigits(2);
                    String message = "accuracy:" + numberFormat
                            .format((double) right_num / (double) (right_num + wrong_num)) + "\n" + "right:" +
                            right_num + "\nall:" + (right_num + wrong_num);
                    JOptionPane
                            .showMessageDialog(null, message, "", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        FileExport.fileExport(message);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                } else {                                                        //生成题目与标准答案的过程
                    remainingProblemNum--;
                    Calculate tempCalculate = new Calculate();
                    tempCalculate.generateNum();
                    String sym = "";
                    switch (pattern) {
                        case "add":
                            correctAnswer = tempCalculate.getAnswerByPlus();
                            sym = " + ";
                            break;
                        case "multiply":
                            correctAnswer = tempCalculate.getAnswerByMultiply();
                            sym = " × ";
                            break;
                        case "divide":
                            correctAnswer = tempCalculate.getAnswerByDivide();
                            sym = " ÷ ";
                            break;
                        case "minus":
                            correctAnswer = tempCalculate.getAnswerByMinus();
                            sym = " - ";
                            break;
                        default:
                            assert "mix".equals(pattern);
                            List<String> patternList = new ArrayList<>();
                            patternList.add("add");
                            patternList.add("minus");
                            patternList.add("multiply");
                            patternList.add("divide");
                            String randomPattern = patternList.get((int) (Math.random() * 4));
                            switch (randomPattern) {
                                case "add":
                                    correctAnswer = tempCalculate.getAnswerByPlus();
                                    sym = " + ";
                                    break;
                                case "multiply":
                                    correctAnswer = tempCalculate.getAnswerByMultiply();
                                    sym = " × ";
                                    break;
                                case "divide":
                                    correctAnswer = tempCalculate.getAnswerByDivide();
                                    sym = " ÷ ";
                                    break;
                                default:
                                    assert "minus".equals(randomPattern);
                                    correctAnswer = tempCalculate.getAnswerByMinus();
                                    sym = " - ";
                                    break;
                            }
                    }
                    int[] temp = tempCalculate.getEquation();
                    String question = temp[0] + sym + temp[1];
                    questionField.setText(question);
                    questionField.paintImmediately(questionField.getBounds());
                }
            }
        });
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerField.setText(answerField.getText() + "0");
            }
        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerField.setText(answerField.getText() + "1");
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerField.setText(answerField.getText() + "2");
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerField.setText(answerField.getText() + "3");
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerField.setText(answerField.getText() + "4");
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerField.setText(answerField.getText() + "5");
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerField.setText(answerField.getText() + "6");
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerField.setText(answerField.getText() + "7");
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerField.setText(answerField.getText() + "8");
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerField.setText(answerField.getText() + "9");
            }
        });
        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerField.setText(answerField.getText().substring(0, answerField.getText().length() - 1));
            }
        });
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = answerField.getText();
                if (text.length() == 0) {
                    answerField.setText("-");
                    return;
                }
                String first = text.substring(0, 1);
                if ("-".equals(first)) {
                    answerField.setText(answerField.getText().substring(1));
                } else {
                    answerField.setText("-" + answerField.getText());
                }
            }
        });
    }

    public void createGUI(int num, String pat) {
        remainingProblemNum = num;
        pattern = pat;
        JFrame frame = new JFrame("MyGUI");
        frame.setContentPane(new AnswerLayout().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void createGUI(int num) {
        remainingProblemNum = num;
        pattern = "mix";
        JFrame frame = new JFrame("MyGUI");
        frame.setContentPane(new AnswerLayout().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


/*
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }

 */

}
