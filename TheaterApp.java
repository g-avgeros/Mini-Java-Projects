package gr.aueb.cf.ch10.projects;

import java.util.Scanner;

public class TheaterApp {
    public static final int NUM_ROWS = 30;
    public static final int NUM_SEATS_PER_ROW = 12;

    public static char[][] seats = new char[NUM_ROWS][NUM_SEATS_PER_ROW];
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        initSeats();

        while (true) {
            System.out.println("Enter command (book, check, cancel, availability, exit): ");
            String command = scan.next();

            if (command.equals("exit")) {
                break;
            }

            if (command.equals("book")) {
                bookSeat();
            } else if (command.equals("check")) {
                checkSeat();
            } else if (command.equals("cancel")) {
                cancelSeat();
            } else if (command.equals("availability")) {
                checkAvailability();
            } else {
                System.out.println("Invalid command.");
            }
        }
    }

    public static void initSeats() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_SEATS_PER_ROW; j++) {
                seats[i][j] = '.';
            }
        }
    }

    // Method to book a seat
    public static void bookSeat() {
        System.out.println("Enter seat row and column: ");
        int row = scan.nextInt();
        int col = scan.nextInt();

        if (seats[row][col] != '.') {
            System.out.println("Seat is already booked.");
            return;
        }

        seats[row][col] = 'B';
        System.out.println("Seat booked successfully.");
    }

    // Method to check a seat
    public static void checkSeat() {
        System.out.println("Enter seat row and column: ");
        int row = scan.nextInt();
        int col = scan.nextInt();

        if (seats[row][col] == '.') {
            System.out.println("Seat is available.");
        } else {
            System.out.println("Seat is booked.");
        }
    }

    // Method to cancel a seat
    public static void cancelSeat() {
        System.out.println("Enter seat row and column: ");
        int row = scan.nextInt();
        int col = scan.nextInt();

        if (seats[row][col] == '.') {
            System.out.println("Seat is already available.");
            return;
        }

        seats[row][col] = '.';
        System.out.println("Booking cancelled successfully.");
    }


    // Method to check availability
    public static void checkAvailability() {
        int availableSeats = 0;
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_SEATS_PER_ROW; j++) {
                if (seats[i][j] == '.') {

                    availableSeats++;
                }
            }
        }
        System.out.println("Number of available seats: " + availableSeats);
    }
}

