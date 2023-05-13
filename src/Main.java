/*

 * Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is
 * an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.
 * When I purchase items, I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total
 * cost of the items, and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax rate of n%, a shelf price
 * of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.
 * 
 * This class serves as a driver for the supporting classes
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Program Start");


		Receipt receipt1 = new Receipt("test_1.txt");	
		receipt1.calculateTotals();
		
		System.out.println("Output 1");
		receipt1.printReceipt();
		System.out.println();

		Receipt receipt2 = new Receipt("test_2.txt");

		receipt2.calculateTotals();
		
		System.out.println("Output 2");
		receipt2.printReceipt();
		System.out.println();
		
		Receipt receipt3 = new Receipt("test_3.txt");
		
		receipt3.calculateTotals();
		
		System.out.println("Output 3");
		receipt3.printReceipt();
		
	}

}
