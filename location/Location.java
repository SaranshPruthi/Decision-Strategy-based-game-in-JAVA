package location;
import java.util.Scanner;

public abstract class Location {

    final String name;
    Scanner in;

    public Location(String name, Scanner in) {
        this.name = name;
        this.in = in;
    }
    
    public String getName() {
        return name;
    }

    protected void greetings() {
        System.out.println("Welcome to " + name);
        System.out.println("You are going to play a " + type() + " quiz");
    }

    public abstract boolean playGame();

    protected abstract String type();

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Location))
            return false;
        Location location = (Location)obj;
        return location.name.equals(name);
    }

}
