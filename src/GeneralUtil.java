import java.util.ArrayList;

public class GeneralUtil {
    public ArrayList<Product> createProductsFromLines(ArrayList<String> lines) {
        ArrayList<Product> productArray = new ArrayList<Product>();
        for (String line : lines) {

            Product pro = new Product(null, null, false, 0, 0);
            pro = pro.createProduct(line);
            productArray.add(pro);
        }
        return productArray;
    }
}
