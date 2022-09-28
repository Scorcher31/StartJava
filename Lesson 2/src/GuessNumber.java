import java.awt.desktop.ScreenSleepEvent;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private static int hiddenNumber;
    private static ArrayList<Player> players;

    public static void main(String[] args) {
        System.out.println("Это игра угадай число. Два игрока пытаются угадать число, загаданное компьютером.");
        System.out.println("После каждого ответа, компьютер подсказывает: некоторое число N больше или меньше загаданного");
        System.out.println("Победит тот, кто первым отгадает загаданное число.");
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя первого игрока: ");
        String name = in.nextLine();
        Player player1 = new Player(name);
        System.out.print("Введите имя второго игрока: ");
        name = in.nextLine();
        Player player2 = new Player(name);
        System.out.println("");

        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        hiddenNumber = generateNumber();

        gameplay();
    }

    public static void gameplay() {
        byte curPlayer = 1;
        int guess = 0;

        while(true) {
            System.out.println("Ходит " + curPlayer + "-й игрок.");
            System.out.println("Загаданное число:");
            System.out.print(">>>");
            Scanner in = new Scanner(System.in);

            try {
                guess = in.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Игрок " + curPlayer + ", некорректный ответ. Ход переходит к вашему сопернику");
            }

            if(guess == hiddenNumber) {
                System.out.println(players.get(curPlayer - 1).getPlayerName() + " поздравляю! Вы победили!!!");
                System.out.println("Желаете продолжить игру?");
                String answer = in.nextLine();
                if(answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                    break;
                }
            } else {
                generateHint();
            }

            if(curPlayer == 1) {
                curPlayer = 2;
            } else {
                curPlayer = 1;
            }
        }
    }

    public static int generateNumber() {
        return (int)(Math.random() * 100);
    }

    public static void generateHint() {
        Random rnd = new Random();
        int y = rnd.nextInt();
        if(y % 2 == 0) {
            int difference = hiddenNumber - generateNumber();
            System.out.println("подсказка: число " + difference + " меньше загаданного.");
            System.out.println("");
        } else {
            int difference = hiddenNumber + generateNumber();
            System.out.println("подсказка: число " + difference + " больше загаданного.");
            System.out.println("");
        }
    }
}