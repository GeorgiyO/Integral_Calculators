package org.nekogochan;

import org.nekogochan.calculator.IntegralCalculator;
import org.nekogochan.calculator.RectangleIntegralCalculator;
import org.nekogochan.calculator.SimpsonIntegralCalculator;
import org.nekogochan.calculator.TrapezoidIntegralCalculator;
import org.nekogochan.model.Function;

public class Main {

    // точность с которой задается вычисление
    public static final double ACCURACY = 1000;

    // точное значение подинтегральной функции
    public static final double EXACT_VALUE = Math.sqrt(3.0) / 2.0 - Math.cos(Math.PI / 6.0 + 1.0);

    /**
     * foo - подинтегральная функция
     * A, B - отрезок [a, b]
     * ITERATIONS_COUNT - начальное количество итераций
     */
    private static final Function foo = (x) -> (Math.sin(x + Math.PI / 6.0));
    private static final double A = 0.0;
    private static final double B = Math.PI;
    private static final int ITERATIONS_COUNT = 8;

    // интегральные калькуляторы
    private static final IntegralCalculator[] integralCalculators = {
            new RectangleIntegralCalculator(),
            new TrapezoidIntegralCalculator(),
            new SimpsonIntegralCalculator()
    };

    // точка входа в программу
    public static void main(String[] args) {
        System.out.printf("Подинтегральная функция: %s\nA: %s\nB: %s\nКоличество итераций: %s\nТочное значение подинтегральной функции: %s\nЗаданная точность: %s\n\n",
                "f(x) = Math.log(2*x + 1) + 2 * Math.sin(3*x)", A, B, ITERATIONS_COUNT, EXACT_VALUE, ACCURACY);

        for (IntegralCalculator calculator : integralCalculators) {
            long time = System.nanoTime();
            calculator.setA(A);
            calculator.setB(B);
            calculator.setFoo(foo);
            double res = calculator.calculate(ITERATIONS_COUNT);
            System.out.printf("Тип калькулятора: %s\nРезультат вычислений: %s\nПогрешность вычислений: %s\nВремя: %s\n - - - - \n",
                    calculator.toString(), res, Math.abs(res - EXACT_VALUE), System.nanoTime() - time);
        }
    }
}
