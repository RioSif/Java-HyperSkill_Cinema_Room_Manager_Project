import java.util.Scanner;

public class Main {

    public static long factorial(long n) {
        // write your code here
        long fn = n;
        if (n == 0) {
            fn = 1;
        } else {
            for (long i = n - 1; i >= 1; i--) {
                fn *= i;
            }
        }
        return fn;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Integer.parseInt(scanner.nextLine().trim());
        System.out.println(factorial(n));
    }
}