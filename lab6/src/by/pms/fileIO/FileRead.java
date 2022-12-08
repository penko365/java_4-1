package by.pms.fileIO;

import by.pms.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRead {
    public static List<User> FileRead() {
        final String FILE_NAME = "src\\by\\pms\\fileIO\\File.txt";
        List<String> lines = new ArrayList<>();
        List<User> users = new ArrayList<>();
        try (Scanner sc = new Scanner(new FileReader(FILE_NAME))) {
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String data : lines) {
            String[] dataSplit = data.split(" ");
            if (dataSplit.length != 6) {
                System.out.println("\t\twrong count of elements in file");
                continue;
            }
            users.add(new User(dataSplit));
        }

        return users;
    }
}
