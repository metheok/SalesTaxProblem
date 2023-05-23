/*

 * Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is
 * an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.
 * When I purchase items, I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total
 * cost of the items, and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax rate of n%, a shelf price
 * of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.
 * 
 * This class serves as a driver for the supporting classes
 */

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Receipt receipt = new Receipt();
		IO ioInstant = new IO();
		GeneralUtil utilInstant = new GeneralUtil();

		ArrayList<String> lines = ioInstant.takeLinesFromIO();
		ArrayList<Product> products = utilInstant.createProductsFromLines(lines);
		receipt.addItems(products);
		ArrayList<String> receiptLines = receipt.fetchReceiptOutputLines();
		ioInstant.printLines(receiptLines);

	}
}