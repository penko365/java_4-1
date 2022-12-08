package by.pms;

import java.util.Comparator;

public class ComareByNick implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        if (o1.getNick().length() < o2.getNick().length()) return -1;
        if (o1.getNick().length() > o2.getNick().length()) return 1;
        return o1.getNick().toLowerCase().compareTo(o2.getNick().toLowerCase());
    }
}
