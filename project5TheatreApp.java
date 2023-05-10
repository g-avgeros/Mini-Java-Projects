package gr.aueb.cf.ch10.projects;

public class project5TheatreApp {

    public static void main(String[] args) {
        boolean book = false;
        boolean cancel = false;

        book('A',1);
        cancel('C',2);

        System.out.println(book);
        System.out.println(cancel);

    }

    public static void book(char column, int row) {
        boolean[][] seats = new boolean[30][12];
        // Βρίσκουμε την στήλη της θέσης
        int col = column - 'A';
        // Ελέγχουμε αν η θέση είναι ήδη κρατημένη
        if (seats[row][col]) {
            System.out.println("Η θέση είναι ήδη κρατημένη.");
        } else {
            // Κρατάμε την θέση
            seats[row][col] = true;
            System.out.println("Η θέση κρατήθηκε με επιτυχία.");
        }
    }

    public static void cancel(char column, int row) {
        boolean[][] seats = new boolean[30][12];
        // Βρίσκουμε την στήλη της θέσης
        int col = column - 'A';
        // Ελέγχουμε αν η θέση είναι ήδη κρατημένη
        if (seats[row][col]) {
            // Ακυρώνουμε την κράτηση
            seats[row][col] = false;
            System.out.println("Η κράτηση ακυρώθηκε με επιτυχία.");
        } else {
            System.out.println("Η θέση δεν είναι κρατημένη.");
        }
    }
}
