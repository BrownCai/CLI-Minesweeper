public class field {
    public boolean[][] field;
    public  field(int x, int y) {
        field = new boolean[x][y];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field[i][j] = false;
            }
        }
    }

    public boolean[][] getField() {
        return field;
    }

    public void setField(int row, int col, boolean value) {
        field[row][col]=value;
    }


}
