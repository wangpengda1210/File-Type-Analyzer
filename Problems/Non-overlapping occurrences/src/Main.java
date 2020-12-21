import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        String text = scanner.nextLine();

        ArrayList<Integer> occurrences = findOccurrences(pattern, text);
        if (occurrences.size() == 0) {
            System.out.println(0);
        } else {
            System.out.println(occurrences.size());
            for (int occurrence : occurrences) {
                System.out.print(occurrence + " ");
            }
        }
    }

    private static ArrayList<Integer> findOccurrences(String pattern, String text) {
        ArrayList<Integer> occurrences = new ArrayList<>();

        if (pattern.length() > text.length()) {
            return occurrences;
        }

        if (pattern.equals("")) {
            occurrences.add(0);
            return occurrences;
        }

        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            boolean found = true;

            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                occurrences.add(i);
                i += pattern.length() - 1;
            }
        }

        return occurrences;
    }
}