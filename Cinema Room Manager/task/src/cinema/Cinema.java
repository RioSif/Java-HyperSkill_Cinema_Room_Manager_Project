package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        int row = -1;
        int seatNumber = -1;
        int ticketsSold = 0;
        int currentIncome = 0;
        int totalIncome = 0;
        float percentage = 0;


        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatspr = sc.nextInt();

        String[][] seats = new String[rows][seatspr];

        initSeats(rows, seatspr, seats);

        showMenu();

        boolean exit = false;
        while (!exit) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    showSeats(rows, seatspr, row, seatNumber, seats);
                    showMenu();
                    break;
                case 2:
                    buyTicket(rows, seatspr, row, seatNumber, seats);
                    showMenu();
                    break;
                case 3:
                    viewStatistics(seats, rows, seatspr, ticketsSold, percentage, currentIncome, totalIncome);
                    showMenu();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    continue;
            }
        }
    }

    private static void viewStatistics(String[][] seats, int rows, int seatspr, int ticketsSold, double percentage, int currentIncome, int totalIncome) {
        if (rows * seatspr < 60) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < seatspr; j++) {
                    if (seats[i][j] == "B") {
                        ticketsSold++;
                        currentIncome += 10;
                    }
                }
            }
            totalIncome = rows * seatspr * 10;
        } else {
            for (int i = 0; i < rows / 2; i++) {
                for (int j = 0; j < seatspr; j++) {
                    if (seats[i][j] == "B") {
                        ticketsSold++;
                        currentIncome += 10;
                    }
                }
            }
            for (int i = rows / 2; i < rows; i++) {
                for (int j = 0; j < seatspr; j++) {
                    if (seats[i][j] == "B") {
                        ticketsSold++;
                        currentIncome += 8;
                    }
                }
            }
            totalIncome = (rows / 2) * seatspr * 10 + (rows - (rows / 2)) * seatspr * 8;
        }

        percentage = (float) ticketsSold * 100 / (rows * seatspr) ;

        System.out.println("Number of purchased tickets: " + ticketsSold);
        System.out.printf("Percentage: %.2f%s\n", percentage, "%");
        System.out.println("Current Income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }

    private static void showMenu() {
        System.out.println("");
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void initSeats(int rows, int seatspr, String seats[][]) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatspr; j++) {
                seats[i][j] = "S";
            }
        }
    }

    private static void showSeats(int rows, int seatspr, int row, int seatNumber, String seats[][]){
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 0; i < seatspr; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println("");
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seatspr; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println("");
        }

    }

    private static void buyTicket(int rows, int seatspr, int row, int seatNumber, String[][] seats){
        Scanner sc = new Scanner(System.in);
        boolean freeSeat = false;
        while (!freeSeat) {
            System.out.println("Enter a row number: ");
            row = sc.nextInt() - 1;
            System.out.println("Enter a seat number in that row: ");
            seatNumber = sc.nextInt() - 1;
            if (row >= rows || seatNumber >= seatspr) {
                System.out.println("Wrong input!");
            } else if (seats[row][seatNumber] == "B") {
                System.out.println("That ticket has already been purchased!");
            } else {
                seats[row][seatNumber] = "B";
                calcPrice(rows, seatspr, row);
                freeSeat = true;
            }
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