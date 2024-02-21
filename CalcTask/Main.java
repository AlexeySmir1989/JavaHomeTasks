package JavaCoreTasks.CalcTask;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        /*
        При выполнении кода выдает ошибку ArithmeticException /by zero - это деление на ноль
        Чтобы исключить данную ошибку можно добавить проверку деления на ноль и в случае == 0, выводить ошибку на экран.

                */
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        if (b == 0) {
            System.out.println("На ноль делить нельзя!");
            ;
        } else {
            int c = calc.devide.apply(a, b);
            calc.println.accept(c);
        }
    }
}

class Calculator {
    static Supplier<Calculator> instance = Calculator::new;
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> x / y;
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
    Predicate<Integer> isPositive = x -> x > 0;
    Consumer<Integer> println = System.out::println;
}