import java.util.Random;
import java.util.Stack;

public class MineField {
    private int numRows;
    private int numColumn;
    private field myfield;
    private marks mymarks;
    private numberOfMines mynumberofMine;
    private boolean touchedMine;
    private boolean fieldClear;
    private Stack<Integer> rowStack;
    private Stack<Integer> colStack;
    private int counterOfOpened;
    private int targetMines;

    public MineField(String level) {
        switch (level) {
            case "easy":
                this.numRows = 10;
                this.numColumn = 10;
                break;
            case "normal":
                this.numRows = 15;
                this.numColumn = 15;
                break;
            case "difficult":
                this.numRows = 20;
                this.numColumn = 20;
                break;
        }
        initialize(numRows, numColumn);
        // Place random number of mines
        Random random = new Random();
        int minesPlaced = 0;
        int totalCells = numRows * numColumn;
        targetMines = random.nextInt(totalCells/4); // Random number of mines
        while (minesPlaced < targetMines) {
            int row = random.nextInt(numRows);
            int col = random.nextInt(numColumn);
            if ( ! myfield.getField()[row][col]) {
                myfield.setField(row, col, true);
                minesPlaced++;
            }
        }

        int counter = 0;
        for (int i=0; i<numRows; i++){
            for (int j=0; j<numColumn; j++){
                if (!myfield.getField()[i][j]) {
                    if (i == 0) {
                        if (j == 0) {
                            if (myfield.getField()[i][j + 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i + 1][j]) {
                                counter++;
                            }
                            if (myfield.getField()[i + 1][j + 1]) {
                                counter++;
                            }
                        } else if (j == numColumn - 1) {
                            if (myfield.getField()[i][j - 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i + 1][j - 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i + 1][j]) {
                                counter++;
                            }
                        } else {
                            if (myfield.getField()[i][j - 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i][j + 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i + 1][j - 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i + 1][j]) {
                                counter++;
                            }
                            if (myfield.getField()[i + 1][j + 1]) {
                                counter++;
                            }
                        }
                    } else if (i == numRows - 1) {
                        if (j == 0) {
                            if (myfield.getField()[i][j + 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i - 1][j]) {
                                counter++;
                            }
                            if (myfield.getField()[i - 1][j + 1]) {
                                counter++;
                            }
                        } else if (j == numColumn - 1) {
                            if (myfield.getField()[i][j - 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i - 1][j - 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i - 1][j]) {
                                counter++;
                            }
                        } else {
                            if (myfield.getField()[i][j - 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i][j + 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i - 1][j - 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i - 1][j]) {
                                counter++;
                            }
                            if (myfield.getField()[i - 1][j + 1]) {
                                counter++;
                            }
                        }
                    } else if (j == 0) {
                        if (i == 0) {
                            if (myfield.getField()[i][j + 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i + 1][j]) {
                                counter++;
                            }
                            if (myfield.getField()[i + 1][j + 1]) {
                                counter++;
                            }
                        } else if (i == numRows - 1) {
                            if (myfield.getField()[i][j + 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i - 1][j]) {
                                counter++;
                            }
                            if (myfield.getField()[i - 1][j + 1]) {
                                counter++;
                            }
                        } else {
                            if (myfield.getField()[i - 1][j]) {
                                counter++;
                            }
                            if (myfield.getField()[i - 1][j + 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i][j + 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i + 1][j]) {
                                counter++;
                            }
                            if (myfield.getField()[i + 1][j + 1]) {
                                counter++;
                            }
                        }
                    } else if (j == numColumn - 1) {
                        if (i == 0) {
                            if (myfield.getField()[i][j - 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i + 1][j - 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i + 1][j]) {
                                counter++;
                            }
                        } else if (i == numRows - 1) {
                            if (myfield.getField()[i][j - 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i - 1][j - 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i - 1][j]) {
                                counter++;
                            }
                        } else {
                            if (myfield.getField()[i - 1][j - 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i - 1][j]) {
                                counter++;
                            }
                            if (myfield.getField()[i][j - 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i + 1][j - 1]) {
                                counter++;
                            }
                            if (myfield.getField()[i + 1][j]) {
                                counter++;
                            }
                        }
                    } else {
                        if (myfield.getField()[i - 1][j - 1]) {
                            counter++;
                        }
                        if (myfield.getField()[i - 1][j]) {
                            counter++;
                        }
                        if (myfield.getField()[i - 1][j + 1]) {
                            counter++;
                        }
                        if (myfield.getField()[i][j - 1]) {
                            counter++;
                        }
                        if (myfield.getField()[i][j + 1]) {
                            counter++;
                        }
                        if (myfield.getField()[i + 1][j - 1]) {
                            counter++;
                        }
                        if (myfield.getField()[i + 1][j]) {
                            counter++;
                        }
                        if (myfield.getField()[i + 1][j + 1]) {
                            counter++;
                        }
                    }
                    mynumberofMine.setnOfMines(i,j,counter);
                    counter=0;
                } else if (myfield.getField()[i][j]) {
                    mynumberofMine.setnOfMines(i,j,9);
                }
            }
        }

    }

    public void initialize(int numRows, int numColumn){
        this.myfield = new field(numRows,numColumn);
        this.mymarks = new marks(numRows,numColumn);
        this.mynumberofMine = new numberOfMines(numRows,numColumn);
        this.touchedMine = false;
        this.fieldClear = false;
        this.counterOfOpened = 0;
        this.rowStack = new Stack<>();
        this.colStack = new Stack<>();
    }

    public void input(int inputy, int inputx){
        if ((this.mymarks.getMarks()[inputy][inputx] == '-') && (this.mynumberofMine.getnOfMines()[inputy][inputx] != 0) && (!myfield.getField()[inputy][inputx])) {
            this.mymarks.setMarks(inputy, inputx, '+');
        } else if ((this.mymarks.getMarks()[inputy][inputx] == '-') && (myfield.getField()[inputy][inputx])) {
            touchedMine = true;
        } else if ((this.mynumberofMine.getnOfMines()[inputy][inputx] == 0)&&(this.mymarks.getMarks()[inputy][inputx] != '#')) {
            this.mymarks.setMarks(inputy, inputx, '+');
            pushStack(inputy, inputx);
            clearStack();
        } else if (this.mymarks.getMarks()[inputy][inputx] == '#'){
            System.out.println("#############################################################");
            System.out.println("Box at Colum"+(inputx+1)+" Row"+(inputy+1)+" can't be opened since it has been flagged!");
        }
    }
    public void flag(int inputy, int inputx){
        if (this.mymarks.getMarks()[inputy][inputx] == '-'){
            this.mymarks.setMarks(inputy, inputx, '#');
        } else if (this.mymarks.getMarks()[inputy][inputx] == '#') {
            this.mymarks.setMarks(inputy, inputx, '-');
        }
    }

    public void clearStack(){
        while (!rowStack.isEmpty()){
            input(rowStack.pop(), colStack.pop());
        }
    }

    public void pushStack(int inputy, int inputx){
        if (inputy==0){
            if (inputx==0){
                if (this.mymarks.getMarks()[inputy][inputx + 1] == '-') {
                    rowStack.push(inputy);
                    colStack.push((inputx + 1));
                    this.mymarks.setMarks(inputy, (inputx + 1), '+');
                }
                if (this.mymarks.getMarks()[inputy + 1][inputx] == '-') {
                    rowStack.push((inputy + 1));
                    colStack.push(inputx);
                    this.mymarks.setMarks((inputy + 1), inputx, '+');
                }
                if (this.mymarks.getMarks()[inputy + 1][inputx + 1] == '-') {
                    rowStack.push((inputy + 1));
                    colStack.push((inputx + 1));
                    this.mymarks.setMarks((inputy + 1), (inputx + 1), '+');
                }
            } else if (inputx==numColumn-1){
                if (this.mymarks.getMarks()[inputy][inputx-1]=='-') {
                    rowStack.push(inputy);
                    colStack.push((inputx-1));
                    this.mymarks.setMarks(inputy, (inputx-1), '+');
                }
                if (this.mymarks.getMarks()[inputy+1][inputx-1]=='-') {
                    rowStack.push((inputy+1));
                    colStack.push((inputx-1));
                    this.mymarks.setMarks((inputy+1), (inputx-1), '+');
                }
                if (this.mymarks.getMarks()[inputy+1][inputx]=='-') {
                    rowStack.push((inputy+1));
                    colStack.push(inputx);
                    this.mymarks.setMarks((inputy+1), inputx, '+');
                }
            } else{
                if (this.mymarks.getMarks()[inputy][inputx - 1] == '-') {
                    rowStack.push(inputy);
                    colStack.push((inputx - 1));
                    this.mymarks.setMarks(inputy, (inputx - 1), '+');
                }
                if (this.mymarks.getMarks()[inputy][inputx + 1] == '-') {
                    rowStack.push(inputy);
                    colStack.push((inputx + 1));
                    this.mymarks.setMarks(inputy, (inputx + 1), '+');
                }
                if (this.mymarks.getMarks()[inputy + 1][inputx-1] == '-') {
                    rowStack.push((inputy + 1));
                    colStack.push((inputx-1));
                    this.mymarks.setMarks((inputy + 1), (inputx-1), '+');
                }
                if (this.mymarks.getMarks()[inputy + 1][inputx] == '-') {
                    rowStack.push((inputy + 1));
                    colStack.push(inputx);
                    this.mymarks.setMarks((inputy + 1), inputx, '+');
                }
                if (this.mymarks.getMarks()[inputy + 1][inputx + 1] == '-') {
                    rowStack.push((inputy + 1));
                    colStack.push((inputx + 1));
                    this.mymarks.setMarks((inputy + 1), (inputx + 1), '+');
                }
            }
        }
        else if (inputy==numRows-1){
            if (inputx==0){
                if (this.mymarks.getMarks()[inputy-1][inputx]=='-') {
                    rowStack.push((inputy-1));
                    colStack.push(inputx);
                    this.mymarks.setMarks((inputy-1), inputx, '+');
                }
                if (this.mymarks.getMarks()[inputy-1][inputx+1]=='-') {
                    rowStack.push((inputy-1));
                    colStack.push((inputx+1));
                    this.mymarks.setMarks((inputy-1), (inputx+1), '+');
                }
                if (this.mymarks.getMarks()[inputy][inputx+1]=='-') {
                    rowStack.push(inputy);
                    colStack.push((inputx+1));
                    this.mymarks.setMarks(inputy, (inputx+1), '+');
                }
            } else if (inputx==numColumn-1) {
                if (this.mymarks.getMarks()[inputy-1][inputx-1]=='-') {
                    rowStack.push((inputy - 1));
                    colStack.push((inputx - 1));
                    this.mymarks.setMarks((inputy-1), (inputx-1), '+');
                }
                if (this.mymarks.getMarks()[inputy-1][inputx]=='-') {
                    rowStack.push((inputy-1));
                    colStack.push(inputx);
                    this.mymarks.setMarks((inputy-1), inputx, '+');
                }
                if (this.mymarks.getMarks()[inputy][inputx-1]=='-') {
                    rowStack.push(inputy);
                    colStack.push((inputx-1));
                    this.mymarks.setMarks(inputy, (inputx-1), '+');
                }
            }
            else {
                if (this.mymarks.getMarks()[inputy-1][inputx-1]=='-') {
                    rowStack.push((inputy-1));
                    colStack.push((inputx-1));
                    this.mymarks.setMarks((inputy-1), (inputx-1), '+');
                }
                if (this.mymarks.getMarks()[inputy-1][inputx]=='-') {
                    rowStack.push((inputy-1));
                    colStack.push(inputx);
                    this.mymarks.setMarks((inputy-1), inputx, '+');
                }
                if (this.mymarks.getMarks()[inputy-1][inputx+1]=='-') {
                    rowStack.push((inputy-1));
                    colStack.push((inputx+1));
                    this.mymarks.setMarks((inputy-1), (inputx+1), '+');
                }
                if (this.mymarks.getMarks()[inputy][inputx-1]=='-') {
                    rowStack.push((inputy));
                    colStack.push((inputx-1));
                    this.mymarks.setMarks(inputy, (inputx-1), '+');
                }
                if (this.mymarks.getMarks()[inputy][inputx+1]=='-') {
                    rowStack.push(inputy);
                    colStack.push((inputx+1));
                    this.mymarks.setMarks(inputy, (inputx+1), '+');
                }
            }
        }
        else if (inputx==0){
            if (inputy==0){
                if (this.mymarks.getMarks()[inputy][inputx + 1] == '-') {
                    rowStack.push(inputy);
                    colStack.push((inputx + 1));
                    this.mymarks.setMarks(inputy, (inputx + 1), '+');
                }
                if (this.mymarks.getMarks()[inputy + 1][inputx] == '-') {
                    rowStack.push((inputy + 1));
                    colStack.push(inputx);
                    this.mymarks.setMarks((inputy + 1), inputx, '+');
                }
                if (this.mymarks.getMarks()[inputy + 1][inputx + 1] == '-') {
                    rowStack.push((inputy + 1));
                    colStack.push((inputx + 1));
                    this.mymarks.setMarks((inputy + 1), (inputx + 1), '+');
                }
            } else if (inputy==numRows-1) {
                if (this.mymarks.getMarks()[inputy-1][inputx]=='-') {
                    rowStack.push((inputy-1));
                    colStack.push(inputx);
                    this.mymarks.setMarks((inputy-1), inputx, '+');
                }
                if (this.mymarks.getMarks()[inputy-1][inputx+1]=='-') {
                    rowStack.push((inputy-1));
                    colStack.push((inputx+1));
                    this.mymarks.setMarks((inputy-1), (inputx+1), '+');
                }
                if (this.mymarks.getMarks()[inputy][inputx+1]=='-') {
                    rowStack.push(inputy);
                    colStack.push((inputx+1));
                    this.mymarks.setMarks(inputy, (inputx+1), '+');
                }
            } else {
                if (this.mymarks.getMarks()[inputy-1][inputx]=='-') {
                    rowStack.push((inputy-1));
                    colStack.push(inputx);
                    this.mymarks.setMarks((inputy-1), inputx, '+');
                }
                if (this.mymarks.getMarks()[inputy-1][inputx+1]=='-') {
                    rowStack.push((inputy-1));
                    colStack.push((inputx+1));
                    this.mymarks.setMarks((inputy-1), (inputx+1), '+');
                }
                if (this.mymarks.getMarks()[inputy][inputx+1]=='-') {
                    rowStack.push(inputy);
                    colStack.push(inputx+1);
                    this.mymarks.setMarks(inputy, inputx+1, '+');
                }
                if (this.mymarks.getMarks()[inputy+1][inputx]=='-') {
                    rowStack.push((inputy+1));
                    colStack.push(inputx);
                    this.mymarks.setMarks((inputy+1), inputx, '+');
                }
                if (this.mymarks.getMarks()[inputy+1][inputx+1]=='-') {
                    rowStack.push(inputy+1);
                    colStack.push(inputx+1);
                    this.mymarks.setMarks(inputy+1, inputx+1, '+');
                }
            }
        }
        else if (inputx==numColumn-1){
            if (inputy==0){
                if (this.mymarks.getMarks()[inputy][inputx-1]=='-') {
                    rowStack.push(inputy);
                    colStack.push((inputx-1));
                    this.mymarks.setMarks(inputy, (inputx-1), '+');
                }
                if (this.mymarks.getMarks()[inputy+1][inputx-1]=='-') {
                    rowStack.push((inputy+1));
                    colStack.push((inputx-1));
                    this.mymarks.setMarks((inputy+1), (inputx-1), '+');
                }
                if (this.mymarks.getMarks()[inputy+1][inputx]=='-') {
                    rowStack.push((inputy+1));
                    colStack.push(inputx);
                    this.mymarks.setMarks((inputy+1), inputx, '+');
                }
            } else if (inputy==numRows-1) {
                if (this.mymarks.getMarks()[inputy-1][inputx-1]=='-') {
                    rowStack.push((inputy - 1));
                    colStack.push((inputx - 1));
                    this.mymarks.setMarks((inputy-1), (inputx-1), '+');
                }
                if (this.mymarks.getMarks()[inputy-1][inputx]=='-') {
                    rowStack.push((inputy-1));
                    colStack.push(inputx);
                    this.mymarks.setMarks((inputy-1), inputx, '+');
                }
                if (this.mymarks.getMarks()[inputy][inputx-1]=='-') {
                    rowStack.push(inputy);
                    colStack.push((inputx-1));
                    this.mymarks.setMarks(inputy, (inputx-1), '+');
                }
            } else {
                if (this.mymarks.getMarks()[inputy-1][inputx-1]=='-') {
                    rowStack.push(inputy - 1);
                    colStack.push(inputx - 1);
                    this.mymarks.setMarks(inputy-1, inputx-1, '+');
                }
                if (this.mymarks.getMarks()[inputy-1][inputx]=='-') {
                    rowStack.push(inputy-1);
                    colStack.push(inputx);
                    this.mymarks.setMarks(inputy-1, inputx, '+');
                }
                if (this.mymarks.getMarks()[inputy][inputx-1]=='-') {
                    rowStack.push(inputy);
                    colStack.push(inputx-1);
                    this.mymarks.setMarks(inputy, inputx-1, '+');
                }
                if (this.mymarks.getMarks()[inputy+1][inputx-1]=='-') {
                    rowStack.push(inputy + 1);
                    colStack.push(inputx - 1);
                    this.mymarks.setMarks(inputy+1, inputx-1, '+');
                }
                if (this.mymarks.getMarks()[inputy+1][inputx]=='-') {
                    rowStack.push(inputy+1);
                    colStack.push(inputx);
                    this.mymarks.setMarks(inputy+1, inputx, '+');
                }
            }
        }
        else{
            if (this.mymarks.getMarks()[inputy-1][inputx-1]=='-') {
                rowStack.push(inputy - 1);
                colStack.push(inputx - 1);
                this.mymarks.setMarks(inputy-1, inputx-1, '+');
            }
            if (this.mymarks.getMarks()[inputy-1][inputx]=='-') {
                rowStack.push(inputy-1);
                colStack.push(inputx);
                this.mymarks.setMarks(inputy-1, inputx, '+');
            }
            if (this.mymarks.getMarks()[inputy-1][inputx+1]=='-') {
                rowStack.push(inputy-1);
                colStack.push(inputx+1);
                this.mymarks.setMarks(inputy-1, inputx+1, '+');
            }
            if (this.mymarks.getMarks()[inputy][inputx-1]=='-') {
                rowStack.push(inputy);
                colStack.push(inputx-1);
                this.mymarks.setMarks(inputy, inputx-1, '+');
            }
            if (this.mymarks.getMarks()[inputy][inputx+1]=='-') {
                rowStack.push(inputy);
                colStack.push(inputx+1);
                this.mymarks.setMarks(inputy, inputx+1, '+');
            }
            if (this.mymarks.getMarks()[inputy+1][inputx-1]=='-') {
                rowStack.push(inputy+1);
                colStack.push(inputx-1);
                this.mymarks.setMarks(inputy+1, inputx-1, '+');
            }
            if (this.mymarks.getMarks()[inputy+1][inputx]=='-') {
                rowStack.push(inputy+1);
                colStack.push(inputx);
                this.mymarks.setMarks(inputy+1, inputx, '+');
            }
            if (this.mymarks.getMarks()[inputy+1][inputx+1]=='-') {
                rowStack.push(inputy+1);
                colStack.push(inputx+1);
                this.mymarks.setMarks(inputy+1, inputx+1, '+');
            }
        }

    }

    public void display(){
        System.out.println("*****************************************************************");
        if (numColumn==10) {
            System.out.println("   |  1  2  3  4  5  6  7  8  9 10");
            System.out.println("---+-------------------------------");
        }
        else if (numColumn==15){
            System.out.println("   |  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15");
            System.out.println("---+----------------------------------------------");
        }
        else if(numColumn==20){
            System.out.println("   |  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20");
            System.out.println("---+-------------------------------------------------------------");
        }

        if (!touchedMine) {
            for (int i = 0; i < numRows; i++) {

                if(i<=8) {
                    System.out.print(" "+(i+1)+" |  ");
                }
                else{
                    System.out.print((i+1)+" |  ");
                }

                for (int j = 0; j < numColumn; j++) {
                    if (mymarks.getMarks()[i][j] == '-') {
                        System.out.print("-  ");
                    }
                    else if (mymarks.getMarks()[i][j] == '#') {
                        System.out.print("#  ");
                    }
                    else {
                        System.out.print(mynumberofMine.getnOfMines()[i][j] + "  ");
                        counterOfOpened++;
                    }
                }
                System.out.print("\n");
            }
            System.out.println("*****************************************************************");
            if (counterOfOpened==(numColumn*numRows-targetMines)){
                fieldClear=true;
                System.out.println("All mines were found! Field cleared!!");
            }
//            System.out.println(counterOfOpened);
            counterOfOpened=0;
        }
        else {
            for (int i=0; i<numRows; i++){

                if(i<=8) {
                    System.out.print(" "+(i+1)+" |  ");
                }
                else{
                    System.out.print((i+1)+" |  ");
                }

                for (int j = 0; j < numColumn; j++) {
                    if (myfield.getField()[i][j]) {
                        System.out.print("*  ");
                    }
                    else if(mymarks.getMarks()[i][j] == '-') {
                        System.out.print("-  ");
                    }
                    else if (mymarks.getMarks()[i][j] == '#') {
                        System.out.print("#  ");
                    }
                    else {
                        System.out.print(mynumberofMine.getnOfMines()[i][j] + "  ");
                    }
                }
                System.out.print("\n");
            }
            System.out.println("*****************************************************************");
            System.out.println("Mine touched! GameOver!!");
        }
//        for (int i=0; i<numRows; i++){
//            for (int j = 0; j < numColumn; j++) {
//                    System.out.print(this.myfield.getField()[i][j]);
//                    System.out.print(" ");
//                }
//                System.out.print("\n");
//            }
//        System.out.println("***************************************************");
//        for (int i=0; i<numRows; i++){
//            for (int j = 0; j < numColumn; j++) {
//                System.out.print(this.mymarks.getMarks()[i][j]);
//                System.out.print(" ");
//            }
//            System.out.print("\n");
//        }
//        System.out.println("***************************************************");
//        for (int i=0; i<numRows; i++){
//            for (int j = 0; j < numRows; j++) {
//                System.out.print(this.mynumberofMine.getnOfMines()[i][j]);
//                System.out.print(" ");
//            }
//            System.out.print("\n");
//        }
//        System.out.println("***************************************************");
    }
    public boolean getTouchedMine(){
        return touchedMine;
    }
    public boolean getFieldClear(){
        return fieldClear;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumColumn() {
        return numColumn;
    }
}
