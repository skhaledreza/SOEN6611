package descriptive_statistics;

public class RandomNumberSequence {
	
    // Linear congruential values for x(i+1) = (a * x(i) + b) % m.
    final static int a = 25173;
    final static int b = 13849;
    final static int m = 32768;

    // Current value for returning.
    int x;

    public RandomNumberSequence() {
        // Constructor simply sets value to half of m, equivalent to 0.5.
        x = m / 2;
    }

    double next() {
        // Calculate next value in sequence.
        x = (a * x + b) % m;

        // Return its 0-to-1 value.
        return (double)x / m;
    }

}
