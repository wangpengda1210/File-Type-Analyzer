package analyzer;

public class SearchUtil {

    static final int A = 53;
    static final long M = 1_000_000_000 + 9;

    private static int[] prefixFunction(String str) {
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

    public static boolean naiveSearch(String text, String pattern) {
        if (text.length() < pattern.length()) {
            return false;
        }

        for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
            boolean patternIsFound = true;

            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    patternIsFound = false;
                    break;
                }
            }

            if (patternIsFound) {
                return true;
            }
        }

        return false;
    }

    private static long charToLong(char c) {
        return c;
    }

    public static boolean RKSearch(String text, String pattern) {

        if (pattern.length() > text.length()) {
            return false;
        }

        long pow = 1;
        long currentHash = 0;
        long patternHash = 0;

        for (int i = 0; i < pattern.length(); i++) {
            patternHash += charToLong(pattern.charAt(i)) * pow;
            patternHash %= M;

            currentHash += charToLong(text.charAt(text.length() - pattern.length() + i)) * pow;
            currentHash %= M;

            if (i != pattern.length() - 1) {
                pow = pow * A % M;
            }
        }

        for (int i = text.length(); i >= pattern.length(); i--) {
            if (currentHash == patternHash) {
                boolean patternFound = true;

                for (int j = 0; j < pattern.length(); j++) {
                    if (pattern.charAt(j) != text.charAt(i - pattern.length() + j)) {
                        patternFound = false;
                        break;
                    }
                }

                if (patternFound) {
                    return true;
                }
            }

            if (i != pattern.length()) {
                currentHash = (currentHash -
                        charToLong(text.charAt(i - 1)) * pow % M + M) * A % M;
                currentHash = (currentHash +
                        charToLong(text.charAt(i - 1 - pattern.length()))) % M;
            }
        }

        return false;
    }

}
