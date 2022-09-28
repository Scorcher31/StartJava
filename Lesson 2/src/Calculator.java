public class Calculator {
    private double operand1;
    private double operand2;
    private double result;
    private char sign;
    private Operations operation;

    public Calculator(double a, double b, Operations operation) {
        operand1 = a;
        operand2 = b;
        this.operation = operation;
        defineOperation();
    }

    private void defineOperation() {
        switch (operation) {
            case ADD:
                sign = '+';
                add();
                break;
            case SUBTRACT:
                sign = '-';
                subtract();
                break;
            case MUTLTIPLY:
                sign = '*';
                multiply();
                break;
            case DIVIDE:
                sign = '/';
                divide();
                break;
            case DIVIDEbyMODULE:
                sign = '%';
                divideByModule();
                break;
            case EXTEND:
                sign = '^';
                extend();
        }
    }

    private void add() {
        result = operand1 + operand2;
    }

    private void subtract() {
        result = operand1 - operand2;
    }

    private void divide() {
        result = operand1 / operand2;
    }

    private void multiply() {
        result = operand1 * operand2;
    }

    private void divideByModule() {
        int a = (int)operand1;
        int b = (int)operand2;
        result = a % b;
    }

    private void extend() {
        int index = (int)operand2;
        double result = 1;
        for(int i = 0; i < index; i++) {
            result *= operand1;
        }
        this.result = result;
    }

    public void printResult() {
        System.out.println(operand1 + " " + sign + " " + operand2 + " = " + result);
    }
}