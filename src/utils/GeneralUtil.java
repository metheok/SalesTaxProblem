package utils;
import java.text.DecimalFormat;
import java.math.*;
import java.util.ArrayList;

public class GeneralUtil{
    public static double roundTwoDecimals(double d) {
		//A rounding method for double values to 2 decimals
	    DecimalFormat twoDForm = new DecimalFormat("#.##");
	    return Double.valueOf(twoDForm.format(d));
	}


    public static BigDecimal round(BigDecimal value, BigDecimal increment,RoundingMode roundingMode) {
		/*
		 * This method handles custom rounding to 0.05, and also sets the BigDecimal numbers to use 2 decimals
		 * 
		 */
		if (increment.signum() == 0) {
		// 0 increment does not make much sense, but prevent division by 0
		return value;
		} else {
			BigDecimal divided = value.divide(increment, 0, roundingMode);
			BigDecimal result = divided.multiply(increment);
			result.setScale(2, RoundingMode.UNNECESSARY);
			return result;
		}
	}

    public static int containsItemFromArray(String inputString, String[] items) {
		/*
		 * This method returns the index of which String in items was found in the input String
		 *  -1 is returned in none of the Strings in items are found in the inputString
		 */
		int index = -1;
		
		for(int i = 0;i<items.length;i++){
			
			index = inputString.indexOf(items[i]);

			if(index != -1)
				return i;
				
		}
		return -1;
		
	}
}