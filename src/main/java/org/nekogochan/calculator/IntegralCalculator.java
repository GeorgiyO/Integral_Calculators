package org.nekogochan.calculator;

import org.nekogochan.Main;
import org.nekogochan.check.RungeCheck;
import org.nekogochan.model.Function;

public abstract class IntegralCalculator {

    /**
     * a - b границы отрезка, foo - функция
     */
    protected double a;
    protected double b;
    protected Function foo;
    /**
     * Уровень точности, задается в конструкторах наследников
     */
    protected final int accuracyLevel;

    protected IntegralCalculator(int accuracyLevel) {
        this.accuracyLevel = accuracyLevel;
    }

    /**
     * Результаты предыдущей и текущей итераций
     */
    private double prevResult = 0.0;
    private double result = 0.0;

    /**
     * сеттеры
     */
    public void setA(double a) {
        this.a = a;
    }
    public void setB(double b) {
        this.b = b;
    }
    public void setFoo(Function foo) {
        this.foo = foo;
    }

    /**
     * Функция, овтечающая за непосредственное вычисление интегралов с заданной точностью, если точность не соответствует
     * тербованиям, то интеграл высчитывается по новой с меньшим шагом
     * @param iterations - начальное количество итераций
     * @return значение интеграла для заданной точности
     */
    public double calculate(int iterations) {
        prevResult = result;
        result = getResult(iterations);
        if (RungeCheck.isValid(result, prevResult, accuracyLevel, Main.ACCURACY)) {
            return result;
        } else {
            return calculate(iterations * 2);
        }
    };

    /**
     * Функция, вычисляющая интеграл для данного количества интегралов
     * @param iterations - количество шагов
     * @return значение интеграла для заданного количества шагов
     */
    protected abstract double getResult(int iterations);
}
