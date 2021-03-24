package Calculator;


import java.util.Scanner;

public class Runnable {

    public static void main(String[] args) {
        System.out.println("Вызов калькулятора");
        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Запишем выражение: ");
        calculator.writeExpression(scanner.nextLine());

        System.out.println("Получим результат: ");
        calculator.showResult();
    }
}
