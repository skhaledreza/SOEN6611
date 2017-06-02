package descriptive_statistics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String fileName = "G:/workspace/DescriptiveStatistics/values.txt";
		
		System.out.println("========== Welcome to Descriptive-Statistics ==========");
		
		System.out.println("How many random number do you want?");
		
		Scanner quantityScanner = new Scanner(System.in);
		int quantity = quantityScanner.nextInt();
		
		System.out.println("You want a sequence of " + quantity + " numbers.");
		
		RandomNumberSequence r = new RandomNumberSequence();

		System.out.println("Your sequence is: ");
		
		ArrayList<Float> data =  new ArrayList<Float>();
        for (int i = 0; i < quantity; i++) {
        	float a = Math.round(r.next()*100);
        	data.add(a);
        	System.out.println(a);
        }
        
        /*
		String line = null;
		
		String[] values = null;
		ArrayList<Float> data =  new ArrayList<Float>();
		
		try {
			System.out.println("==> Reading file " + fileName + " ...");
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                values = line.split(",");
            }
            bufferedReader.close();         
		} catch (Exception e) {
			System.out.println("Error reading file" + e);
		}
			
		for (int i = 0; i < values.length; i++) {
			data.add(Float.parseFloat(values[i]));
		}
		*/
        
		Stats stats = new Stats();
		stats.setMinVal(stats.calculateMinVal(data));
		stats.setMaxVal(stats.calculateMaxVal(data));
		stats.setMode(stats.calculateMode(data));
		stats.setMedian(stats.calculateMedian(data));
		stats.setArithMean(stats.calculateArithmeticMean(data));
		stats.setStandDev(stats.calculateStandardDeviation(data));
		System.out.println(stats.toString());
		
		
	}

}
