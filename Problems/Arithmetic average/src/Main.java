import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int first = scanner.nextInt();
        int second = scanner.nextInt();
        double total = 0;
        int count = 0;

        for (int i = first; i <= second; i++) {
            if (i % 3 == 0) {
                total += i;
                count++;
            }
        }

        System.out.println(total / count);
    }
}