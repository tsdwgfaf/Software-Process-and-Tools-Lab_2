package facade;

import fileExport.Record;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class ReviewLayout {
    private JPanel panel1;
    private JTableHeader tableHeader = new JTableHeader();
    private JScrollPane scrollPane;

    public JTable createTable(List<String> recordList) {
        //表头
        String[] rowData = {"题目", "正确答案", "你的答案", "是否正确"};
        //表中数据
        Object[][] data = new Object[recordList.size()][4];
        for (int i = 0; i < recordList.size(); i++) {
            String[] lineList = recordList.get(i).split(",");
            System.arraycopy(lineList, 0, data[i], 0, lineList.length);
        }
        // 设置表格内容颜色
        JTable table = new JTable(data, rowData);
        table.setForeground(Color.BLACK);                   // 字体颜色
        table.setFont(new Font("宋体", Font.PLAIN, 14));      // 字体样式
        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
        table.setGridColor(Color.GRAY);                     // 网格颜色
        // 设置表头
        table.getTableHeader().setFont(new Font("黑体", Font.BOLD, 14));  // 设置表头名称字体样式
        table.getTableHeader().setForeground(Color.BLUE);                // 设置表头名称字体颜色
        //table.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
        table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列
        // 设置行高
        table.setRowHeight(30);
        // 第一列列宽设置为40
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
        table.setPreferredScrollableViewportSize(new Dimension(400, 300));
        return table;
    }

    public void createGUI(List<String> recordList) {
        JFrame jFrame = new JFrame("复习");

        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(createTable(recordList));
        panel.add(scrollPane);
        jFrame.setContentPane(panel);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new ReviewLayout().createGUI(new Record().read("2020年10月23日12时08分11秒"));
    }

}
