import java.util.Scanner;

public class main {
    private static MineField testMine;
    private static boolean touchedMine;
    private static boolean fieldClear;
    private static String newlevel;
    private static int numRows;
    private static int numCols;
    private static int inputx;
    private static int inputy;

    public static void main(String[] args) {

        System.out.println("Welcome to Minesweeper!");
        System.out.println("Legend:");
        System.out.println("- : not opened");
        System.out.println("# : flagged");
        System.out.println("* : mine (if game overed)");
        System.out.println("Numbers indicate the number of mines adjacent to that square.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your difficulty level: easy, normal, difficult");
        System.out.print("Enter the level: ");
        newlevel = scanner.next();
        while ((!newlevel.equals("easy"))||(!newlevel.equals("easy"))||(!newlevel.equals("easy"))){
            System.out.print("Spelling error! Please type again: ");
            newlevel = scanner.next();
        }
        testMine = new MineField(newlevel);
        numCols = testMine.getNumColumn();
        numRows = testMine.getNumRows();
        touchedMine = testMine.getTouchedMine();
        fieldClear = testMine.getFieldClear();
        while ((!touchedMine)&&(!fieldClear)) {
            System.out.print("Enter the number of column: ");
            inputx = scanner.nextInt() - 1;
            while ((inputx<0)||(inputx>numCols-1)){
                System.out.print("Out of boundary! Please input again: ");
                inputx = scanner.nextInt() - 1;
            }
            System.out.print("Enter the number of row: ");
            inputy = scanner.nextInt() - 1;
            while ((inputy<0)||(inputy>numRows-1)){
                System.out.print("Out of boundary! Please input again: ");
                inputy = scanner.nextInt() - 1;
            }
            System.out.println("Open or Flag?");
            System.out.print(" Type \"1\" to open or \"0\" to flag/unflag: ");
            int mode = scanner.nextInt();
            if (mode==1){
                testMine.input(inputy, inputx);
            } else {
                testMine.flag(inputy,inputx);
            }
            testMine.display();
            System.out.println();
            touchedMine = testMine.getTouchedMine();
            fieldClear = testMine.getFieldClear();
        }
    }

}
