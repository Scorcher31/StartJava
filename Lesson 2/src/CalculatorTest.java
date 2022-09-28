import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        System.out.println("Введите первое число:");
        System.out.print(">>>");
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        in.nextLine();
        System.out.println("");
        System.out.println("Введите знак операции:");
        System.out.print(">>>");
        char sign = in.nextLine().charAt(0);
        System.out.println("");
        System.out.println("Введите второе число:");
        System.out.print(">>>");
        double b = in.nextDouble();
        System.out.println("");

        Calculator clc = new Calculator(a, b, defineOperation(sign));
        clc.printResult();
    }

    private static Operations defineOperation(char sign) {
        Operations op;
        switch (sign) {
            case '+':
                op = Operations.ADD;
                break;
            case '-':
                op = Operations.SUBTRACT;
                break;
            case '*':
                op = Operations.MUTLTIPLY;
                break;
            case '/':
                op = Operations.DIVIDE;
                break;
            case '%':
                op = Operations.DIVIDEbyMODULE;
                break;
            case '^':
                op = Operations.EXTEND;
                break;
            default:
                throw new ArithmeticException();
        }
        return op;
    }
}