package by.pms.fileIO;

import by.pms.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWrite {
    public static void writeToFile(List<User> users) {
        try (FileWriter wr = new FileWriter("src\\by\\pms\\fileIO\\Out.txt", false)) {
            for (User a : users) {
                wr.write(a.getElements());
                wr.append("\n");
            }
            wr.flush();
        } catch (IOException e) {
            e.getMessage();
        }
        System.out.println("writing successful");
    }
}
