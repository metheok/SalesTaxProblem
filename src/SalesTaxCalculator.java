public class SalesTaxCalculator implements TaxCalculator {

    private TaxCalculator calculator;

    public SalesTaxCalculator(TaxCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public Product getProduct() {
        return calculator.getProduct();
    }

    @Override
    public float calculate() {
        return calculator.calculate() + getProduct().basePrice * 0.10f;
    }
}
