import java.util.*;

public class Main {
    static int count = 0;

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[scanner.nextInt()];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        mergeSort(array);
        System.out.println(count);
    }

    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length);
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        int middle = start + (end - start) / 2;

        mergeSort(array, start, middle);
        mergeSort(array, middle, end);

        int[] toArray = array.clone();
        merge(array, toArray, start, middle, end);
        System.arraycopy(toArray, 0, array, 0, array.length);
    }

    private static void merge(int[] array, int[] toArray, int start, int middle, int end) {
        int i = start;
        int j = middle;
        int k = start;
        count++;

        while (i < middle && j < end) {
            if (array[i] <= array[j]) {
                toArray[k] = array[i];
                i++;
            } else {
                toArray[k] = array[j];
                j++;
            }
            k++;
        }

        while (i < middle) {
            toArray[k] = array[i];
            i++;
            k++;
        }

        while (j < end) {
            toArray[k] = array[j];
            j++;
            k++;
        }
    }
}