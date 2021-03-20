package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatspr = sc.nextInt();
        int row = -1;
        int seatNumber = -1;

        printSeats(rows, seatspr, row, seatNumber);

        System.out.println("Enter a row number: ");
        row = sc.nextInt() - 1;
        System.out.println("Enter a seat number in that row: ");
        seatNumber = sc.nextInt() - 1;

        printSeats(rows, seatspr, row, seatNumber);
        calcPrice(rows, seatspr, row);
    }

    private static void printSeats(int rows, int seatspr, int row, int seatNumber){
        String[][] seats = new String[rows][seatspr];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatspr; j++){
                seats[i][j] = "S ";
            }
        }
        if (row >= 0 && seatNumber >= 0) {
            seats[row][seatNumber] = "B ";
        }

        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 0; i < seatspr; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println("");
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seatspr; j++) {
                System.out.print(seats[i][j]);
            }
            System.out.println("");
        }
    }

    private static void calcPrice(int rows, int seatspr, int row) {
        int roomseats = rows * seatspr;
        int ticketprice;
        if (roomseats <= 60) {
            ticketprice = 10;
        } else {
            ticketprice = (row < rows / 2 ? 10 : 8);
        }
        System.out.println("Ticket price: $" + ticketprice);
    }
}