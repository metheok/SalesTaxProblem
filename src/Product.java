
public class Product {
	public final String name;
	public final Category category;
	public final boolean isImported;
	public final float basePrice;
	public final int qty;

	public Product(String name, Category category, boolean isImported, float basePrice, int qty) {
		this.name = name;
		this.category = category;
		this.qty = qty;
		this.isImported = isImported;
		this.basePrice = basePrice;
	}

	public Product createProduct(String line) {

		String[] words = line.split(" "); // divide the line

		int qty = Integer.parseInt(words[0]); // first word is the quantity
		boolean isImported = line.contains("imported"); // check if the item is imported
		Category category = createProductCategory(line);
		int splitIndex = line.lastIndexOf("at");

		if (splitIndex == -1) {

			System.out.println("Bad Formatting");
			return new Product(null, null, false, 0, 0);

		}
		float price = Float.parseFloat((line.substring(splitIndex + 2))); // the price is the token after the substring

		System.out.println(price); // "at"

		String name = line.substring(1, splitIndex); // the name is everything between the qty and at

		Product prod = new Product(name, category, isImported, price, qty);

		return prod;
	}

	private Category createProductCategory(String line) {
		if (line.contains("book")) {
			return Category.BOOK;
		}
		if (line.contains("chocolate") || line.contains("food")) {
			return Category.FOOD;
		}
		if (line.contains("pill") || line.contains("medicine")) {
			return Category.MEDICAL;
		}
		return Category.OTHER;
	}
}
