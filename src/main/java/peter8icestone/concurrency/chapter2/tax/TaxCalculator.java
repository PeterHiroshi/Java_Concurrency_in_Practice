package peter8icestone.concurrency.chapter2.tax;

public class TaxCalculator {

    private final double salary;

    private final double bonus;

    private CalculatorStrategy calculatorStrategy;


    public TaxCalculator(double salary, double bonus, CalculatorStrategy calculatorStrategy) {
        this.salary = salary;
        this.bonus = bonus;
        this.calculatorStrategy = calculatorStrategy;
    }

    public double calculate() {
        return calculatorStrategy.calculate(salary, bonus);
    }
}
