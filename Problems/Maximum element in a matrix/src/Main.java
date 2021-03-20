import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        int row = sc.nextInt();

        int[][] array = new int[col][row];
        int max = 0;
        int c = 0;
        int r = 0;

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                array[i][j] = sc.nextInt();
                if (max < array[i][j] || i == 0 && j == 0) {
                    max = array[i][j];
                    c = i;
                    r = j;
                }
            }
        }

        System.out.println(c + " " + r);

    }
}