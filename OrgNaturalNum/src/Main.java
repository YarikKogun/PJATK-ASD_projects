import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by yaroslavkohun on 1/7/18.
 */
class Main {
    private static int count = 0;
    private static int t;
    private static int pos;
    private static ArrayList<Integer> list = new ArrayList<>();

    private static void operationR() {
        Integer c;
        int indexC;
        if (pos + 1 >= list.size()) {
            c = list.get(pos + 1 - list.size());
            indexC = pos + 1 - list.size();
        } else {
            c = list.get(pos + 1);
            indexC = pos + 1;
        }
        list.remove(indexC);
        if(indexC>pos)
            pos += c;
        else
            pos+=c-1;
        while (pos >= list.size())
            pos -= list.size();
    }

    private static void operationX() {
        Integer c = list.get(pos);
        if (pos + 1 >= list.size())
            list.add(c - 1);
            //list.add(pos+1-list.size(), c-1);
        else
            list.add(pos + 1, c - 1);
        pos += c;
        while (pos >= list.size())
            pos -= list.size();
    }

    private static void printListFromPOS() {
        if (!list.isEmpty()) {
            if (pos == 0) {
                for (int i : list)
                    System.out.print(i + " ");
                System.out.print("\n" + count);
            } else {
                for (int i = pos; i < list.size(); i++) {
                    System.out.print(list.get(i) + " ");
                }
                for (int i = 0; i < pos; i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.print("\n" + count);
            }
        } else {
            System.out.print(-1 + "\n" + count);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        t = scanner.nextInt();
        count += (t + "").length();
        while (scanner.hasNext()) {
            int tmp = scanner.nextInt();
            list.add(tmp);
            count += (tmp + "").length();
        }

        if (!list.isEmpty()) {
            pos = 0;
            for (int i = 0; i < t; i++) {
                if (list.get(pos) % 2 == 0) {
                    operationR();
                } else {
                    operationX();
                }
            }
        }
        printListFromPOS();

    }
}