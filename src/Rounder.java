public class Rounder implements TaxCalculator {
    private TaxCalculator calculator;

    public Rounder(TaxCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public Product getProduct() {
        return calculator.getProduct();
    }

    @Override
    public float calculate() {
        int val = 2 + (int) (calculator.calculate() * 100);
        int remainder = val % 5;
        return ((float) (val - remainder)) / 100f;
    }
}