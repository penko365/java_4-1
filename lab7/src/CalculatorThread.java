import java.util.ArrayList;
import java.util.List;

public class CalculatorThread implements Runnable {
    List<Integer> list = new ArrayList<>();
    private int a;

    public CalculatorThread(int a) {
        this.a = a;
    }

    public List<Integer> getList() {
        return list;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start;");
        int i = 1;
        while (i <= a) {
            if ((i % 3) == 1) list.add(i);
            i++;
        }
        System.out.print(list.get(0));
        for (int j = 1; j < list.size(); j++) {
            System.out.print(", " + list.get(j));
        }
        System.out.println("\n");
    }

}
