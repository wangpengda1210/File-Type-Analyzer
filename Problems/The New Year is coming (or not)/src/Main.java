import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.parse(scanner.next());

        LocalDate newDate = date.plusDays(scanner.nextInt());

        System.out.println(newDate.isAfter(date) && newDate.getMonthValue() == 1
                && newDate.getDayOfMonth() == 1);
    }
}