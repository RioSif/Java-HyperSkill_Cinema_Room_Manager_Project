import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int[] arrayA = new int[3];
        int[] arrayB = new int[3];

        for (int i = 0; i < 3; i++) {
            arrayA[i] = sc.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            arrayB[i] = sc.nextInt();
        }

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        String result = "Incompatible";

        if (arrayA[0] > arrayB[0] && arrayA[1] > arrayB[1] && arrayA[2] > arrayB[2]) {
            result = "Box 1 > Box 2";
        } else if (arrayA[0] < arrayB[0] && arrayA[1] < arrayB[1] && arrayA[2] < arrayB[2]) {
            result = "Box 1 < Box 2";
        }

        System.out.println(result);
    }
}