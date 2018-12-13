/**
 * Created by yaroslavkohun on 10/16/17.
 */
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] array1 = new int[1000];
        fillArray(array1);
        int[] array2 = array1.clone();
        int[] array3 = array1.clone();
        int[] array4 = array1.clone();
        int[] array5 = array1.clone();

        long start = System.nanoTime();
        bubbleSort(array1);
        long finish = System.nanoTime();
        System.out.println("Bubble Sort:");
        System.out.println("Time: "+(finish-start));

        start = System.nanoTime();
        insertionSort(array2,0,array2.length-1);
        finish = System.nanoTime();
        System.out.println("Insertion Sort:");
        System.out.println("Time: "+(finish-start));



        start = System.nanoTime();
        quickSort(array3);
        finish = System.nanoTime();
        System.out.println("Quick Sort:");
        System.out.println("Time: "+(finish-start));

        start = System.nanoTime();
        quickSortBetter(array4);
        finish = System.nanoTime();
        System.out.println("Quick+Insertion Sort:");
        System.out.println("Time: "+(finish-start));


        start = System.nanoTime();
        Arrays.sort(array5);
        finish = System.nanoTime();
        System.out.println("System Sort:");
        System.out.println("Time: "+(finish-start));

    }
    public static int cut = 12;

    public static void fillArray(int[] array) {
        Random generator = new Random(22);
        for (int i=0; i<array.length; i++) {
            array[i] = generator.nextInt(100);
        }
    }

    public static void printArray(int[] array) {
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr[j-1] > arr[j]){
                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }

            }
        }

    }

    public static void quickSort(int[] array) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        doSort(array, startIndex, endIndex);
    }

    public static void quickSortBetter(int[] array) {
        quickSort(array);
    }
    public static void insertionSort(int[] array, int start, int end) {
        int startIndex = start;
        int endIndex = end;

        for(int i = startIndex ; i < endIndex ; i++)
            for(int j = i+1 ; j > startIndex ; j--) {
                if(array[j-1]> array[j]) {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j]  = temp;
                }
                else break;
            }
    }
    private static void doSort(int[] array, int start, int end) {
        if(start + cut >= end) {
            insertionSort(array, start, end);
            return;
        }

        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while ((array[i] <= array[cur]) && i < cur) {
                i++;
            }
            while ((array[cur] <= array[j]) && j > cur) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(array, start, cur);
        doSort(array, cur+1, end);
    }

}
