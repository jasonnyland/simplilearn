import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;
public class App {

	
	public static ArrayList<ArrayList<Integer>> returnLongestIncreasing (ArrayList<ArrayList<Integer>> results, ArrayList<Integer> input) {
			
		if (input.size() < 1) {
			return results;
		} else if (input.size() == 1) {
			results.add(input);
			AtomicInteger greatest = new AtomicInteger(1);
			results.forEach(x -> {
				if (x.size() > greatest.intValue()) {
					greatest.set(x.size());
				}
			});
			return results.stream()
					.filter(result -> result.size() == greatest.intValue())
					.collect(toCollection(ArrayList::new));
		} else {
			ArrayList<Integer> newSub = new ArrayList<>();
			AtomicInteger last = new AtomicInteger(0);
			input.forEach(x -> {
				if (newSub.isEmpty()) {
					newSub.add(x);
					last.set(x);
				} else if ( x > last.intValue() ) {
					newSub.add(x);
					last.set(x);
				}
			});
			results.add(newSub);
			input.remove(0);
			return returnLongestIncreasing(results, input);
		}
		
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> test = new ArrayList<>(Arrays.asList(10,9,2,5,2,3,7,101,18));
		//ArrayList<ArrayList<Integer>> results = new ArrayList<>;
		
		System.out.println("Input: " + test);
		System.out.println("Output: " + returnLongestIncreasing(new ArrayList<ArrayList<Integer>>(), test));
		
	}

}
