public class NQueensAllConfigurations {
    static void getQueenPosition(int boardSize) {
        int board[][] = new int[boardSize][boardSize];
        placeQueens(board, 0, 0, boardSize);
        printBoard(board);
    }

    static void printBoard(int[][] board) {
        for (int row[] : board) {
            // System.out.println("\n_______________________________");
            System.out.println();
            for (int col : row) {
                System.out.print((col == 0 ? "+" : "Q") + " | ");
            }
        }
    }

    static boolean checkDiagonal(int board[][], int row, int col) {
        int rowC = row;
        int colC = col;
        while (row < board.length && col < board.length) {
            if (board[row++][col++] != 0) {
                return false;
            }
        }
        row = rowC;
        col = colC;
        while (row >= 0 && col >= 0) {
            if (board[row--][col--] != 0) {
                return false;
            }
        }
        row = rowC;
        col = colC;
        while (row > 0 && col < board.length) {
            if (board[row--][col++] != 0) {
                return false;
            }
        }
        row = rowC;
        col = colC;
        while (row < board.length && col >= 0) {
            if (board[row++][col--] != 0) {
                return false;
            }
        }

        return true;
    }

    static boolean checkHorizontal(int board[][], int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != 0) {
                return false;
            }
        }
        return true;
    }

    static boolean checkVertical(int board[][], int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isSafe(int board[][], int row, int col) {
        if (row >= 0 && col >= 0 && row < board.length && col < board.length) {
            if (checkDiagonal(board, row, col) == true && checkHorizontal(board, row, col) == true
                    && checkVertical(board, row, col) == true) {
                return true;
            }

        }
        return false;
    }

    static boolean placeQueens(int board[][], int col, int row, int n) {
        if (col >= n && row >= n) {
            printBoard(board);
            return true;
        }
        if (isSafe(board, row, col)) {
            board[row][col] = 1;
            if (placeQueens(board, col + 1, row, n)) {
                return true;
            }
            board[row][col] = 0;
            placeQueens(board, col, row + 1, n);
        }
        return false;
    }

    public static void main(String[] args) {
        int board = 8;
        getQueenPosition(board);
    }
}
// Output
// Q | + | + | + | + | + | + | + |
// + | + | + | + | + | + | Q | + |
// + | + | + | + | Q | + | + | + |
// + | + | + | + | + | + | + | Q |
// + | Q | + | + | + | + | + | + |
// + | + | + | Q | + | + | + | + |
// + | + | + | + | + | Q | + | + |
// + | + | Q | + | + | + | + | + |