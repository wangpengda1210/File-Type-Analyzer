import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        String[] date = new Scanner(System.in).nextLine().split("-");

        System.out.println(date[1] + "/" + date[2] + "/" + date[0]);
    }
}