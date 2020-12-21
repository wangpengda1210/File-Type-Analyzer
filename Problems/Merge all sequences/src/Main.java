import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        ArrayList<int[]> lists = new ArrayList<>();
        int numLists = scanner.nextInt();

        for (int i = 0; i < numLists; i++) {
            int[] list = new int[scanner.nextInt()];
            for (int j = 0; j < list.length; j++) {
                list[j] = scanner.nextInt();
            }
            lists.add(list);
        }

        int[] result = new int[0];
        for (int[] list : lists) {
            result = merge(result, list);
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] merge(int[] firstArray, int[] secondArray) {
        int[] result = new int[firstArray.length + secondArray.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < firstArray.length && j < secondArray.length) {
            if (firstArray[i] >= secondArray[j]) {
                result[k] = firstArray[i];
                i++;
            } else {
                result[k] = secondArray[j];
                j++;
            }
            k++;
        }

        while (i < firstArray.length) {
            result[k] = firstArray[i];
            i++;
            k++;
        }

        while (j < secondArray.length) {
            result[k] = secondArray[j];
            j++;
            k++;
        }

        return result;
    }
}