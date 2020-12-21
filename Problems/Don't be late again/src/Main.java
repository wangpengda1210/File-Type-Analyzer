import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        LocalTime outTime = LocalTime.of(19, 30);

        for (int i = 0; i < count; i++) {
            String name = scanner.next();
            LocalTime closeTime = LocalTime.parse(scanner.next());

            if (outTime.plusMinutes(30).isBefore(closeTime)) {
                System.out.println(name);
            }
        }
    }
}