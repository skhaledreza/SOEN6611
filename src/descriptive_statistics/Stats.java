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
	
	

}
