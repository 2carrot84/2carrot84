package codility.arrays;

import java.util.LinkedHashSet;
import java.util.Set;

public class OddOccurrencesInArray {
	public static void main(String[] args) {
		OddOccurrencesInArray o = new OddOccurrencesInArray();
		int[] A = {9,9,9};
		System.out.println(o.solution(A));
	}
	
	// https://codility.com/demo/results/trainingBFFHD3-C6P/
	public int solution(int[] A) {
		Set<Integer> set = new LinkedHashSet<Integer>();
		
		for (int i : A) {
			if(set.contains(i))
				set.remove(i);
			else 
				set.add(i);
		}
		
		return set.iterator().next();
	}
}
