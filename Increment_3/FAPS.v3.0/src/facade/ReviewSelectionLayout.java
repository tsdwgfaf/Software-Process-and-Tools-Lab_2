package facade;

import fileExport.Record;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.List;

public class ReviewSelectionLayout {

    private JPanel rootPanel;

    public void createGUI() {
        JFrame jf = new JFrame("选择复习的内容");
        jf.setSize(400, 250);
        jf.setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        // 添加一个标签
        JLabel label = new JLabel("日期：");
        panel.add(label);

        // 需要选择的条目
        String basePath="resource";
        String[] dateList;
        JComboBox<String> comboBox;
        if ((dateList = new File(basePath).list()) == null) {
            comboBox = new JComboBox<>(new String[]{"无历史记录"});
        } else {
            comboBox = new JComboBox<>(dateList);
        }

        // 添加条目选中状态改变的监听器
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 只处理选中的状态
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String fileName = (String)comboBox.getSelectedItem();
                    assert fileName != null;
                    fileName = fileName.substring(0, fileName.length()-4);
                    List<String> recordList = new Record().read(fileName);
                    SwingUtilities.invokeLater(() -> new ReviewLayout().createGUI(recordList));
                }
            }
        });

        // 添加到内容面板
        panel.add(comboBox);

        jf.setContentPane(panel);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new ReviewSelectionLayout().createGUI();
    }
}
