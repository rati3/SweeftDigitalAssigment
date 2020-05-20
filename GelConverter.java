package sweeftDigital_gelToUSD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import jdk.internal.org.objectweb.asm.commons.GeneratorAdapter;


public class GelConverter {
	
	
	public static void main(String []args) throws IOException  {
		String url =  "http://www.nbg.ge/rss.php";
		getRate(url);
		
				
	}
	
	/** Method converts GEL to USD */
	public double gelToUsd(double gel) {
		
		return gel / RATE;
	}
	
	/** Get rate from URL */
	private static void getRate(String url) throws IOException {
		URL convertionRates = new URL(url);
		
		String sourceCode = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(convertionRates.openStream(),"UTF-8"))) {
			String line;
			while ((line = br.readLine()) != null) { // save source code 
				 sourceCode += line;
			}
		} 
	
		Scanner scan = new Scanner(sourceCode);   
        scan.useDelimiter(CURRENCY);
        scan.next();
        String afterCurrency = scan.next();
		String rate = afterCurrency.substring(DISTANCE_FROM, RATE_LENGTH + DISTANCE_FROM);
       
        scan.close();
        
		// save rate
		RATE = Double.parseDouble(rate);
		System.out.print(RATE);
		
	}
	
	/* length of string rate */
	private static final int RATE_LENGTH = 6;
	
	/* distance between "USD" and rate */
	private static final int DISTANCE_FROM = 36;
	
	private static final String CURRENCY = "USD";
	
	private static double RATE;
}
