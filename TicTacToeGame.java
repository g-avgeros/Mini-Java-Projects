package gr.aueb.cf.ch10.projects;

import java.util.Scanner;

public class TicTacToeGame {
    public static final int X = 1, O = -1;
    public static final int EMPTY = 0;

    public static int player = X;
    public static int[][] board = new int[3][3];
    public static int winner = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        initBoard();

        while (winner == 0) {
            printBoard();
            int row, col;
            do {
                System.out.println("Player " + player + ", enter your move (row column): ");
                row = scan.nextInt() - 1;
                col = scan.nextInt() - 1;
            } while (!isValidMove(row, col));

            board[row][col] = player;
            player = -player;
            winner = checkWinner();
        }

        if (winner == X) {
            System.out.println("X wins!");
        } else if (winner == O) {
            System.out.println("O wins!");
        } else {
            System.out.println("Tie game.");
        }
    }

    public static boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        return board[row][col] == EMPTY;
    }

    public static int checkWinner() {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] + board[i][1] + board[i][2] == 3 * X) {
                return X;
            }
            if (board[i][0] + board[i][1] + board[i][2] == 3 * O) {
                return O;
            }
        }

        // check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] + board[1][j] + board[2][j] == 3 * X) {
                return X;
            }
            if (board[0][j] + board[1][j] + board[2][j] == 3 * O) {
                return O;
            }
        }

        // check diagonals
        if (board[0][0] + board[1][1] + board[2][2] == 3 * X ||
                board[0][2] + board[1][1] + board[2][0] == 3 * X) {
            return X;
        }
        if (board[0][0] + board[1][1] + board[2][2] == 3 * O ||
                board[0][2] + board[1][1] + board[2][0] == 3 * O) {
            return O;
        }

        // check if the board is full
        if (isBoardFull()) {
            return -1;
        }

        // game is not over yet
        return 0;
    }
    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (board[i][j]) {
                    case X:
                        System.out.print("X");
                        break;
                    case O:
                        System.out.print("O");
                        break;
                    case EMPTY:
                        System.out.print(" ");
                        break;
                }
                if (j < 2) {
                    System.out.print("|");
                }
            }
            if (i < 2) {
                System.out.println("\n-+-+-");
            }
        }
        System.out.println();
    }
}




