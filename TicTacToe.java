package gr.aueb.cf.ch10.projects;
import java.util.Scanner;

public class TicTacToe {

    // Constants for the game board
    public static final int ROWS = 3;
    public static final int COLUMNS = 3;

    // Constants for the players
    public static final char PLAYER_X = 'X';
    public static final char PLAYER_O = 'O';

    // 2D array to represent the game board
    private char[][] board;

    // Constructor to initialize the game board
    public TicTacToe() {
        board = new char[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Method to display the game board
    public void displayBoard() {
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }

    // Method to check if the game is a draw
    public boolean isDraw() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Method to check if the player has won
    public boolean hasWon(char player) {
        // Check rows
        for (int i = 0; i < ROWS; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < COLUMNS; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    // Method to check if the move is valid
    public boolean booleanisValidMove(int row, int column) {
        if (row >= 0 && row < ROWS && column >= 0 && column < COLUMNS && board[row][column] == ' ') {
            return true;
        }
        return false;
    }

// Method to play the game
public void playGame() {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = PLAYER_X;
        boolean gameOver = false;

        while (!gameOver) {
        // Display the game board
        displayBoard();

        // Get the row and column from the player
        System.out.print("Player " + currentPlayer + ", enter your move (row column): ");
        int row = scanner.nextInt();
        int column = scanner.nextInt();

        // Check if the move is valid
        if (isValidMove(row, column)) {
        // Update the game board with the player's move
        board[row][column] = currentPlayer;

        // Check if the player has won
        if (hasWon(currentPlayer)) {
        System.out.println("Player " + currentPlayer + " has won!");
        gameOver = true;
        } else if (isDraw()) {
        System.out.println("The game is a draw!");
        gameOver = true;
        } else {
        // Switch to the other player
        if (currentPlayer == PLAYER_X) {
        currentPlayer = PLAYER_O;
        } else {
        currentPlayer = PLAYER_X;
        }
        }
        } else {
        System.out.println("Invalid move. Try again.");
        }
        }
        }

    private boolean isValidMove(int row, int column) {
        return false;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
        }
        }
