package org.nekogochan.calculator;

import org.nekogochan.Main;
import org.nekogochan.check.RungeCheck;

/**
 * Калькулятор на основе метода средних прямоугольников
 * http://www.mathcs.emory.edu/~cheung/Courses/170/Syllabus/07/rectangle-method.html
 */
public class RectangleIntegralCalculator extends IntegralCalculator {

    public RectangleIntegralCalculator() {
        super(RungeCheck.RECTANGLE_ACCURACY_LEVEL);
    }

    @Override
    protected double getResult(int iterations) {
        double res = 0.0;
        double step = (b - a) / iterations;

        // прибавка к результаты высоты прямоугольников
        System.out.println("Высоты средних прямоугольников: ");
        for (int i = 0; i < iterations; i++) {
            res += foo.getY((a + step * i + step / 2));
            System.out.printf("%.2f\t%.2f\n", a + step * i + step / 2, foo.getY((a + step * i + step / 2)));
        }

        System.out.println("Сумма высот: " + res);

        // умножение результата на ширину прямоугольников (т.к. она одинаковая для всех прямоугольников, то ее можно вынести в конец вычислений)
        return step * res;
    }


    @Override
    public String toString() {
        return "Rectangle Integral Calculator";
    }
}
