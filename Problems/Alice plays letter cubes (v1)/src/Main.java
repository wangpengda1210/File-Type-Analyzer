import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        scanner.nextLine();
        String[] letters = scanner.nextLine().split(" ");

        for (String letter : letters) {
            String newText = letter + text;
            int count = 0;

            for (int i = 1; i <= newText.length(); i++) {
                String pattern = newText.substring(0, i);
                if (!KMPSearch(text, pattern)) {
                    count++;
                }
            }

            System.out.print(count + " ");
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

    public static boolean KMPSearch(String text, String pattern) {
        /* 1 */
        int[] prefixFunc = prefixFunction(pattern);

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
                return true;
            }
        }
        /* 6 */
        return false;
    }
}