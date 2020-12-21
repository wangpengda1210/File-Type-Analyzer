import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        LocalTime time1 = LocalTime.parse(scanner.next());
        LocalTime time2 = LocalTime.parse(scanner.next());
        LocalTime time3 = LocalTime.parse(scanner.next());
        LocalTime time4 = LocalTime.parse(scanner.next());

        LocalTime startTime1;
        LocalTime endTime1;
        if (time1.isBefore(time2)) {
            startTime1 = time1;
            endTime1 = time2;
        } else {
            startTime1 = time2;
            endTime1 = time1;
        }

        LocalTime startTime2;
        LocalTime endTime2;
        if (time3.isBefore(time4)) {
            startTime2 = time3;
            endTime2 = time4;
        } else {
            startTime2 = time4;
            endTime2 = time3;
        }

        if (!startTime2.isBefore(startTime1) && !startTime2.isAfter(endTime1)) {
            System.out.println(true);
        } else System.out.println(!startTime1.isBefore(startTime2) &&
                !startTime1.isAfter(endTime2));
    }
}