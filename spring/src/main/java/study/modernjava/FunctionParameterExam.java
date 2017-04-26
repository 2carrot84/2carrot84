package study.modernjava;

import java.util.function.IntUnaryOperator;

/**
 * Created by eguns on 2017. 4. 26..
 */
public class FunctionParameterExam {
    public static void main(String[] args) {
        FunctionParameterExam printer = new FunctionParameterExam();

        int base = 7;
        printer.printWeighted(weight -> base*weight, 10);
    }

    public void printWeighted(IntUnaryOperator calc, int weight) {
        System.out.println(calc.applyAsInt(weight));
    }
}
