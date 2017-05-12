/**
 * Created by Luca on 21/04/2017.
 */
public class Tris {

    //Creating the constructor
    // 3*3 matrix
    private int rows=3;
    private int columns=3;
    String[][] board = new String[rows][columns];
    public Tris(){
        for (int i=0; i<rows;i++)
            for (int j=0;j<columns;j++){
            board[i][j] = " ";
            }

    }

    /**
     *
     * @return the state of the board
     */
    public String writeString()
    {
        String r = "";
        for(int i=0; i<rows; i++)
        {
            r = r + "|";
            for (int j=0; j<columns ; j++)
                r=r + board[i][j];
            r = r + "|\n";
        }
        return r;
    }

    //Insert a play
    public void set(int i, int j, String player){
        if(board[i][j]!= " ")
            throw new IllegalArgumentException("Posizione gia` occupata");
        board[i][j]= player;
    }

    public String getWinner(){
        String player;
        //Check the tris on the row
        player = checkHorizontal();

        //Check the tris on the column
        if (player == "") {
            player = checkVertical();
        } else {
            return player;
        }

        //Check the diagonal
        if (player == ""){
            player = checkDiagonal();
        } else {
            return player;
        }

        return player;
    }


    private String checkVertical(){
        return check(columns,rows);
    }

    private String checkHorizontal(){
        return check(rows,columns);
    }


    /**
     *
     * @param row rows in first execution, columns in the second one
     * @param column columns in first execution, rows in the second one
     * @return the name of the player if a winner is found otherwise return the blank
     */
    private String check(int row, int column){
        int win=0;
        String player;
        for (int i =0; i<row; i++){
            player = board[row][0];
            for (int j = 0; j<column; j++){
                if (board[row][column]== player) {
                    win++;
                }
                else {
                    j = columns;
                }
            }
            if (win == columns){
                return player;
            }

        }
        return "";
    }


    private String checkDiagonal(){
        int win = 0;
        String player;
        // Check the left diagonal
        player = board[0][0];
        for (int i=0; i<rows; i++) {
            if (board[i][i] == player) {
                win++;
            } else {
                i = rows;
            }
        }

        if (win == rows){
            return player;
        }

        // Check the right diagonal
        win=0;
        int j=columns-1;
        player = board[0][j];
        for (int i = 0; i<rows; i++) {
            if (board[i][j] == player) {
                win++;
            } else {
               i = rows;
            }
            j--;
        }

        if (win == rows) {
            return player;
        }

        return "";
    }

}