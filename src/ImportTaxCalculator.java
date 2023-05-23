public class ImportTaxCalculator implements TaxCalculator {

    private TaxCalculator calculator;

    public ImportTaxCalculator(TaxCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public Product getProduct() {
        return calculator.getProduct();
    }

    @Override
    public float calculate() {

        return (float) calculator.calculate() + getProduct().basePrice * 0.05f;
    }
}