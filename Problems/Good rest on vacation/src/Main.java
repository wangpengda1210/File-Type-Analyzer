import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int days = scanner.nextInt();

        System.out.println(days * scanner.nextInt() + 2 * scanner.nextInt() +
                (days - 1) * scanner.nextInt());
    }
}