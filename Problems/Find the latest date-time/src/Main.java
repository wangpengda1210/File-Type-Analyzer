import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        LocalDateTime latestDateTime = LocalDateTime.MIN;

        for (int i = 0; i < count; i++) {
            LocalDateTime nextDateTime = LocalDateTime.parse(scanner.nextLine());

            if (nextDateTime.isAfter(latestDateTime)) {
                latestDateTime = nextDateTime;
            }
        }

        System.out.println(latestDateTime);
    }
}