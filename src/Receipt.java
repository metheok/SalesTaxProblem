
import java.util.ArrayList;
import java.math.*;

public class Receipt {

	private ArrayList<Product> items;

	public Receipt() {
		items = new ArrayList<>();
	}

	public void addItems(ArrayList<Product> products) {
		for (Product item : products) {
			items.add(item);
		}
	}

	public ArrayList<String> fetchReceiptOutputLines() {
		float totalPrice = 0;
		float totalSalexTax = 0;
		ArrayList<String> lines = new ArrayList<String>();
		for (Product item : items) { // iterate all items in receiot

			String mainString = item.qty + " " + item.name.trim();

			TaxCalculator calc = new BaseTaxCalculator(item); // calculate base tax
			if (item.category == Category.OTHER)
				calc = new SalesTaxCalculator(calc); // calculate sales tax
			if (item.isImported)
				calc = new ImportTaxCalculator(calc); // calculate import tax

			// round off tax to 2 decimal points START
			calc = new Rounder(calc);
			float salesTax = calc.calculate();
			;
			BigDecimal netPriceBig = new BigDecimal((float) salesTax + item.basePrice);

			netPriceBig = netPriceBig.setScale(2, RoundingMode.HALF_UP);
			float netPrice = netPriceBig.floatValue();
			// round off tax to 2 decimal points END

			lines.add(mainString + ": " + netPrice);
			totalPrice += netPrice;
			totalSalexTax += salesTax;
		}
		lines.add("Sales Taxes: " + totalSalexTax);
		lines.add("Total: " + totalPrice);
		return lines;
	}
}