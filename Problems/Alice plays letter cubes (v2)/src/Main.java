import java.util.*;

public class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String current = "";
        int count = 1;

        for (int i = 0; i < text.length(); i++) {
            current = current + text.charAt(i);
            String reveredCurrent = new StringBuffer(current).reverse().toString();

            int[] prefix = prefixFunction(reveredCurrent);
            count += current.length() - Arrays.stream(prefix).max().getAsInt();
        }

        System.out.println(count);
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
}