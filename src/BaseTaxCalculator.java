public class BaseTaxCalculator implements TaxCalculator {

    protected Product Product;

    public BaseTaxCalculator(Product product) {
        this.Product = product;
    }

    @Override
    public Product getProduct() {
        return Product;
    }

    @Override
    public float calculate() {
        return 0;
    }
}