package org.nekogochan.check;

import java.util.Arrays;

/**
 * https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D0%B0%D0%B2%D0%B8%D0%BB%D0%BE_%D0%A0%D1%83%D0%BD%D0%B3%D0%B5
 * проверка правилом Рунге
 */
public class RungeCheck {

    // уровни точности для разных методов интегрирования
    public static final int RECTANGLE_ACCURACY_LEVEL = 3;
    public static final int TRAPEZOID_ACCURACY_LEVEL = 3;
    public static final int SIMPSON_ACCURACY_LEVEL = 15;

    /**
     * @param I2n - значение интеграла для n * 2 шагов
     * @param In - значение интеграла для n шагов
     * @param omega - значение точности для выбраного метода интегрирования
     * @param accuracy - требуемая точность
     * @return - булево значение, определяющее, подходит ли результат вычисления к заданной точности
     */
    public static boolean isValid(double I2n, double In, double omega, double accuracy) {
        return Math.abs(I2n - In) / omega < accuracy;
    }
}
