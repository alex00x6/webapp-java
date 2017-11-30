import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileHandler {

    public void makeFile(String fileName, ArrayList<String> fileContent) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
            for (String str : fileContent) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile(String fileName) {
        if (!new File(fileName).exists()) {
            makeFile(fileName, new Random().russianAbuses());
        }
        File file = new File(fileName).getAbsoluteFile();
        return file;
    }

    public String readFromFile(String fileName) {
        if (!new File(fileName).exists()) {
            makeFile(fileName, new Random().russianAbuses());
        }
        return openTextFile(fileName);
    }

    public List<String> fileToArrayList(String fullPathToFile) {
        Charset charset = Charset.forName("UTF-8");
        List<String> result = null;
        try {
            result = Files.lines(Paths.get(fullPathToFile), charset).collect(Collectors.toList());
        } catch (IOException ignored) {
        }
        return result;
    }

    private String openTextFile(String fileName) {
        StringBuilder result = new StringBuilder();
        List<String> text = fileToArrayList(new File(fileName).getAbsolutePath());
        for (String temp : text) {
            result.append(temp).append("<br>");
        }
        return result.toString();
    }

    public void addToFile(String filename, String toAdd) {
        try {
            Files.write(Paths.get(filename), (toAdd + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ignored) {
        }
    }
}
