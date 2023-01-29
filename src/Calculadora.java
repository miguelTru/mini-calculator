import java.util.Scanner;

public class Calculadora {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        float firstNumber = getNumber();
        float secondNumber = getNumber();
        char operation = getOperation();
        float result = calculate(firstNumber,secondNumber,operation);

        System.out.printf("The result of %.3f %c %.3f = %.3f",firstNumber,operation,secondNumber,result);
    }
    public static float getNumber(){
        System.out.println("Enter the number:");
        float num;
        if(scanner.hasNextFloat()){
            num = scanner.nextFloat();
        } else {
            System.out.println("Wrong number try again.");
            scanner.next();
            num = getNumber();
        }
        return num;
    }
    public static char getOperation(){
        System.out.println("Enter the operation symbol:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Wrong symbol try again.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }
    public static float calculate(float firstNumber, float secondNumber, char operation){
        float result;
        switch (operation){
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber == 0){
                    System.out.println("we cannot divide between 0.");
                    result = calculate(firstNumber, getNumber(), operation);
                } else {
                        result = firstNumber / secondNumber;
                }
                break;
            default:
                System.out.println("Operation undefined try again.");
                result = calculate(firstNumber, secondNumber, getOperation());
        }
        return result;
    }
}