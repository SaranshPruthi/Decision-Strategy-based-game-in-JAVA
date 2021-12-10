public class TicTakToe {
    char[][] board;

    public TicTakToe()  {
        board = new char[3][3];
        setDefaults();
    }

    private void setDefaults() {
        for(int x=0;x<3;x++) {
            for(int y=0;y<3;y++) {
                board[x][y] = ' ';
            }
        }
    }
    
    public boolean executePlay(int x, int y, char play) {
        if(board[x][y] == ' ') {
            board[x][y] = play;
            return true;
        }
        return false;
    }

    public char gameOver() {
        // Check for rows
        for(int x=0;x<3;x++) {
            if(board[x][0] == board[x][1] && board[x][0] == board[x][2] && board[x][0] != ' ')
                return board[x][0];
        }
        // Check for columns
        for(int y=0;y<3;y++) {
            if(board[0][y] == board[1][y] && board[0][y] == board[2][y] && board[0][y] != ' ')
                return board[0][y];
        }

        // Diagonals
        if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != ' ')
            return board[1][1];
        
        if(board[2][0] == board[1][1] && board[2][0] == board[0][2] && board[2][0] != ' ')
            return board[1][1];
        
        for(int x=0;x<3;x++) {
            for(int y=0;y<3;y++) {
                if(board[x][y] == ' ')
                    return ' ';
            }
        }

        return 'd';
    }

    // public static void main(String[] args) {
    //     System.out.println("TIC-TAK-TOE");
    //     System.out.println();
    //     Scanner in = new Scanner(System.in);
    //     TicTakToe board = new TicTakToe();
    //     int counter = 0;
    //     do {

    //         System.out.println(board);
    //         char player = (counter%2 == 0) ? 'x' : 'o';
    //         System.out.println("ENTER "+player+": ");
    //         System.out.println();
    //         int x = in.nextInt()-1;
    //         int y = in.nextInt()-1;

    //         boolean isValid = board.executePlay(x, y, player);
    //         if(!isValid) {
    //             System.out.println("INVALID ENTRY!!!");
    //             System.out.println();
    //             continue;
    //         }

    //         counter++;

    //     } while(board.gameOver() == ' ');
    //     System.out.println(board);
    //     System.out.println("\n");
    //     char result = board.gameOver();
    //     if(result == 'd') {
    //         System.out.println("DRAW!! FUCK YOU, You can't play for shit. Wtf draws tictaktoe");
    //     }
    //     else if(result == 'x') {
    //         System.out.println("X WINS!!!! FUCK YOU 'O'. How tf do you lost at tictaktoe you dumbshit");
    //     }
    //     else {
    //         System.out.println("O WINS!!!! FUCK YOU 'X'. How tf do you lost at tictaktoe you dumbshit");
    //     }
    //     in.close();
    // }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("");
        for(int x=0;x<3;x++) {
            for(int y=0;y<3;y++) {
                if(board[x][y] == ' ')
                    builder.append("- ");
                else{
                    builder.append(board[x][y]);
                    builder.append(" ");
                }
            }
            builder.append('\n');
        }
        return builder.toString();
    }
}
