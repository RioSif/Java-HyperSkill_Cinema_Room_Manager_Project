//put imports you need here

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        String name = sc.next();
        String age = sc.next();
        String education = sc.next();
        String experience = sc.next();
        String cuisine = sc.next();

        System.out.printf("The form for %s is completed. " +
                "We will contact you if we need a chef that " +
                "cooks %s dishes.", name, cuisine);
    }
}