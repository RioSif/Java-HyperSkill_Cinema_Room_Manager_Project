import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int varia;
        int shipped = 0;
        int fixed = 0;
        int rejected = 0;
        for (int i = 0; i < n; i++) {
            varia = sc.nextInt();
            switch (varia) {
                case 1:
                    fixed++;
                    break;
                case -1:
                    rejected++;
                    break;
                case 0:
                    shipped++;
                    break;
                default:
                    break;    
            }

        }

        System.out.print(shipped + " " + fixed + " " + rejected);


    }
}
