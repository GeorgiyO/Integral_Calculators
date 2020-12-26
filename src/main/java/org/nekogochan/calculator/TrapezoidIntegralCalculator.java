package org.nekogochan.calculator;

import org.nekogochan.check.RungeCheck;

import java.util.Arrays;

/**
 * Калькулятор на основе метода трапеций
 * https://www.math24.net/trapezoidal-rule/#:~:text=Another%20useful%20integration%20rule%20is,little%20trapezoids%20rather%20than%20rectangles.&text=a%3Dx0%3Cx1,%E2%8B%AF%3Cxn%3Db
 */
public class TrapezoidIntegralCalculator extends IntegralCalculator {

    public TrapezoidIntegralCalculator() {
        super(RungeCheck.TRAPEZOID_ACCURACY_LEVEL);
    }

    @Override
    protected double getResult(int iterations) {
        double res = 0.0;
        double step = (b - a) / iterations;

        System.out.println("шаг h: " + step);

        // nodes - значения узлов в точках a + step * i
        System.out.println("Значения f(x) в узлах:");
        double[] nodes = new double[iterations + 1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = foo.getY(a + step * i);
            System.out.printf("%.2f\t%.2f\n", a + step * i, foo.getY(a + step * i));
        }


        // прибавка к результату среднего арифметического от двух соседних узлов (высота трапеции)
        System.out.println("Значения ai:");
        for (int i = 0; i < iterations; i++) {
            res += (nodes[i] + nodes[i + 1]) / 2;
            System.out.printf("%.2f\t", (nodes[i] + nodes[i + 1]) / 2);
        }
        System.out.println();
        System.out.println("Сумма значений: " + res);

        // умножение результата на ширину трапеций (т.к. она одинаковая для всех трапеций, то ее можно вывести в конец)
        return step * res;
    }


    @Override
    public String toString() {
        return "Trapezoid Integral Calculator";
    }
}
