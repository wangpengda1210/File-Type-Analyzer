import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        LocalDateTime dateTimeFirst = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime dateTimeSecond = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime start;
        LocalDateTime end;

        if (dateTimeFirst.isBefore(dateTimeSecond)) {
            start = dateTimeFirst;
            end = dateTimeSecond;
        } else {
            end = dateTimeFirst;
            start = dateTimeSecond;
        }

        int count = Integer.parseInt(scanner.nextLine());
        int result = 0;

        for (int i = 0; i < count; i++) {
            LocalDateTime current = LocalDateTime.parse(scanner.nextLine());

            if (!current.isBefore(start) && current.isBefore(end)) {
                result++;
            }
        }

        System.out.println(result);
    }
}