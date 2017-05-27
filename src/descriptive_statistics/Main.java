package descriptive_statistics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String fileName = "G:/workspace/DescriptiveStatistics/values.txt";
		
		System.out.println("========== Welcome to Descriptive-Statistics ==========");
		
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
