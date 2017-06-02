package descriptive_statistics_test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import descriptive_statistics.Stats;

public class StatsTest {
	
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
    	float actualMinValue = (float) 2.4291992;
    	assertEquals(minValue, actualMinValue, 0.0001);
    	System.out.println("testCalculateMinVal passed");
	}
    
    @Test
	public void testCalculateMaxVal() {
    	stats.setMaxVal(stats.calculateMaxVal(data));
    	float maxValue = stats.getMaxVal();
    	float actualMaxValue = (float) 98.74878;
    	assertEquals(maxValue, actualMaxValue, 0.0001);
    	System.out.println("testCalculateMaxVal passed");
	}
    
    @Test
	public void testCalculateMode() {
    	stats.setMode(stats.calculateMode(data));
    	ArrayList<Float> mode =  stats.getMode();
    	ArrayList<Float> actualMode = new ArrayList<Float>();
    	actualMode.add((float) 0.0);
    	assertEquals(mode, actualMode);
    	System.out.println("testCalculateMode passed");
	}
    
    @Test
	public void testCalculateMedian() {
    	stats.setMedian(stats.calculateMedian(data));
    	float median = stats.getMedian();
    	float actualMedian = (float) 45.091248;
    	assertEquals(median, actualMedian, 0.0001);
    	System.out.println("testCalculateMedian passed");
	}
    
    @Test
	public void testCalculateArithmeticMean() {
    	stats.setArithMean(stats.calculateArithmeticMean(data));
    	float mean = stats.getArithMean();
    	float actualMean = (float) 47.57904;
    	assertEquals(mean, actualMean, 0.0001);
    	System.out.println("testCalculateArithmeticMean passed");
	}
    
    @Test
	public void testCalculateStandardDeviation() {
    	stats.setStandDev(stats.calculateStandardDeviation(data));
    	float stanDev = stats.getStandDev();
    	float actualStanDev = (float) 34.487972;
    	assertEquals(stanDev, actualStanDev, 0.0001);
    	System.out.println("testCalculateStandardDeviation passed");
	}
    
}
