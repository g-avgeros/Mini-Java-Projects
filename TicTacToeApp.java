package gr.aueb.cf.ch10.projects;

public class TicTacToeApp {

    public static void main(String[] args) {
        char[][] board = new char[3][3];
    }

    public void board() {
        char[][] board = new char[0][0];
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }
}
