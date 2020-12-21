import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        LocalDate date = LocalDate.parse(scanner.next());
        LocalDate firstBound = LocalDate.parse(scanner.next());
        LocalDate secondBound = LocalDate.parse(scanner.next());

        System.out.println((date.isAfter(firstBound) && date.isBefore(secondBound)) ||
                (date.isAfter(secondBound) && date.isBefore(firstBound)));
    }
}