import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        int shiftCount = 0;
        for (int i = 1; i < numbers.length; i++) {
            int elem = numbers[i];

            boolean shifted = false;
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[j] < elem) {
                    shifted = true;
                    numbers[j + 1] = numbers[j];
                } else {
                    numbers[j + 1] = elem;
                    break;
                }
            }

            if (shifted) {
                shiftCount++;
            }
        }

        System.out.println(shiftCount);
    }
}