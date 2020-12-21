import java.util.Scanner;

public class Main {

    static final int a = 53;
    static final long m = 1_000_000_000 + 9;

    private static long charToLong(char c) {
        return c - 'A' + 1;
    }

    public static void main(String[] args) {
         // put your code here

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int length = scanner.nextInt();

        for (int i = text.length() - length; i >= 0; i--) {
            String pattern = text.substring(i, i + length);

            if (hasTwice(text, pattern)) {
                System.out.println(pattern);
                return;
            }
        }

        System.out.println("does not contain");
    }

    private static boolean hasTwice(String text, String pattern) {

        long pow = 1;
        long currentHash = 0;
        long patternHash = 0;

        for (int i = 0; i < pattern.length(); i++) {
            patternHash += charToLong(pattern.charAt(i)) * pow;
            patternHash %= m;

            currentHash += charToLong(text.charAt(text.length() - pattern.length() + i)) * pow;
            currentHash %= m;

            if (i != pattern.length() - 1) {
                pow = (pow * a) % m;
            }
        }

        int findCount = 0;
        for (int i = text.length(); i >= pattern.length(); i--) {

            if (patternHash == currentHash) {
                boolean patternFound = true;

                for (int j = 0; j < pattern.length(); j++) {
                    if (pattern.charAt(j) != text.charAt(i - pattern.length() + j)) {
                        patternFound = false;
                        break;
                    }
                }

                if (patternFound) {
                    findCount++;
                    if (findCount == 2) {
                        return true;
                    }
                }
            }

            if (i != pattern.length()) {
                currentHash = (currentHash -
                        charToLong(text.charAt(i - 1)) * pow % m + m) * a % m;
                currentHash = (currentHash +
                        charToLong(text.charAt(i - 1 - pattern.length()))) % m;
            }

        }

        return false;

    }

}