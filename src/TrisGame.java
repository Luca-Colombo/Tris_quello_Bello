import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.Scanner;

/**
 * Created by aewwc on 14/05/2017.
 */
public class TrisGame {

    public static void main (String args[]){

        Tris board = new Tris();
        String state;
        //menu
        int choice=0;
        String winner;
        Scanner scanner;
        scanner = new Scanner(System.in);

        while( choice!=3) {
            state=board.writeString();
            System.out.print(state);
            System.out.println("What do you want to do? \n 1. Insert a cross (X) \n 2. Insert a circle (O) \n 3. Know who is the winner");
            choice = scanner.nextInt();
            if (choice == 1) {
                play(1, board);
            }
            if (choice == 2) {
                play(2, board);
            }
            if (choice == 3) {
                winner = board.getWinner();
                System.out.println("And the winner is..... " + winner);
            }
        }

    }

    /**
     * Insert a symbol on the borad game
     * @param choose what symbol do you want to insert
     * @param board the board where to insert the symbol
     */
    private static void play(int choose, Tris board){
        int a,b;
        Scanner scanner;
        scanner = new Scanner(System.in);
        System.out.print("Select the row: ");
        a = scanner.nextInt();
        System.out.print("Select the column: ");
        b = scanner.nextInt();
        if (choose==1)
        board.set(a-1,b-1,"X");
        if (choose==2)
            board.set(a-1,b-1,"O");
    }

}
