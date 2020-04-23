package peter8icestone.concurrency.chapter2.tax;

public class SimpleCalculatorStrategy implements CalculatorStrategy {

    private final static double SALARY_RATE = 0.1;

    private final static double BONUS_RATE = 0.2;

    @Override
    public double calculate(double salary, double bonux) {
        return salary * SALARY_RATE + bonux * BONUS_RATE;
    }
}
