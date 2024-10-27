package JavaCoreTasks.LinkForMethod;


import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        Consumer<String> sayable = Main::saySomething;
        sayable.accept("Hello");
        UnaryOperator<Integer> cube = x -> x * x * x;
        System.out.println(cube.apply(5));
        Consumer<Integer> calcul = Main::calcSomething;
        calcul.accept(1);
    }

    private static void saySomething(String s) {
        System.out.println(s);
    }
    private static void calcSomething(int x){
        x++;
        System.out.println(x);
    }
}
