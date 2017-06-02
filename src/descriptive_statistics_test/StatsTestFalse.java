package descriptive_statistics_test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import descriptive_statistics.Stats;

public class StatsTestFalse {

	static ArrayList<Float> data =  new ArrayList<Float>();
	Stats stats = new Stats();
	
	 @BeforeClass
     public static void runOnceBeforeClass() {
    	data.add((float) 92.263794);
    	data.add((float) 98.74878);
    	data.add((float) 45.285034);
    	data.add((float) 2.4291992);
    	data.add((float) 92.49573);
    	data.add((float) 37.213135);
    	data.add((float) 8.505249);
    	data.add((float) 44.89746);
    	data.add((float) 46.047974);
    	data.add((float) 7.9040527);
    }

    @AfterClass
    public static void runOnceAfterClass() {
//        System.out.println("@AfterClass - runOnceAfterClass");
    }

    @Before
    public void runBeforeTestMethod() {
//        System.out.println("@Before - runBeforeTestMethod");
    }

    @After
    public void runAfterTestMethod() {
//        System.out.println("@After - runAfterTestMethod");
    }

	    
    @Test
	public void testCalculateMinVal() {
    	stats.setMinVal(stats.calculateMinVal(data));
    	float minValue = stats.getMinVal();
    	float actualMinValue = (float) 92.263794;
    	assertNotEquals(minValue, actualMinValue, 0.0001);
    	System.out.println("testCalculateMinVal passed");
	}

}
