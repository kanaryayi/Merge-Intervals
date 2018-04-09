
import java.util.Map.Entry;
import java.util.TreeMap;

public class MergeIntervalsAll {
	public static void main(String[] args) {
		//int[][] intervals = {{0,3},{-20,15},{2,6},{15,18},{8,10}};
		int[][] intervals = {{1,3},{3,6},{10,15},{10,14}};
		
		//int intervalsSize = intervals.length;
		
		//HashMap<Integer, Integer> merge = new HashMap<>();
		
		//sorting data automatically
		TreeMap<Integer, Integer> merge = new TreeMap<>();
		
		//int min = intervals[0][0];
		//int max = intervals[0][1];
		
		//put start values with -1 degree
		//put end values with +1 degree
		for(int[] interval : intervals) {

			int start = interval[0];
			int end = interval[1];
			
			/*if(start<min) {
				min = start;
			}
			if(end>max) {
				max = end;
			}*/
			
			try {
				merge.put(start, merge.get(start)-1);
			}
			catch (Exception e) {
				merge.put(start, -1);
			}
			try {
				merge.put(end, merge.get(end)+1);
			}
			catch (Exception e) {
				merge.put(end, 1);
			}
			
			
		}
		//System.out.println(merge.toString());
		int totalDegree = 0;
		int[] interval = new int[2];
		
		//search each degrees of values and for each round that totalDegree becomes less than zero
		//start a interval.
		//for each round that totalDegree becomes 0 
		//end a interval.
		for(Entry<Integer, Integer> entry:merge.entrySet()) {
			int number = entry.getKey();
			int degree = entry.getValue();
			//System.out.println(number+" "+degree+" "+totalDegree);
			totalDegree += degree;
			if(totalDegree-degree==0) {
				
				interval[0] = number;
			}
			if(totalDegree==0 && degree>0) {
				interval[1] = number;
				System.out.println(interval[0]+" "+interval[1]);
			}
			
		}
	}
}
