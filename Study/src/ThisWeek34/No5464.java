package ThisWeek34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class No5464 {
	static int N, M;
	static int[] cars;
	static PriorityQueue<Park5464> park;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		Rs = new int[N];
		cars = new int[N];
		
		br.close();
	}
}

class Park5464 implements Comparable<Park5464>{
	int idx;
	int Rs;
	
	@Override
	public int compareTo(Park5464 o) {
		if(this.Rs == o.Rs)
			return this.idx - o.idx;
		return this.Rs - o.Rs;
	}
}