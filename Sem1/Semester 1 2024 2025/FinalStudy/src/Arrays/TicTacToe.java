/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arrays;

import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<char[][]> boards = new ArrayList<>();

        // Read input
        while (scanner.hasNextLine()) {
            char[][] board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                board[i] = scanner.nextLine().toCharArray();
            }
            boards.add(board);
            if (scanner.hasNextLine() && scanner.nextLine().equals("#")) {
                break;
            }
        }

        // Evaluate each board
        for (char[][] board : boards) {
            String result = evaluateBoard(board);
            System.out.println(result);
        }
    }

    private static String evaluateBoard(char[][] board) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] == 'X') return "X";
                if (board[i][0] == 'O') return "O";
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] == 'X') return "X";
                if (board[0][i] == 'O') return "O";
            }
        }

        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == 'X') return "X";
            if (board[0][0] == 'O') return "O";
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2] == 'X') return "X";
            if (board[0][2] == 'O') return "O";
        }

        // Check for draw or ongoing game
        boolean isDraw = true;
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == '.') {
                    isDraw = false;
                    break;
                }
            }
        }

        return isDraw ? "Draw" : "None (ongoing)";
    }
}
