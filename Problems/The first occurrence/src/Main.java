import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String pattern = scanner.nextLine();
        String text = scanner.nextLine();

        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            boolean found = true;

            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }
}