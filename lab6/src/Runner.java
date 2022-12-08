import by.pms.ComareByNick;
import by.pms.User;
import by.pms.fileIO.FileRead;
import by.pms.fileIO.FileWrite;

import java.util.Collections;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<User> users = FileRead.FileRead();
        print(users);
        Collections.sort(users, new ComareByNick());
        print(users);
        FileWrite.writeToFile(users);
    }

    private static void print(List<User> users) {
        for (var s : users) {
            System.out.println(s.toString());
        }
        System.out.println("\n");
    }
}
