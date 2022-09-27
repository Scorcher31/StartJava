public class WolfTest {
    public static void main(String[] args) {
        Wolf jack = new Wolf("Jack", 65.1, 9);
        jack.tame();
        jack.defineLocation();
        jack.run();
        jack.walk();
        jack.hunt();
        jack.yowl();
        jack.defineLocation();
    }
}