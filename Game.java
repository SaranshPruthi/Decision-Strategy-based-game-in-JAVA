import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import location.*;
import location.Location;

public class Game {

    private Set<Location> locations;
    Scanner in;

    private String name;

    private int lives;

    public Game(Scanner in) {
        this.in = in;
        locations = new HashSet<>();
        // addLocations();
        // setPlayerName();
        // lives = 3;
        // play();
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void addLocations() {
        Location location = new BDome("B Dome", in);
        locations.add(location);
        location = new DSide("D Side", in);
        locations.add(location);
        location = new FoodKing("Food King", in);
        locations.add(location);
        location = new IceNSpice("Ice N Spice", in);
        locations.add(location);
        location = new Library("Library", in);
        locations.add(location);
        location = new Malakars("Malakars", in);
        locations.add(location);
    }
    
    private void checkWinMessage() {
    	if(locations.isEmpty()==true) {
    		System.out.println("");
    		System.out.println("");
    		System.out.println("Congratulations!!! You win the game!");
    	}
    }

    private void setPlayerName() {
        System.out.print("Enter name: ");
        name = in.nextLine();
        System.out.println("Welcome " + name + "!");
    }

    private Location getLocation(String loc) {
        for(Location location : locations) {
            if(location.getName().equalsIgnoreCase(loc))
                return location;
        }
        return null;
    }

    private void displayLocations() {
        for(Location location : locations) {
            System.out.println(location.getName());
        }

    }

    private void play() {
        while(locations.size() > 0) {
            System.out.println("You have "+lives+" lives remaining");
            System.out.println("Select a location: ");
            displayLocations();
            String location = in.nextLine();

            Location selectedLocation = getLocation(location);

            if(selectedLocation == null) {
                System.out.println("Invalid location: " + location);
                System.out.println();
                continue;
            }

            boolean result = selectedLocation.playGame();

            if(result) {
                // TODO passed

                locations.remove(selectedLocation);

            }
            else {
                if(--lives == 0) {
                    System.out.println("You have lost the game, Thank you for playing!");
                    System.exit(0);
                }
                do {
                    System.out.println("Select a penalty game: ");
                    System.out.println("DICE | TIC-TAC-TOE");
                    String game = in.nextLine();
                    if(!(game.equalsIgnoreCase("DICE") || game.equalsIgnoreCase("TIC-TAC-TOE"))) {
                        System.out.println("INVALID GAME: " + game);
                        System.out.println();
                        continue;
                    }


                    if(game.equalsIgnoreCase("DICE")) {
                        // TODO dice game
                        boolean res = dice();
                        if(res)
                            break;
                    } else {
                        // TODO TIC-TAK-TOE game
                        boolean res = tictactoe();
                        if(res)
                            break;
                    }

                } while(true);
            }

        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Game game = new Game(in);
        game.addLocations();
        game.setLives(3);
        game.checkWinMessage();
        game.setPlayerName();
        game.play();
    }

    private boolean dice() {
        System.out.println("Dice");
        System.out.println();
        while(true) {
            System.out.println("Enter 1 to roll the dice. (You win if you get a 6)");
            in.nextLine();
            int rand = (int)(Math.random()*6) + 1;
            System.out.println("Dice: " + rand);
            if(rand == 6) {
                System.out.println("You pass by rolling a 6.");
                return true;
            }
            else {
                System.out.println("Sorry, you have lost the penalty game.. try again.");
                return false;
            }
        }
    }

    private boolean tictactoe() {
        System.out.println("TIC-TAC-TOE");
        System.out.println();
        // Scanner in = new Scanner(System.in);
        TicTakToe board = new TicTakToe();//object
        String ai[]= new String[9];
        ai[0]="2 2";
        ai[1]="1 2";
        ai[2]="2 3";
        ai[3]="3 3";
        ai[4]="2 1";
        ai[5]="1 1";
        ai[6]="1 3";
        ai[7]="3 1";
        ai[8]="3 2";
        int counter = 0;
        do {

            System.out.println(board);
            char player = (counter%2 == 0) ? 'x' : 'o';
            System.out.println("ENTER "+player+": ");
            System.out.println();
            int x=-1,y=-1;
            if(player=='x')
            {
                x = in.nextInt()-1;
                y = in.nextInt()-1;
                boolean isValid = board.executePlay(x, y, player);
                if(!isValid) {
                    System.out.println("Invalid entry! Please enter a valid input");
                    System.out.println();
                    continue;
                }
            }
            else{
                for(int i=0;i<9;i++)
                {
                    x=(int)ai[i].charAt(0)-'0'-1;
                    y=(int)ai[i].charAt(2)-'0'-1;
                    if(board.executePlay(x,y,player)){
                        break;
                    }
                }
            }
            counter++;

        } while(board.gameOver() == ' ');
        System.out.println(board);
        System.out.println("\n");
        char result = board.gameOver();
        if(result == 'd') {
            System.out.println("Draw");
            return false;
        }
        else if(result == 'x') {
            System.out.println("X wins!");
            return true;
        }
        else {
            System.out.println("O wins!");
            return false;
        }
    }

}