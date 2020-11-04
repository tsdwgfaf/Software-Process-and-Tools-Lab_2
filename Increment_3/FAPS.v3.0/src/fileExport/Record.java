package fileExport;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Record {

    private final String rootPath = "resource/";

    public void save(List<String> recordList) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
        File fp = new File(rootPath, formatter.format(LocalDateTime.now()) + ".csv");
        // 创建文件
        try {
            fp.createNewFile();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try (BufferedWriter bw
                     = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fp), StandardCharsets.UTF_8))) {
            bw.write("题目,正确答案,你的答案,是否正确\n");
            for (String s : recordList) {
                bw.write(s + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> read(String fileName) {
        List<String> recordList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(rootPath + fileName + ".csv"))) {
            String lineString;
            bufferedReader.readLine();
            while ((lineString = bufferedReader.readLine()) != null) {
                recordList.add(lineString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(recordList);
    }


    public static void main(String[] args) {
        new Record().save(new ArrayList<>());
    }
}
