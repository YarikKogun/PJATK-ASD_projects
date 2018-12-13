import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] arr1 = null;
        String[] arr2 = null;
        try {
            arr1 = input.readLine().split("\\s");
            arr2 = input.readLine().split("\\s");
        } catch (IOException e) {
            e.printStackTrace();
        }

        long counter = arr1[0].length() + arr1[1].length();
        long num = Integer.parseInt(arr1[0]);
        long base = Integer.parseInt(arr1[1]);
        long summ = 0;
        long count = 0;

        for (int i = 0; i < num; i++) {
            summ += Integer.parseInt(arr2[i]);
            counter += arr2[i].length();
        }

        if (base == 1) {
            count = summ;
        } else
            while (summ != 0) {
                summ = summ / base;
                count++;
            }

        System.out.print(count + "\n");
        System.out.print(counter);

    }
}

