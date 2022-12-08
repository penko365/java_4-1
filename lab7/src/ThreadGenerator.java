import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadGenerator {
    static int thrNum;
    static int a;
    static List<CalculatorThread> list = new ArrayList<>();
    static String action;

    public static void main(String[] args) throws Exception {
        System.out.println("Enter number of threads");
        try (Scanner sc = new Scanner(System.in)) {
            thrNum = Integer.parseInt(sc.nextLine());
            System.out.println("Enter number");
            a = Integer.parseInt(sc.nextLine());
            System.out.println("Enter what to do with result");
            action = sc.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("input number has wrong format.");
        }
        execute();
        getResult();
    }

    private static void execute() {
        for (int i = 0; i < thrNum; i++) {
            list.add(new CalculatorThread(a));
            Thread thr = new Thread(list.get(i));
            thr.start();
            try {
                thr.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (var s : list) {
            for (int i : s.list) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

    private static void getResult() {
        List<Integer> finalList = new ArrayList<>();
        int tmp = 0;
        switch (action) {
            case "+" -> {
                for (var d : list) {
                    tmp = 0;
                    for (int i : d.list) {
                        tmp += i;
                    }
                    finalList.add(tmp);
                }
            }
            case "-" -> {
                for (var d : list) {
                    tmp = 0;
                    for (int i : d.list) {
                        tmp -= i;
                    }
                    finalList.add(tmp);
                }
            }
            case "*" -> {
                tmp = 1;
                for (var d : list) {
                    tmp = 1;
                    for (int i : d.list) {
                        tmp *= i;
                    }
                    finalList.add(tmp);
                }
            }
            default -> System.out.println("Default is 0");
        }
        System.out.println("Result: ");
        for (var s : finalList) {
            System.out.print(s + " ");
        }
    }

}
