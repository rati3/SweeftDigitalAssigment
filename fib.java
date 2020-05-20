package sweeftDigital_fib;

import javafx.util.Pair;

public class fib {
	
	/** Method return n, n+1 fibonacci pair */
	private static Pair<Integer, Integer> fibPair(int n) {
	    if (n == 0) { // Base Case
	       Pair<Integer, Integer> result = new Pair<>(1, 1);
	       return result;
	    }
	    // do recursion  fib(n) = fib(n - 1) + fib(n - 2)
	    Pair<Integer, Integer> prev = fibPair(n - 1);
	    int first = prev.getKey();
	    int second = prev.getValue();
	    Pair<Integer, Integer> result = new Pair<>(second, first + second);
	    
	    return result;
	}
	
	public static int getFib(int n) {
	    Pair<Integer, Integer> pair = fibPair(n);
	    int res = pair.getKey();
	    
	    return res;
    }

}
