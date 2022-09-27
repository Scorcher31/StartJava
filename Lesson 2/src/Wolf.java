import java.util.Random;
import java.util.Scanner;

public class Wolf {
    private Sex sex;
    private final String name;
    private double weight;
    private int age;
    private final String color = "grey";
    private boolean isSitting = false;
    private final Coordinates coordinates = new Coordinates();
    private Directions direction;

    Wolf(String name, double weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        boolean isSexInstalled = false;
        System.out.println("Введите 1, если ваш волк -- самец, 2 -- если самка");
        System.out.print(">>>");
        Scanner in = new Scanner(System.in);
        do {
            int number = in.nextInt();
            if(number == 1) {
                sex = Sex.MALE;
                isSexInstalled = true;
            } else if(number == 2) {
                sex = Sex.FEMALE;
                isSexInstalled = true;
            } else {
                System.out.println("\nВведите 1 или 2");
                System.out.print(">>>");
            }
        } while(!isSexInstalled);
        System.out.println("");
        setCoordinates();
        setDirection();
    }

    public void defineLocation() {
        System.out.println("Координаты: " + coordinates.x + ", " + coordinates.y);
        System.out.println("Волк смотрит на " + direction.getDirection());
    }

    public void tame() {
        System.out.println("К нам поступил раненный волк по кличке " + name + ".");
        System.out.println("Предполагаемый возраст: " + age + " лет.");
        System.out.println("Окрас серый, вес " + weight + "kg, характер спокойный.");
        if(sex == Sex.MALE) {
            System.out.println("Самец.");
        } else {
            System.out.println("Самка.");
        }
    }

    private void setDirection() {
        Random rnd = new Random();
        int rndDirection = rnd.nextInt(8);
        switch(rndDirection) {
            case 0:
                direction = Directions.NORTH;
                break;
            case 1:
                direction = Directions.SOUTH;
                break;
            case 2:
                direction = Directions.EAST;
                break;
            case 3:
                direction = Directions.WEST;
                break;
            case 4:
                direction = Directions.NORTHWEST;
                break;
            case 5:
                direction = Directions.NORTHEAST;
                break;
            case 6:
                direction = Directions.SOUTHEAST;
                break;
            case 7:
                direction = Directions.SOUTHWEST;
        }
    }

    private void setCoordinates() {
        Random rnd = new Random();
        coordinates.x = rnd.nextDouble();
        coordinates.y = rnd.nextDouble();
    }

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
        switch (direction) {
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

    public void yowl() {
        isSitting = true;
        System.out.println("Woooooooooooooooof!");
    }

    public void hunt() {
        double westPrey = coordinates.x - 8;
        double eastPrey = coordinates.x + 8;
        double northPrey = coordinates.y + 8;
        double southPrey = coordinates.y - 8;
        double x = (int)(Math.random() - (eastPrey - westPrey + 1));
        double y = (int)(Math.random() - (northPrey - southPrey + 1));

        if(isSitting)
            isSitting = false;
        coordinates.x = x;
        coordinates.y = y;
        System.out.println("Съел добычу");
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
        NORTH("север"),
        SOUTH("юг"),
        EAST("восток"),
        WEST("запад"),
        NORTHEAST("северо-восток"),
        SOUTHWEST("юго-запад"),
        SOUTHEAST("юго-восток"),
        NORTHWEST("северо-запад");

        private final String caption;

        Directions(String caption) {
            this.caption = caption;
        }

        public String getDirection() {
            return caption;
        }
    }
}