package org.nekogochan.calculator;

import org.nekogochan.check.RungeCheck;

/**
 * Калькулятор на основе метода Симпсона
 * https://www.math24.net/simpsons-rule/#:~:text=Simpson's%20Rule%20is%20a%20numerical,Simpson%20(1710%E2%88%921761)
 */
public class SimpsonIntegralCalculator extends IntegralCalculator {

    public SimpsonIntegralCalculator() {
        super(RungeCheck.SIMPSON_ACCURACY_LEVEL);
    }

    @Override
    protected double getResult(int iterations) {

        /*
         * firstLast - сумма первого и последнего членов
         * odd - сумма четных
         * even - сумма нечетных
         */
        double firstLast = 0.0;
        double odd = 0.0;
        double even = 0.0;

        if (iterations % 2 != 0) throw new IllegalArgumentException("iterations count must be odd");

        double step = (b - a) / iterations;

        for (int i = 0; i <= iterations; i++) {
            double piece = foo.getY(a + step * i);

            if (i == 0 || i == iterations) firstLast += piece;
            else if (i % 2 == 0) odd += piece;
            else even += piece;
        }

        return (step / 3) * (firstLast + 2 * odd + 4 * even);
    }


    @Override
    public String toString() {
        return "Simpson Integral Calculator";
    }
}
