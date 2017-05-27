package descriptive_statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Stats {
	
	private float minVal;
	private float maxVal;
	private ArrayList<Float> mode;
	private float median;
	private float arithMean;
	private float standDev;
	
	
	public Stats() {
		
	}

	public Stats(float minVal, float maxVal, ArrayList<Float> mode, float median, float arithMean, float standDev) {
		this.minVal = minVal;
		this.maxVal = maxVal;
		this.mode = mode;
		this.median = median;
		this.arithMean = arithMean;
		this.standDev = standDev;
	}
	
	public float getMinVal() {
		return minVal;
	}

	public void setMinVal(float minVal) {
		this.minVal = minVal;
	}

	public float getMaxVal() {
		return maxVal;
	}

	public void setMaxVal(float maxVal) {
		this.maxVal = maxVal;
	}

	public ArrayList<Float> getMode() {
		return mode;
	}

	public void setMode(ArrayList<Float> mode) {
		this.mode = mode;
	}

	public float getMedian() {
		return median;
	}

	public void setMedian(float median) {
		this.median = median;
	}

	public float getArithMean() {
		return arithMean;
	}

	public void setArithMean(float arithMean) {
		this.arithMean = arithMean;
	}

	public float getStandDev() {
		return standDev;
	}

	public void setStandDev(float standDev) {
		this.standDev = standDev;
	}
	

	@Override
	public String toString() {
		return "Stats [minVal=" + minVal + ", maxVal=" + maxVal + ", mode=" + mode + ", median=" + median
				+ ", arithMean=" + arithMean + ", standDev=" + standDev + "]";
	}

	public float calculateMinVal(ArrayList<Float> data) {
		float calculatedMinVal = data.get(0);
		for (int i = 1; i < data.size(); i++) {
			if(calculatedMinVal > data.get(i)) {
				calculatedMinVal = data.get(i);
			}			
		}
		return calculatedMinVal;
	}
	
	public float calculateMaxVal(ArrayList<Float> data) {		
		float calculatedMaxVal = data.get(0);
		for (int i = 1; i < data.size(); i++) {
			if(calculatedMaxVal < data.get(i)) {
				calculatedMaxVal = data.get(i);
			}			
		}
		return calculatedMaxVal;
	}
	
	public ArrayList<Float> calculateMode(ArrayList<Float> data) {
		Map<Float, Integer> modeMap = new HashMap<Float, Integer>();
		for (int i = 0; i < data.size(); i++) {
			float val = data.get(i);
			if(modeMap.get(val) != null) {
				int count = modeMap.get(val);
				count = count + 1;
				modeMap.put(val, count);
			} else {
				modeMap.put(val, 1);
			}
		}
		
		int mode = 0;
		for (float i = (float) 1.0; i < modeMap.size(); i++) {
			if(mode < modeMap.get(i)) {
				mode = modeMap.get(i);
			}
		}
		
		ArrayList<Float> calculatedMode =  new ArrayList<Float>();
		
		for (Entry<Float, Integer> entry : modeMap.entrySet()) {
            if (entry.getValue().equals(mode)) {
            	calculatedMode.add(entry.getKey());
            }
        }
		
		return calculatedMode;
		
	}
	
	public float calculateMedian(ArrayList<Float> data) {
		ArrayList<Float> sortedList =  new ArrayList<Float>();
		sortedList = sortList(data);
		
		float calculatedMedian = (float) 0.0;
		if (sortedList.size() % 2 == 0) {
			ArrayList<Float> listForMean = new ArrayList<Float>();
			listForMean.add(sortedList.get((sortedList.size())/2));
			listForMean.add(sortedList.get((sortedList.size()-1)/2));
			calculatedMedian = calculateArithmeticMean(listForMean);
		} else {
			calculatedMedian = sortedList.get((sortedList.size()-1)/2);
		}
		
		return calculatedMedian;
	}
	
	public float calculateArithmeticMean(ArrayList<Float> data) {
		float sum = 0;
	    for (int i = 0; i < data.size(); i++) {
	        sum += data.get(i);
	    }
	    return sum / data.size();
		
	}
	
	public float calculateStandardDeviation(ArrayList<Float> data) {
		float arithmeticMean = calculateArithmeticMean(data);
		float sum = (float) 0.0;
		
		for (int i = 0; i < data.size(); i++) {
			float tmp = data.get(i) - arithmeticMean;
			tmp = tmp * tmp;
	        sum += tmp;
	    }
		
		float temp = sum / data.size();
		
		float calculatedStandardDeviation = sqrt(temp);
		return calculatedStandardDeviation;
		
	}
	
	// Bubble sort to sort array
	private ArrayList<Float> sortList(ArrayList<Float> data) {		
		for (int i = 0; i < data.size(); i++) {
	        for (int j = i + 1; j < data.size(); j++) {
	            float tmp = 0;
	            if (data.get(i) > data.get(j)) {
	                tmp = data.get(i);
	                data.set(i, data.get(j));
	                data.set(j, tmp);
	            }
	        }
	    }
		return data;
		
	}
	
	
	private float sqrt(float number) {
		float t;
	 
		float squareRoot = number / 2;
	 
		do {
			t = squareRoot;
			squareRoot = (t + (number / t)) / 2;
		} while ((t - squareRoot) != 0);
	 
		return squareRoot;
	}
	
	

}
