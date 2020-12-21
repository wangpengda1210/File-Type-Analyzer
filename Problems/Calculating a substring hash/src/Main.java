import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int a = 53;
    static final long m = 1_000_000_000 + 9;

    private static long charToLong(char c) {
        return c - 'a' + 33;
    }

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        long[] prefixHashes = new long[text.length()];

        long pow = 1;
        long currentHash = 0;
        for (int i = 0; i < prefixHashes.length; i++) {
            currentHash = (currentHash + pow * charToLong(text.charAt(i))) % m;
            prefixHashes[i] = currentHash;

            if (i != prefixHashes.length - 1) {
                pow = pow * a % m;
            }
        }

        System.out.println(Arrays.toString(prefixHashes).replace("[", "")
                .replace("]", "").replace(",", ""));

        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            long startValue = start == 0 ? 0 : prefixHashes[start - 1];
            long endValue = end == 0 ? 0 : prefixHashes[end - 1];
            System.out.print((m + endValue - startValue) % m + " ");
        }

    }
}