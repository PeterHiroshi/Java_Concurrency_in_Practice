package peter8icestone.concurrency.chapter2.tax;

public class TaxCalculatorMain {

    public static void main(String[] args) {
//        TaxCalculator taxCalculator = new TaxCalculator(2000, 500, new SimpleCalculatorStrategy());
        TaxCalculator taxCalculator = new TaxCalculator(2000, 500, (s, b) -> s * 0.1 + b * 0.2);
        System.out.println(taxCalculator.calculate());
    }

}
