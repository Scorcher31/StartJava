import java.util.Random;

public class Person {
    private final int age = 5;
    private final Sex sex = Sex.FEMALE;
    private final double height = 0.78;
    private final double weight = 32.6;
    private final String name = "Svetlana";
    private final Coordinates coordinates = new Coordinates();
    private boolean isSitting = false;
    private Directions direction = Directions.NORTH;

    public void walk() {
        Random rnd = new Random();
        int chose = rnd.nextInt(8);
        if(isSitting)
            isSitting = false;
        switch (chose) {
            case 0:
                coordinates.x++;
                direction = Directions.EAST;
                break;
            case 1:
                coordinates.y++;
                direction = Directions.NORTH;
                break;
            case 2:
                coordinates.x--;
                direction = Directions.WEST;
                break;
            case 3:
                coordinates.y--;
                direction = Directions.SOUTH;
                break;
            case 4:
                coordinates.x++;
                coordinates.y++;
                direction = Directions.NORTHEAST;
                break;
            case 5:
                coordinates.x--;
                coordinates.y--;
                direction = Directions.SOUTHWEST;
                break;
            case 6:
                coordinates.x++;
                coordinates.y--;
                direction = Directions.SOUTHEAST;
                break;
            case 7:
                coordinates.x--;
                coordinates.y++;
                direction = Directions.NORTHWEST;
        }
    }

    public void run() {
        Random rnd = new Random();
        int chose = rnd.nextInt(8);
        if(isSitting)
            isSitting = false;
        switch(direction) {
            case NORTH:
                coordinates.y += 5;
                break;
            case SOUTH:
                coordinates.y -= 5;
                break;
            case EAST:
                coordinates.x += 5;
                break;
            case WEST:
                coordinates.x -= 5;
                break;
            case NORTHEAST:
                coordinates.x += 5;
                coordinates.y += 5;
                break;
            case SOUTHEAST:
                coordinates.x += 5;
                coordinates.y -= 5;
                break;
            case NORTHWEST:
                coordinates.x -= 5;
                coordinates.y += 5;
                break;
            case SOUTHWEST:
                coordinates.x -= 5;
                coordinates.y -= 5;
        }
    }

    public void sayName() {
        System.out.println("My name is " + name + ".");
    }

    public void learnJava() {
        System.out.println("Learning java...");
    }

    public void sit() {
        isSitting = true;
        System.out.println("присел отдохнуть.");
    }

    public enum Sex {
        MALE,
        FEMALE
    }

    private static class Coordinates {
        double x;
        double y;
    }

    private enum Directions {
        NORTH,
        SOUTH,
        EAST,
        WEST,
        NORTHEAST,
        SOUTHWEST,
        SOUTHEAST,
        NORTHWEST
    }
}