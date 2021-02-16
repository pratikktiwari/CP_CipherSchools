public class KnightTour {
    static int totalCounter = 0;

    static void knightTour(int row, int col) {
        int board[][] = new int[8][8];
        tour(board, row, col, 0);
        System.out.println("\n\nTotal tour : " + totalCounter);
    }

    static boolean isValidMove(int board[][], int row, int col) {
        if (row >= 0 && col >= 0 && row < board.length && col < board[0].length && board[row][col] == 0)
            return true;
        return false;
    }

    static int directionV[][] = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { -1, 2 },
            { 1, 2 } };

    static void tour(int[][] board, int row, int col, int count) {
        if (count == board.length * board.length) {
            return;
        }
        for (int i = 0; i < directionV.length; i++) {

            int nRow = row + directionV[i][0];
            int nCol = col + directionV[i][1];

            if (isValidMove(board, nRow, nCol)) {
                System.out.print("[" + nRow + "][" + nCol + "]   ");
                board[nRow][nCol] = 1;
                totalCounter++;
                tour(board, nRow, nCol, count + 1);
            }
        }
    }

    public static void main(String[] args) {
        int initial_row = 0;
        int initial_col = 0;

        knightTour(initial_row, initial_col);
    }
}
