import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final int a = 53;
    static final long m = 1_000_000_000 + 9;
    static ArrayList<Long> substringHashes = new ArrayList<>();

    public static long charToLong(char ch) {
        return ch - 'A' + 1;
    }

    public static void main(String[] args) {
        // put your code here
        String text = new Scanner(System.in).nextLine();
        for (int i = 1; i <= text.length(); i++) {
            findDistinct(text, i);
        }
        System.out.println(substringHashes.size() + 1);
    }

    public static void findDistinct(String text, int length) {
        long pow = 1;
        long currentHash = 0;

        ArrayList<Long> currentLength = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            currentHash += charToLong(text.charAt(text.length() - length + i)) * pow;
            currentHash %= m;

            if (i != length - 1) {
                pow = (pow * a) % m;
            }
        }

        for (int i = text.length(); i >= length; i--) {
            if (!currentLength.contains(currentHash)) {
                currentLength.add(currentHash);
            }

            if (i != length) {
                currentHash = (currentHash - charToLong(text.charAt(i - 1)) * pow % m + m) * a % m;
                currentHash = (currentHash + charToLong(text.charAt(i - length - 1))) % m;
            }
        }

        substringHashes.addAll(currentLength);
    }
}