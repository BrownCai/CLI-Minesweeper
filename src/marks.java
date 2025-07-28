public class marks {
    public char marks[][];//show if the mine is clicked or if it contains flag

    public marks (int numRows, int numCols) {
        marks = new char[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                marks[i][j] = '-';
            }
        }
    }

    public char[][] getMarks() {
        return marks;
    }

    public void setMarks(int row, int col, char value) {
        marks[row][col] = value;
    }


}
