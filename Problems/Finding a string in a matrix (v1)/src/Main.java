import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // put your code here...
        Scanner scanner = new Scanner(System.in);

        String pattern = scanner.nextLine();

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            sb.append(scanner.nextLine());
        }

        List<Integer> occurrences = KMPSearch(sb.toString(), pattern);

        ArrayList<String> positions = new ArrayList<>();
        for (int occurrence : occurrences) {
            positions.add(occurrence / cols + " " + occurrence % cols);
        }

        if (positions.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(positions.size());
            for (String position : positions) {
                System.out.println();
            }
        }
    }

    public static int[] prefixFunction(String str) {
        /* 1 */
        int[] prefixFunc = new int[str.length()];

        /* 2 */
        for (int i = 1; i < str.length(); i++) {
            /* 3 */
            int j = prefixFunc[i - 1];

            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = prefixFunc[j - 1];
            }

            /* 4 */
            if (str.charAt(i) == str.charAt(j)) {
                j += 1;
            }

            /* 5 */
            prefixFunc[i] = j;
        }

        /* 6 */
        return prefixFunc;
    }

    public static List<Integer> KMPSearch(String text, String pattern) {
        /* 1 */
        int[] prefixFunc = prefixFunction(pattern);
        ArrayList<Integer> occurrences = new ArrayList<Integer>();
        int j = 0;
        /* 2 */
        for (int i = 0; i < text.length(); i++) {
            /* 3 */
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = prefixFunc[j - 1];
            }
            /* 4 */
            if (text.charAt(i) == pattern.charAt(j)) {
                j += 1;
            }
            /* 5 */
            if (j == pattern.length()) {
                occurrences.add(i - j + 1);
                j = prefixFunc[j - 1];
            }
        }
        /* 6 */
        return occurrences;
    }
}