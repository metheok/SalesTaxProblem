
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.math.*;
import utils.GeneralUtil;

public class Receipt extends GeneralUtil {

	private ArrayList<Product> productsList = new ArrayList<Product>();
	private double total;
	private double taxTotal;
	
	public Receipt(String inputFileName){
		/* This method accepts a directory to an input text file which it goes through
		 * Each line is read and converted into the proper Product type
		 */
		try {

            Scanner input = new Scanner(System.in);
            File file = new File(inputFileName);
            input = new Scanner(file);
        
            while (input.hasNextLine()) {
            	
            	String line = input.nextLine(); //take the line
            	 
            	String[] words = line.split(" "); //divide the line 
            	
            	int qty = Integer.parseInt(words[0]); //first word is the quantity
            	
            	boolean isImported = line.contains("imported"); //check if the item is imported
            	
            	String[] exemptedItems =  new String[]{"book","chocolate","pills"}; //check if the item in the exempted list
            	
            	int exemptedItemIndex = GeneralUtil.containsItemFromArray(line,exemptedItems); //Find which type of exemption
            	
            	String exemptedType = null;
            	
            	if(exemptedItemIndex != -1){
            		//the item is tax exempted
            		
            		//the exempted word is contained at exempted item index
                	exemptedType = exemptedItems[exemptedItemIndex];
        			
            	}

            	int splitIndex = line.lastIndexOf("at");
            	
            	if(splitIndex == -1){
            		
            		System.out.println("Bad Formatting");
            		
            	} else {
            		
                	float price = Float.parseFloat((line.substring(splitIndex + 2))); //the price is the token after the substring "at"
                    
                	String name = line.substring(1, splitIndex); //the name is everything between the qty and at
                	
                    for(int i = 0;i<qty;i++){
                    	//loop for the total quantity of the item to make that many in the list
                    	
                    	Product newProduct = null;
                    	
                    	if(isImported){
                    		//the product is imported
                        	if(exemptedType != null){
                        		//the product is not imported and is exempt of sales tax
                        		
                        		if(exemptedType == "book"){
                        			newProduct = new Product(name,price,ItemType.IMPORTED_BOOK);
                        		} else if(exemptedType == "pills"){
                        			newProduct = new Product(name,price,ItemType.IMPORTED_MEDICAL);
                        		} else if(exemptedType == "chocolate"){
                        			newProduct = new Product(name,price,ItemType.IMPORTED_FOOD);
                        		}

                        	} else {
                        		//the product is imported and sales taxed
                        		newProduct = new Product(name,price,ItemType.IMPORTED_OTHERS);
                        	}
                        	
                    	} else {
                    		//the product is domestic
                        	if(exemptedType != null){
                        		//the product is domestic and is exempt of sales tax
                        		
                        		if(exemptedType == "book"){
                        			newProduct = new Product(name,price,ItemType.BOOK);
                        		} else if(exemptedType == "pills"){
                        			newProduct = new Product(name,price,ItemType.MEDICAL);
                        		} else if(exemptedType == "chocolate"){
                        			newProduct = new Product(name,price,ItemType.FOOD);
                        		}

                        	} else {
                        		//the product is domestic and is sales taxed
                        		newProduct = new Product(name,price,ItemType.OTHERS);
                        	}
                    	}
                    	
                        productsList.add(newProduct); //add the product to our receipt's list
                    }
            	}
            	
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	public void calculateTotals(){
		/*
		 * This method runs through the receipt's list of products in order to calculate the sales tax and total
		 * BigDecimals are used in order to avoid rounding errors
		 * 
		 */
		int numOfItems = productsList.size();
		
		BigDecimal runningSum = new BigDecimal("0");
		BigDecimal runningTaxSum = new BigDecimal("0");
		
		for(int i = 0;i<numOfItems;i++){
			
			runningTaxSum = BigDecimal.valueOf(0);
			
			BigDecimal totalBeforeTax = new BigDecimal(String.valueOf(this.productsList.get(i).getPrice()));
			
			runningSum = runningSum.add(totalBeforeTax);
			
			if(productsList.get(i).isSalesTaxable()){
				//This item is sales taxable so charge 10% tax and round to the nearest 0.05
			
			    BigDecimal salesTaxPercent = new BigDecimal(".10");
			    BigDecimal salesTax = salesTaxPercent.multiply(totalBeforeTax);
			    
			    salesTax = GeneralUtil.round(salesTax, BigDecimal.valueOf(0.05), RoundingMode.UP);
			    runningTaxSum = runningTaxSum.add(salesTax);
			    
    
			} 
			
			if(productsList.get(i).isImportedTaxable()){
				//this item is import taxable so charge 5% tax and round to the nearest 0.05

			    BigDecimal importTaxPercent = new BigDecimal(".05");
			    BigDecimal importTax = importTaxPercent.multiply(totalBeforeTax);
			    
			    importTax = GeneralUtil.round(importTax, BigDecimal.valueOf(0.05), RoundingMode.UP);
			    runningTaxSum = runningTaxSum.add(importTax);
			   
			}

			
			productsList.get(i).setPrice(runningTaxSum.floatValue() + productsList.get(i).getPrice());
		
			taxTotal += runningTaxSum.doubleValue();
			
			runningSum = runningSum.add(runningTaxSum);
		}
			//save out sales tax, and total
			taxTotal = GeneralUtil.roundTwoDecimals(taxTotal);
			total = runningSum.doubleValue();
	}

	
	public void printReceipt(){
		/*
		 * Print all the information about the Receipt  
		 * 
		 */
		int numOfItems = productsList.size();
		for(int i = 0;i<numOfItems;i++){
			System.out.println("1" + productsList.get(i).getName() + "at " + productsList.get(i).getPrice());
		}
		System.out.printf("Sales Tax: %.2f\n", taxTotal);
		System.out.println("Total: " + total);
	}
	
}
