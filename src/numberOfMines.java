public class numberOfMines {
    public int[][] nOfMines;
    public  numberOfMines(int numRows, int numCols) {
        nOfMines = new int[numRows][numCols];
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                nOfMines[i][j] = 0;
//            }
//        }
    }

    public int[][] getnOfMines() {
        return nOfMines;
    }

    public void setnOfMines(int row, int col, int value) {
        nOfMines[row][col] = value;
    }
}
